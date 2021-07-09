package main.java.controllers;

import main.java.model.applications.Request;

import java.util.ArrayDeque;
import java.util.Queue;

public class FrontSystem {

    Queue<Request> requestInputQueue = new ArrayDeque<>();

    public synchronized void setRequestInInputQueue(Request request) {
        try {
            while (requestInputQueue.size() >= 2) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestInputQueue.add(request);
    }

    public synchronized Request getRequestFromInputQueue() {
        Request result = null;
        if (!requestInputQueue.isEmpty()) {
            result = requestInputQueue.poll();
        }
        notifyAll();
        return result;
    }


}
