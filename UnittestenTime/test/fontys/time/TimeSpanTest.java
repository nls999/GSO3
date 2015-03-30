/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fontys.time;

import java.text.SimpleDateFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Roy
 */

public class TimeSpanTest {
    
    private TimeSpan timespan;
    private Time earlytime;
    private Time latetime;
        
    public TimeSpanTest() {
        earlytime = new Time(1, 1, 1, 1, 1);
        latetime = new Time(11, 1, 1, 1, 1);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }      

    /**
     * Since the endtime in TimeSpan must always be a later time than begintime, 
     * the length of the period in between should always be positive.
     */
    @Test()
    public void testLength() {
        timespan = new TimeSpan(earlytime,latetime);
        Assert.assertTrue(timespan.length() > 0);
    }

    /**
     * Begin time must be earlier than end time
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetBeginTime() {
        
        timespan = new TimeSpan(latetime,earlytime);
        Assert.fail("begin time " + earlytime + "must be earlier than end time" + latetime);
    }

    /**
     * End time must be later than begin time
     * 
     * Grammaticale fout in Exception message
     */
    @Test
    public void testSetEndTime() {
        timespan = new TimeSpan(latetime,earlytime);
        Assert.fail("end time " + latetime + " must be later then begin time " + earlytime);
    }

    /**
     * Test of move method, of class TimeSpan.
     */
    @Test
    public void testMove() {        
        timespan = new TimeSpan(earlytime, latetime);        
        Time expectedEarlytime = new Time(1,1,1,1,41);
        Time expectedLatetime = new Time(11,1,1,1,41);
        TimeSpan expectedts = new TimeSpan(expectedEarlytime,expectedLatetime);
        int minutesToMove = 40;
        timespan.move(minutesToMove);
        Assert.assertTrue(timespan.getBeginTime().compareTo(expectedts.getBeginTime()) == 0);
    }

    /**
     * Test of changeLengthWith method, of class TimeSpan.
     */
    @Test
    public void testChangeLengthWith() {
        timespan = new TimeSpan(earlytime, latetime);
        int 
        
    }

    /**
     * Test of isPartOf method, of class TimeSpan.
     */
    @Test
    public void testIsPartOf() {
        System.out.println("isPartOf");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        boolean expResult = false;
        boolean result = instance.isPartOf(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unionWith method, of class TimeSpan.
     */
    @Test
    public void testUnionWith() {
        System.out.println("unionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.unionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectionWith method, of class TimeSpan.
     */
    @Test
    public void testIntersectionWith() {
        System.out.println("intersectionWith");
        ITimeSpan timeSpan = null;
        TimeSpan instance = null;
        ITimeSpan expResult = null;
        ITimeSpan result = instance.intersectionWith(timeSpan);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
