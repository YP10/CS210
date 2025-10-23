package analyzer;
//
// Copyright (c) 2025 Tim Richards. All rights reserved.
//


/**
 * JUnit test class for FaultyCampusAnalyzer.
 *
 * Students must complete the TODO sections by writing
 * appropriate test cases.
 */
public class StudentTest {

    /**
     * Test findShortestName() method.
     */
    @Test
    public void testFindShortestName() {
        String[] testShortestBuildingName = {"LGRT", "LGRC", "Oak", "Isenberg", "ILC", "$$"};
        assertEquals("$$", FaultyCampusAnalyzer.findShortestName(testShortestBuildingName));

        // METHOD: FaultyCampusAnalyzer.findShortestName(String[] buildings)
    }

    /**
     * Test findMedianDistance() method.
     */
    @Test
    public void testFindMedianDistance() {
        double[] distance = {2.3, 1.2, 4.6, 7.3, 1.1, 9.5};
        assertEquals(3.45, FaultyCampusAnalyzer.findMedianDistance(distance));

        // METHOD: FaultyCampusAnalyzer.findMedianDistance(double[] distances)
    }

    /**
     * Test isAnyBusFull() method.
     */
    @Test
    public void testIsAnyBusFull() {
        Bus a = new Bus(13, "Hagis Mall", 50, 50);
        Bus b = new Bus(21, "O Hill", 74, 75);
        Bus[] testBuses = new Bus[2];
        testBuses[0] = a;
        testBuses[1] = b;
        assertTrue(FaultyCampusAnalyzer.isAnyBusFull(testBuses));
        Bus c = new Bus(11, "NorthHampton", 21, 35);
        testBuses[0] = c;
        assertFalse(FaultyCampusAnalyzer.isAnyBusFull(testBuses));
        Bus d = new Bus(22, "Amherst Downtown", 33, 21);
        testBuses[0] = d;
        assertTrue(FaultyCampusAnalyzer.isAnyBusFull(testBuses));
    }

    /**
     * Test countUnderloadedBuses() method.
     */
    @Test
    public void testCountUnderloadedBuses() {
        Bus a = new Bus(13, "Hagis Mall", 25, 50);
        Bus b = new Bus(21, "O Hill", 21, 75);
        Bus c = new Bus(11, "NorthHampton", 17, 36);
        Bus d = new Bus(22, "Amherst Downtown", 50, 40);
        Bus[] testBuses = {a, b, c, d};
        assertEquals(2, FaultyCampusAnalyzer.countUnderloadedBuses(testBuses));

    }
}
