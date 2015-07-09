package com.saif;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ScoreTest
        extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ScoreTest(String testName)
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ScoreTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testScore()
    {
        Score s = new Score("XXXXXXXXXXXX");
        assertEquals(300,s.getResult());
        s= new Score("--------------------");
        assertEquals(0, s.getResult());
        s= new Score("-/2");
        assertEquals(14, s.getResult());
    }

    public void testCalculateFrame() throws Exception {
        Score s = new Score("-/X2/");
        assertEquals (0, s.pinDropped(0));
        assertEquals(10, s.pinDropped(1));
        assertEquals(10, s.pinDropped(2));
        assertEquals(2, s.pinDropped(3));
        assertEquals(8, s.pinDropped(4));
    }
}
