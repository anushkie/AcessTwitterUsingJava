package com.uea.tweet.covid.twitter;

import twitter4j.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TweetFetcher {

    private static final Logger LOGGER = Logger.getLogger(TweetFetcher.class.getName());
    private final Twitter twitter;

    @Inject
    public TweetFetcher(Twitter twitter) {
        this.twitter = twitter;
    }

    public List<TweetData> fetch(String keyword) {
        List<TweetData> toReturn = new ArrayList<>();

        Query query = createQuery(keyword);

        try {
            while (true) {
                QueryResult result = twitter.search(query);

                for (Status tweet : result.getTweets()) {
                    if (!tweet.isRetweet()) {
                        toReturn.add(new TweetData(tweet.getText(), tweet.getUser().getLocation()));
                    }
                }

                if (result.hasNext()) {
                    if (toReturn.size() > 1000) {
                        return toReturn;
                    }

                    query = result.nextQuery();
                    LOGGER.log(Level.FINER, "Going to next page");
                } else {
                    break;
                }
            }
        } catch (TwitterException e) {
            LOGGER.log(Level.WARNING, "An exception occurred {}", e);
        }

        return toReturn;
    }

    private Query createQuery(String keyword) {
        Query query = new Query(keyword);
        query.setCount(100);
        query.setLang("en");

        return query;
    }
}
