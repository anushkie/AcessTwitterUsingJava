package com.uea.tweet.covid.analyser;

import com.uea.tweet.covid.twitter.TweetData;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class SlangBasedAnalyser implements TweetAnalyser {

    private static final String[] PROHIBITED_WORDS = {"anal", "anus", "arse", "ballsack", "bastard", "bitch", "biatch",
            "bloody", "blowjob", "blow jobbollock", "bollok", "boner", "boob", "bum", "buttplug", "clitoris", "cock", "coon",
            "cunt", "dick", "dildo", "dyke", "fag", "feck", "fellate", "fellatio", "felching", "fuck", "f u c k", "fudgepacker", "fudge packer",
            "flange", "Goddamn", "God damn", "homo", "jerk", "jizz", "knobend", "knob end", "labia", "muff", "nigger", "nigga",
            "penis", "piss", "prick", "pube", "pussy", "queer", "scrotum", "shit", "s hit", "sh1t", "slut", "smegma", "spunk" ,
            "tosser", "twat", "vagina", "wank", "whore", "sux", "this game sux", "sexy", "f*ck",
            "Fuck", "Fuk", "Shit", "Sht", "Pussy", "Puzzy", "Cunt", "Niggar", "Nigga", "Nigger", "Bitch", "Btch", "Fag", "Faggot",
            "MotherFucker", "Twat", "Arse", "Douche", "Douchebag",
            "Arsehole", "Bastard", "Basterd", "Bellend", "Bollocks", "Cock", "Dick", "Dickhead", "Dik", "Feck",
            "Knob", "Tosser", "Wanker", "Paedophile", "Whore", "Bullshit", "Dildo", "Slag", "Slut"};

    private static final Set<String> WORDS = new HashSet<>(PROHIBITED_WORDS.length);

    static {
        for (String word : PROHIBITED_WORDS) {
            String toLowerCase = word.toLowerCase();
            WORDS.add(toLowerCase);
        }
    }

    @Override
    public List<AnalysisResult> analyse(List<TweetData> tweetsToAnalyse) {
        List<AnalysisResult> list = new ArrayList<>();

        for (TweetData tweetData : tweetsToAnalyse) {
            AnalysisResult analyse = analyse(tweetData);
            list.add(analyse);
        }

        return list;
    }

    private AnalysisResult analyse(TweetData tweetData) {
        String textLowerCase = tweetData.getTweet().toLowerCase(Locale.ENGLISH);

        for (String word : WORDS) {
            if (textLowerCase.contains(word)) {
                return new AnalysisResult(tweetData, AnalysisResult.Outlook.NEGATIVE);
            }
        }

        return new AnalysisResult(tweetData, AnalysisResult.Outlook.POSITIVE);
    }
}