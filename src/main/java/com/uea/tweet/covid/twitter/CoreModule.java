package com.uea.tweet.covid.twitter;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.inject.Singleton;

public class CoreModule extends AbstractModule {

    private static final String API_KEY = "fdTF74QPFcJDoTkI4bJdLuKrH";
    private static final String API_SECRET = "bBz6Jcmgedy6zBTanVl0yPhbyUUVmivnNgQldzCDgdOKj1vdFI";
    private static final String BEARER_TOKEN = "AAAAAAAAAAAAAAAAAAAAAFS4IwEAAAAAW0qVCbIzrvFmu1RdiFRPzklPCAU%3DBbrcTr9gCmhye5o1vVb4VX3CFLdPcMFpJJp5Ao82Z9BnNT4mq1";
    private static final String ACCESS_TOKEN = "1277857477-6VXj5mJfwZcl76sCSm21MJdbcnAFiFhdI6udPUj";
    private static final String ACCESS_TOKEN_SECRET = "3Tza0jyRTorSl4t1FjeQRom5Ys9QOdLSZ4IAHvYqkHkQo";

    @Provides
    @Singleton
    Twitter provideTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(API_KEY)
                .setOAuthConsumerSecret(API_SECRET)
                .setOAuthAccessToken(ACCESS_TOKEN)
                .setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);

        return new TwitterFactory(cb.build()).getInstance();
    }
}
