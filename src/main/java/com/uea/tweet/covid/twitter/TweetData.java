package com.uea.tweet.covid.twitter;

public class TweetData {

    private final String tweet;
    private final String location;

    public TweetData(String tweet, String location) {
        this.tweet = tweet;
        this.location = location;
    }

    public String getTweet() {
        return tweet;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "TweetData{" +
                "tweet='" + tweet + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
