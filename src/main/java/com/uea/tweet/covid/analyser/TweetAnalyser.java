package com.uea.tweet.covid.analyser;

import com.uea.tweet.covid.twitter.TweetData;

import java.util.List;

public interface TweetAnalyser {

    List<AnalysisResult> analyse(List<TweetData> tweetsToAnalyse);
}
