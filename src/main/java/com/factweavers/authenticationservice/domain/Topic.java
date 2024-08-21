package com.factweavers.authenticationservice.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Topic {

    public Topic(){

    }

    public Topic(String topic, Double score, int count){
        this.topic=topic;
        this.score=score;
        this.count=count;
    }
    public Topic(String topic){
        this.topic=topic;
    }
    String topic;
    Double score;
    int count;
    Set<String> matches;
    List<String> sentiments;
    List <Map<String, Double>> scores;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<String> getMatches() {
        return matches;
    }

    public void setMatches(Set<String> matches) {
        this.matches = matches;
    }

    public List<String> getSentiments() {
        return sentiments;
    }

    public void setSentiments(List<String> sentiments) {
        this.sentiments = sentiments;
    }
    public List <Map<String, Double>> getScores() {
        return scores;
    }

    public void setScores(List <Map<String, Double>> scores) {
        this.scores = scores;
    }
    @Override
    public String toString() {
        return "Topic{" +
                "topic='" + topic + '\'' +
                ", score=" + score +
                ", count=" + count +
                ", matches=" + matches +
                ", sentiments=" + sentiments +
                '}';
    }
}
