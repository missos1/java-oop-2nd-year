package org.javaoop.Week4;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Week4Test {
    @Test
    public void testMax2Int1() {
        assertEquals(5, Week4.max2Int(5, 3));
    }

    @Test
    public void testMax2Int2() {
        assertEquals(10, Week4.max2Int(10, 10));
    }

    @Test
    public void testMax2Int3() {
        assertEquals(7, Week4.max2Int(2, 7));
    }

    @Test
    public void testMax2Int4() {
        assertEquals(-1, Week4.max2Int(-1, -5));
    }

    @Test
    public void testMax2Int5() {
        assertEquals(0, Week4.max2Int(0, -10));
    }

    @Test
    public void testMinArray1() {
        assertEquals(1, Week4.minArray(new int[]{5, 2, 9, 1}));
    }

    @Test
    public void testMinArray2() {
        assertEquals(-3, Week4.minArray(new int[]{0, -1, -3, 7}));
    }

    @Test
    public void testMinArray3() {
        assertEquals(4, Week4.minArray(new int[]{4, 4, 4, 4}));
    }

    @Test
    public void testMinArray4() {
        assertEquals(-10, Week4.minArray(new int[]{-10}));
    }

    @Test
    public void testMinArray5() {
        assertEquals(2, Week4.minArray(new int[]{100, 50, 2, 999}));
    }

    @Test
    public void testCalculateBMI1() {
        assertEquals("Thiếu cân", Week4.calculateBMI(45, 1.7));
    }

    @Test
    public void testCalculateBMI2() {
        assertEquals("Bình thường", Week4.calculateBMI(60, 1.7));
    }

    @Test
    public void testCalculateBMI3() {
        assertEquals("Thừa cân", Week4.calculateBMI(70, 1.7));
    }

    @Test
    public void testCalculateBMI4() {
        assertEquals("Béo phì", Week4.calculateBMI(90, 1.7));
    }

    @Test
    public void testCalculateBMI5() {
        assertEquals("Thiếu cân", Week4.calculateBMI(50, 1.65));
    }
} 