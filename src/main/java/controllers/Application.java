package main.java.controllers;

import main.java.model.customers.SomeCustomer;
import main.java.view.View;

import java.util.ArrayList;
import java.util.List;

public class Application {

    List<Thread> customers;
    List<Thread> requestControllers;
    FrontSystem frontSystem = new FrontSystem();
    BackSystem backSystem = new BackSystem(0);
    View view = new View();

    public Application() {
        initCustomers();
        initRequestControllers();
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    public void start() {
        ArrayList<Thread> threads = new ArrayList<>();
        threads.addAll(customers);
        threads.addAll(requestControllers);
        for (Thread thread : threads) {
            thread.start();
        }
        try {
            Thread.sleep(5000);
            for (Thread thread : threads) {
                thread.interrupt();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void initRequestControllers() {
        requestControllers = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Thread newThread = new RequestController(frontSystem, backSystem, view);
            newThread.setName(String.valueOf(i));
            requestControllers.add(newThread);
        }
    }

    private void initCustomers() {
        customers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Thread newThread = new SomeCustomer(frontSystem, view);
            newThread.setName("Customer " + i);
            customers.add(newThread);
        }
    }
}
