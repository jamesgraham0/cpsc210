package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {
    private Bus bus1;
    private Bus bus2;
    private Bus bus3;
    private Bus bus4;
    private Student student;
    private Student student2;
    private Chaperone chaperone1;
    private Chaperone chaperone2;

    @BeforeEach
    public void runBefore() {
        bus1 = new Bus(1, 20);
        bus2 = new Bus(2, 40);
        bus3 = new Bus(3, 0);
        bus4 = new Bus(4, 2);
        chaperone1 = new Chaperone("Sam");
        chaperone2 = new Chaperone("Dave");
        student = new Student(10, "James", 12);
        student2 = new Student(11, "Ben", 11);
        bus2.setChaperone(chaperone1);
    }

    @Test
    public void testGetId() {
        assertEquals(1, bus1.getId());
    }

    @Test
    public void testGetCapacity() {
        assertEquals(40, bus2.getCapacity());
    }

    @Test
    public void testHasChaperone() {
        assertFalse(bus1.hasChaperone());

        assertTrue(bus2.hasChaperone());
    }

    @Test
    public void testGetStudents() {
        assertEquals(new HashSet<>(), bus1.getStudents());
        bus1.addStudent(student);
        assertTrue(bus1.getStudents().contains(student));
    }

    @Test
    public void testSetChaperone() {
        assertFalse(bus1.hasChaperone());
        bus1.setChaperone(chaperone1);
        assertTrue(bus1.hasChaperone());

        assertTrue(bus2.hasChaperone());
        bus2.setChaperone(chaperone2);
        assertTrue(bus2.hasChaperone());
        assertEquals("Dave", bus2.getChaperone().getName());
    }

    @Test
    public void testIsFull() {
        assertFalse(bus1.isFull());
        assertTrue(bus3.isFull());
    }

    @Test
    public void testAddStudent() {
        // when bus is full
        assertTrue(bus3.isFull());
        bus3.addStudent(student);
        assertTrue(bus3.isFull());
        assertFalse(student.isAssignedToBus());

        // when bus is NOT full and student is assigned to a bus
        student.assignToBus(bus2);
        bus2.addStudent(student);

        assertFalse(bus1.isFull());
        student.assignToBus(bus1);
        assertTrue(student.isAssignedToBus());
        assertEquals(bus1, student.getAssignedBus());

        HashSet<Student> students = new HashSet<>();
        students.add(student);

        bus2.addStudent(student);
        assertEquals(students, bus2.getStudents());
        assertTrue(bus1.getStudents().isEmpty());

        // when bus is NOT full and student is NOT assigned to a bus
        assertFalse(bus1.isFull());
        bus1.addStudent(student2);
        assertFalse(bus1.getStudents().isEmpty());

        // add students until bus is full
        assertFalse(bus4.isFull());
        bus4.addStudent(student);
        bus4.addStudent(student2);

        assertTrue(bus4.isFull());
    }

    @Test
    public void testRemoveStudent() {
        bus2.addStudent(student);
        assertFalse(bus2.getStudents().isEmpty());
        bus2.removeStudent(student);
        assertTrue(bus2.getStudents().isEmpty());

    }

}