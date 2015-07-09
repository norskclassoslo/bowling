package com.saif;

/**
 * Created by saif on 7/9/15.
 */
public class Score {
    private String input;
    private int frames[] = new int[MAX_FRAME];
    public static final int MAX_PIN = 10;
    public static final int MAX_FRAME = 10;
    public static final char SPARE = '/';
    public static final char STRIKE = 'X';
    public static final char MISS = '-';

    public void setInput(String str) {
        input = str;
        calculateFrameValues();
    }

    public Score() {
    }

    public Score(String word){
        setInput(word);
    }

    public void calculateFrameValues() {
    }

    /*
    * returns the number of pin dropped in a particular try.
    *
    * */
    public int pinDropped(int index) {
        return 0;
    }

    /*
    * Returns the sum of all frames.Unused frames has 0 score so adding all frames will not make any difference
    * */
    public int getResult(){
        int total=0;
        for (int i=0; i<frames.length; i++)
            total += frames[i];
        return total;
    }


    }
