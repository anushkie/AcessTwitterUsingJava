package com.uea.tweet.covid.analyser;

import com.google.inject.AbstractModule;

public class AnalysisModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(TweetAnalyser.class).to(SlangBasedAnalyser.class);
    }
}
