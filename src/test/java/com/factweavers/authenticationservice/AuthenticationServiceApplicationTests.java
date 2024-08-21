package com.factweavers.authenticationservice;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.factweavers.authenticationservice.domain.Topic;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AuthenticationServiceApplicationTests {
	Logger logger = LogManager.getLogger(AuthenticationServiceApplicationTests.class.getName());


	@Test
	void contextLoads() {
	}



	@Test
	public void topicExtractionTest2() throws Exception {
		String comment = " improvement is important because people who feel challenged to excel in a healthy way " +
				"can be more engaged and satisfied with their jobs. When people feel supported by their leadership with both " +
				"positive feedback and constructive criticism, they are more likely to grow in their career and become a more " +
				"effective contributor over time";
		List<Topic> topics = findTopics(comment);
		System.out.println("Processed Comment -> " + topics);

	}

	public List<Topic> findTopics(String comment) throws Exception {
		List<Topic> topics = findTopicsUsingLucene(comment);
		System.out.println("Received topics -> " + topics.size());
		return topics;
	}

	private List<Topic> findTopicsUsingLucene(String text) throws Exception {
		List<Topic> topics = new ArrayList<>();
		Reader reader = new FileReader("src/main/resources/topic_library_new.csv");
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
		for (CSVRecord record : csvParser) {
			String topic = record.get(0);
			String keyword = record.get(1);
			if (findMatchingTopics(text, keyword)) {
				topics.add(new Topic(topic));
			}
		}
		System.out.println("Entities Matched -> " + topics);
		return topics;
	}

	private static boolean findMatchingTopics(String text, String keyword) throws IOException {
		ByteBuffersDirectory directory = new ByteBuffersDirectory();
		StandardAnalyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		IndexWriter indexWriter = new IndexWriter(directory, config);

		Document doc = new Document();
		doc.add(new TextField("content", text, TextField.Store.YES));
		indexWriter.addDocument(doc);
		indexWriter.close();

		IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(directory));
		QueryParser queryParser = new QueryParser("content", analyzer);

		try {
			Query query = queryParser.parse(keyword);
			TopDocs topDocs = searcher.search(query, 1);
			System.out.println("Total matching topics: " + topDocs.totalHits);
			for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
				Document document = searcher.doc(scoreDoc.doc);
				System.out.println("Matched text: " + keyword + "::" + document.get("content"));
				return true;
			}
		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Test
	public void S3Test() throws Exception {
		String bucketName = "nidhin-alungal-bucket";
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
		Bucket bucket = null;
		if (s3.doesBucketExistV2(bucketName)) {
			logger.error("Bucket already exists.");
		} else {
			try {
				bucket = s3.createBucket(bucketName);
				logger.info("Bucket created Successfully");
			} catch (AmazonS3Exception e) {
				logger.error(e.getErrorMessage());
			}
		}

	}

}
