package com.uea.tweet.covid;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.uea.tweet.covid.analyser.AnalysisModule;
import com.uea.tweet.covid.analyser.AnalysisResult;
import com.uea.tweet.covid.analyser.TweetAnalyser;
import com.uea.tweet.covid.twitter.CoreModule;
import com.uea.tweet.covid.twitter.TweetData;
import com.uea.tweet.covid.twitter.TweetFetcher;

import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new CoreModule(),
                new AnalysisModule()
        );

        TweetFetcher tweetFetcher = injector.getInstance(TweetFetcher.class);
        TweetAnalyser analyser = injector.getInstance(TweetAnalyser.class);

        List<TweetData> tweetData = tweetFetcher.fetch("covid");
        List<AnalysisResult> analysisResults = analyser.analyse(tweetData);

        int negativeCount = 1;

        for (int i = 0; i < analysisResults.size(); i++) {
            AnalysisResult result = analysisResults.get(i);
            if (result.getOutlook() == AnalysisResult.Outlook.NEGATIVE) {
                System.out.println("Tweet Number " + (negativeCount++)  + ". Tweet -> " + result.getData().getTweet());
            }
        }
    }
}
