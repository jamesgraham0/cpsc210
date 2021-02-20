package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;
    private Bus bus1;
    private Bus bus2;
    private Bus bus3;

    @BeforeEach
    public void runBefore() {
        student = new Student(100, "James", 12);
        bus1 = new Bus(1, 20);
        bus2 = new Bus(2, 40);
        bus3 = new Bus(3, 0);
    }

    @Test
    public void testGetId() {
        assertEquals(100, student.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("James", student.getName());
    }

    @Test
    public void testGetGrade() {
        assertEquals(12, student.getGrade());
    }

    @Test
    public void testIsAssignedToBus() {
        assertFalse(student.isAssignedToBus());

        student.assignToBus(bus1);
        assertTrue(student.isAssignedToBus());
    }

    @Test
    public void testAssignToBus() {
        // when bus is empty
        assertFalse(student.isAssignedToBus());
        student.assignToBus(bus1);
        assertEquals(bus1, student.getAssignedBus());

        student.assignToBus(bus2);
        assertEquals(bus2, student.getAssignedBus());

        // when bus is full
        student.assignToBus(bus3);
        assertEquals(bus2, student.getAssignedBus());
    }

    @Test
    public void testRemovedFromBus() {

        // is not assigned to a bus
        assertFalse(student.isAssignedToBus());
        student.removeFromBus();
        assertFalse(student.isAssignedToBus());

        // is assigned to a bus
        student.assignToBus(bus1);
        assertEquals(bus1, student.getAssignedBus());
        student.removeFromBus();
        assertFalse(student.isAssignedToBus());

    }

}