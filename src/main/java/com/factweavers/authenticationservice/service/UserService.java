package com.factweavers.authenticationservice.service;

import com.factweavers.authenticationservice.domain.*;
import com.factweavers.authenticationservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {

    @Inject
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDatabase = this.userRepository.findByEmail(username);

        if (userFromDatabase == null)
            throw new UsernameNotFoundException(String.format("No user found with username '%s'", username));

        Set<Role> userRoles = userFromDatabase.getUserRoles();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        userRoles.stream().forEach(userRole -> {
            userRole.getRoleScopes().stream().forEach(roleScope -> {
                grantedAuthorities.add(new SimpleGrantedAuthority(roleScope.getAccessFeatures()));
            });
        });


        CustomUserDetails user = new CustomUserDetails(userFromDatabase.getUserId(), userFromDatabase.getEmail(), userFromDatabase.getPassword(), grantedAuthorities, userFromDatabase.getStatus());
        log.info("Exiting loadUserByUsername service");
        return user;
    }

    public String lucene() throws Exception {
        String comment = "Professional improvement is important because people who feel challenged to excel in a healthy way " +
                "can be more engaged and satisfied with their jobs. When people feel supported by their leadership with both " +
                "positive feedback and constructive criticism, they are more likely to grow in their career and become a more " +
                "effective contributor over time decision interesting men n/a";
        TopicExtractor2 topicExtractor = new TopicExtractor2();
        List<Topic> topics = topicExtractor.findTopics(comment);
        System.out.println("Processed Comment -> " + topics);
        return topics.toString();
    }


    public String analyzeText(String content, String queryString) throws Exception {
        // Use a RAMDirectory to simulate in-memory indexing
        ByteBuffersDirectory ramDirectory = new ByteBuffersDirectory();
        StandardAnalyzer analyzer = new StandardAnalyzer();

        // Create an IndexWriter to write the document to RAMDirectory
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(ramDirectory, config);

        // Create a document with a field named "content" to index
        Document doc = new Document();
        doc.add(new TextField("content", content, Field.Store.YES));
        // Add the document to the RAMDirectory
        indexWriter.addDocument(doc);
        indexWriter.close(); // Close the IndexWriter after adding the document

        // Create an IndexReader and IndexSearcher on top of the RAMDirectory
        DirectoryReader directoryReader = DirectoryReader.open(ramDirectory);
        IndexSearcher searcher = new IndexSearcher(directoryReader);

        // Parse the provided query
        QueryParser queryParser = new QueryParser("content", analyzer);
        Query query = queryParser.parse(queryString);

        // Use the searcher to match the document against the query
        TopDocs topDocs = searcher.search(query, 1);

        // Close the IndexReader after using it
        directoryReader.close();

        // Check if the document matches the query
        if (topDocs.totalHits.value > 0) {
            System.out.println("Matching document: " + content);
            return "Matching document: " + content;
        }
        return "EMPTY";
    }

    private static boolean findMatchingTopics(String topic, String keyword) throws IOException {
        // Initialize Lucene index
//        RAMDirectory ramDirectory = new RAMDirectory();
        ByteBuffersDirectory ramDirectory = new ByteBuffersDirectory();
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(ramDirectory, config);

        // Index the topic
        Document doc = new Document();
        doc.add(new TextField("content", topic, TextField.Store.YES));
        indexWriter.addDocument(doc);
        indexWriter.close();

        // Create Lucene query parser
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(ramDirectory));
        QueryParser queryParser = new QueryParser("content", analyzer);

        // Execute Lucene query
        try {
            Query query = queryParser.parse(keyword);
            TopDocs topDocs = searcher.search(query, 1);
            System.out.println("Total matching topics: " + topDocs.totalHits);
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                Document document = searcher.doc(scoreDoc.doc);
                System.out.println("Matched topic: " + keyword + "::" + document.get("content"));
                return true;
            }
        } catch (org.apache.lucene.queryparser.classic.ParseException e) {
            e.printStackTrace();
        }
        return false;
    }


}
