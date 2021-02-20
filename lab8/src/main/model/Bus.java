package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


// Represents a bus having an id, capacity, chaperone and set of students assigned to travel on bus
public class Bus {
    private int id;
    private int capacity;
    private Chaperone chaperone;
    private HashSet<Student> assignedStudents;

    // EFFECTS: constructs bus with id and capacity
    public Bus(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.chaperone = null;
        this.assignedStudents = new HashSet<>();
    }

    public int getId() {
        return id;   // stub
    }

    public int getCapacity() {
        return capacity;   // stub
    }

    public Chaperone getChaperone() {
        return this.chaperone;   // stub
    }

    // EFFECTS: returns true if bus has a chaperone assigned, false otherwise
    public boolean hasChaperone() {
        return this.chaperone != null;
    }

    // EFFECTS: returns an unmodifiable set of students assigned to travel on this bus
    public Set<Student> getStudents() {

        return Collections.unmodifiableSet(assignedStudents);
    }

    // MODIFIES: this
    // EFFECTS: assigns the chaperone for this bus
    public void setChaperone(Chaperone chaperone) {
        this.chaperone = chaperone;
    }

    // EFFECTS: returns true if bus is full, false otherwise
    public boolean isFull() {
        return assignedStudents.size() == capacity;
    }

    /**
     * Bus.addStudent: a test that adds a single student to a bus has failed when the
     * student was not previously assigned to a bus
     *
     * Bus.addStudent: a test that adds students to a bus until it is full has failed
     */
    // REQUIRES: !isFull()
    // MODIFIES: this, student
    // EFFECTS: adds student to this bus
    public void addStudent(Student student) {
        if (!isFull() && !this.assignedStudents.contains(student)) {
            if (student.isAssignedToBus()) {
                student.getAssignedBus().removeStudent(student);
                this.assignedStudents.add(student);
                student.assignToBus(this);
            } else {
                student.assignToBus(this);
                this.assignedStudents.add(student);
            }
        }
    }

    // MODIFIES: this, student
    // EFFECTS: removes student from this bus
    public void removeStudent(Student student) {
        if (assignedStudents.contains(student)) {
            assignedStudents.remove(student);
            student.removeFromBus();
        }
    }
}
