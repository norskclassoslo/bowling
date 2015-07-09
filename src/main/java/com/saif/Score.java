package com.saif;

/**
 * Created by saif on 7/9/15.
 */
public class Score {
    private String rolls;
    private int frames[] = new int[MAX_FRAME]; // frames shouldn't have any set method. It should only be derived from 'rolls'
    public static final int MAX_PIN = 10;
    public static final int MAX_FRAME = 10;
    public static final char SPARE = '/';
    public static final char STRIKE = 'X';
    public static final char MISS = '-';

    public void setRolls(String str) {
        rolls = str;
        calculateFrameValues();
    }

    public Score() {
    }

    public Score(String word){
        setRolls(word);
    }

    /*
    * translates the value of all tries to frame.
    *
    * */
    public void calculateFrameValues() {
        int frame=0;
        int tries=1;
        for (int currentRoll=0; currentRoll<rolls.length() && frame < MAX_FRAME; currentRoll++)
        {
            switch (rolls.charAt(currentRoll)){
                case STRIKE:
                    if (tries==2)
                        throw new IllegalArgumentException("X can't be at position "+ currentRoll + " in "+rolls);
                    else
                        frames[frame++]= 10 + pinDropped(currentRoll + 1) + pinDropped(currentRoll + 2);
                    tries=1;
                    break;
                case SPARE:
                    if (tries==1)
                        throw new IllegalArgumentException("/ can't be at position "+ currentRoll + " in "+rolls);
                    else
                        frames[frame++]= 10 + pinDropped(currentRoll + 1);
                    tries=1;
                    break;
                default:
                    if (tries == 2) {
                        frames[frame++] += pinDropped(currentRoll);
                        tries=1;
                    }
                    else
                    {
                        frames[frame] += pinDropped(currentRoll);
                        tries=2;
                    }
            }//switch
        }//for every char
    }

    /*
    * returns the number of pin dropped in a particular try.
    * Assume that rolls is a valid set of tries.
    * */
    public int pinDropped(int index) {
        int value = 0;
        if (index >= rolls.length() || index < 0)
            return 0;

        switch (rolls.charAt(index)) {
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
                value = Integer.parseInt(String.valueOf(rolls.charAt(index)));
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
