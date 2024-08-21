package com.factweavers.authenticationservice.domain;

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

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class TopicExtractor2 {
    Logger logger = LogManager.getLogger(this.getClass());
    ByteBuffersDirectory ramDirectory ;
    StandardAnalyzer analyzer ;
//    IndexWriterConfig config ;
//    IndexWriter indexWriter ;

    public TopicExtractor2() throws IOException {
        ramDirectory = new ByteBuffersDirectory();
        analyzer = new StandardAnalyzer();
//        config = new IndexWriterConfig(analyzer);
//        indexWriter = new IndexWriter(ramDirectory, config);
    }

    public List<Topic> findTopics(String comment) throws Exception {
        List<Topic> topics = findTopicsUsingLucene(comment);
        logger.info("Received topics -> " + topics.size());
        return topics;
    }

    private List<Topic> findTopicsUsingLucene(String text) throws Exception {
        List<Topic> topics = new ArrayList<>();
        Reader reader = new FileReader("src/main/resources/topic_library_new.csv");
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        createDocumentForSearch(text);
        for (CSVRecord record : csvParser) {
            String topic = record.get(0);
            String keyword = record.get(1);
            if (findMatchingTopics(text, keyword)) {
                topics.add(new Topic(topic));
            }
        }
        logger.info("Entities Matched -> " + topics);
        return topics;
    }

    private void createDocumentForSearch(String text) throws IOException {
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(ramDirectory, config);

        Document doc = new Document();
        doc.add(new TextField("content", text, TextField.Store.YES));
        indexWriter.addDocument(doc);
        indexWriter.close();
    }

    private boolean findMatchingTopics(String text, String keyword) throws IOException {
//        ByteBuffersDirectory ramDirectory = new ByteBuffersDirectory();
//        StandardAnalyzer analyzer = new StandardAnalyzer();

//        IndexWriterConfig config = new IndexWriterConfig(analyzer);
//        IndexWriter indexWriter = new IndexWriter(ramDirectory, config);
//
//        Document doc = new Document();
//        doc.add(new TextField("content", text, TextField.Store.YES));
//        indexWriter.addDocument(doc);
//        indexWriter.close();

        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(ramDirectory));
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
}
