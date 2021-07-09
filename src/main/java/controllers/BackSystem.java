package main.java.controllers;

import main.java.model.applications.Request;

public class BackSystem {

    private volatile int balance;

    public BackSystem(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public synchronized boolean reduceBalance(Request application) {
        boolean result = false;
        int amount = application.getAmount();
        if (balance >= amount) {
            balance -= amount;
            result = true;
        }
        return result;
    }

    public synchronized boolean increaseBalance(Request application) {
        boolean result = true;
        balance += application.getAmount();
        return result;
    }
}
