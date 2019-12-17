package chapter_7;

import structures.LinkedList;

/**
 * Call Center
 *
 * Imagine you have a call center with three levels of employees: respondent, manager, and director.
 * An incoming telephone call must be first allocated to a respondent who is free.
 * If the respondent can't handle the call, he or she must escalate the call to a manager.
 * If the manager is not free or not able to handle it, then the call should be escalated to a director.
 * Design the classes and data structures for this problem.
 * Implement a method dispatchCall() which assigns a call to the first available employee.
 *
 */
public class Task_2 {

    public static void main(String[] args) { }

    public static class CallCenter<T extends Employee> {
        LinkedList<Respondent> respondents;
        LinkedList<Manager> managers;
        LinkedList<Director> directors;

        public CallCenter() {
            respondents = new LinkedList<>();
            managers = new LinkedList<>();
            directors = new LinkedList<>();
        }

        public Employee dispatchCall(Call call) {
            if (!respondents.isEmpty()) return respondents.dequeue();
            if (!managers.isEmpty()) return managers.dequeue();
            if (!directors.isEmpty()) return directors.dequeue();

            return null; // we need clarify, what we will to if everyone are busy
        }
    }

    public static class Caller{}

    public static class Call {
        // Person who is calling
        private Caller caller;
        // Employee who is handling call
        private Employee handler;
    }

    public abstract static class Employee {
        private Call currentCall = null;

        public void receiveCall(Call call) {}
        public void callCompleted() {}
    }

    public abstract static class Respondent extends Employee {}
    public abstract static class Manager extends Employee {}
    public abstract static class Director extends Employee {}
}