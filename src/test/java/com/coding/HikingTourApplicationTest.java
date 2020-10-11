package com.coding;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// TODO
/**
 * Unit test for simple App.
 */
public class HikingTourApplicationTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HikingTourApplicationTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HikingTourApplicationTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
