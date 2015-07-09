package com.saif;

/**
 * Created by saif on 7/9/15.
 */
public class Score {
    private String input;
    private int frames[] = new int[MAX_FRAME]; // frames shouldn't have any set method. It should only be derived from 'input'
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

    /*
    * translates the value of all tries to frame.
    *
    * */
    public void calculateFrameValues() {
        int frame=0;
        int tries=1;
        for (int i=0; i<input.length() && frame < MAX_FRAME; i++)
        {
            switch (input.charAt(i)){
                case STRIKE:
                    if (tries==2)
                        throw new IllegalArgumentException("X can't be at position "+ i + " in "+input);
                    else
                        frames[frame++]= 10 + pinDropped(i+1) + pinDropped(i+2);
                    tries=1;
                    break;
                case SPARE:
                    if (tries==1)
                        throw new IllegalArgumentException("/ can't be at position "+ i + " in "+input);
                    else
                        frames[frame++]= 10 + pinDropped(i+1);
                    tries=1;
                    break;
                default:
                    if (tries == 2) {
                        frames[frame++] += pinDropped(i);
                        tries=1;
                    }
                    else
                    {
                        frames[frame] += pinDropped(i);
                        tries=2;
                    }
            }//switch
        }//for every char
    }

    /*
    * returns the number of pin dropped in a particular try.
    * Assume that input is a valid set of tries.
    * */
    public int pinDropped(int index) {
        int value = 0;
        if (index >= input.length() || index < 0)
            return 0;

        switch (input.charAt(index)) {
            case MISS:
                value = 0;
                break;
            case SPARE:
                value = MAX_PIN - pinDropped(index - 1);
                break;
            case STRIKE:
                value = MAX_PIN;
                break;
            default:
                value = Integer.parseInt(String.valueOf(input.charAt(index)));
        }
        return value;
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
