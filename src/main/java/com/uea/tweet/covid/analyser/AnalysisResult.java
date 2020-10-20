package com.uea.tweet.covid.analyser;

import com.uea.tweet.covid.twitter.TweetData;

public class AnalysisResult {

    private final TweetData data;
    private final Outlook outlook;

    public AnalysisResult(TweetData data, Outlook outlook) {
        this.data = data;
        this.outlook = outlook;
    }

    public TweetData getData() {
        return data;
    }

    public Outlook getOutlook() {
        return outlook;
    }

    @Override
    public String toString() {
        return "AnalysisResult{" +
                "data=" + data +
                ", outlook=" + outlook +
                '}';
    }

    public enum Outlook {
        POSITIVE,
        NEGATIVE,
        UNKNOWN
    }
}
