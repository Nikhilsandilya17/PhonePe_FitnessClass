package model;

import enums.FitnessClassType;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public abstract class FitnessClass {
    private String instructorName;
    private double price;
    private int duration;
    private FitnessClassType fitnessClassType;
    private int maxAttendees;
    private LocalDateTime scheduledTime;
    private int currentCapacity;
    private Queue<User> waitlist;

    protected FitnessClass(String instructorName, double price, int duration, FitnessClassType fitnessClassType, int maxAttendees) {
        this.instructorName = instructorName;
        this.price = price;
        this.duration = duration;
        this.fitnessClassType = fitnessClassType;
        this.maxAttendees = maxAttendees;
        currentCapacity = 0;
        waitlist = new LinkedList<>();
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public FitnessClassType getFitnessClassType() {
        return fitnessClassType;
    }

    public void setFitnessClassType(FitnessClassType fitnessClassType) {
        this.fitnessClassType = fitnessClassType;
    }

    public int getMaxAttendees() {
        return maxAttendees;
    }

    public void setMaxAttendees(int maxAttendees) {
        this.maxAttendees = maxAttendees;
    }

    public LocalDateTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(LocalDateTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Queue<User> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(Queue<User> waitlist) {
        this.waitlist = waitlist;
    }
}
