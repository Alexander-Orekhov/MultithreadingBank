package main.java.model.customers;

import main.java.controllers.FrontSystem;
import main.java.model.applications.RequestType;
import main.java.model.applications.Request;
import main.java.view.View;

import java.security.SecureRandom;
import java.util.Random;

public class SomeCustomer extends Thread implements Customer {

    private FrontSystem frontSystem;
    private Random random = new SecureRandom();
    private View view;

    public SomeCustomer(FrontSystem frontSystem, View view) {
        this.frontSystem = frontSystem;
        this.view = view;
    }

    @Override
    public void run() {
        if (random.nextBoolean()) {
            repayCredit();
        } else {
            takeCredit();
        }
    }

    @Override
    public void takeCredit() {
        Request application = new Request(this.getName(), RequestType.CREDIT, 500);
        frontSystem.setRequestInInputQueue(application);
        view.viewRequestSent(application);
    }

    @Override
    public void repayCredit() {
        Request application = new Request(this.getName(), RequestType.REPAYMENT, 600);
        frontSystem.setRequestInInputQueue(application);
        view.viewRequestSent(application);
    }

}
