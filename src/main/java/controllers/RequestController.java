package main.java.controllers;

import main.java.model.applications.Request;
import main.java.view.View;

import java.util.Objects;

public class RequestController extends Thread {

    private FrontSystem frontSystem;
    private BackSystem backSystem;
    private View view;

    public RequestController(FrontSystem frontSystem, BackSystem backSystem, View view) {
        this.frontSystem = frontSystem;
        this.backSystem = backSystem;
        this.view = view;
    }

    public FrontSystem getFrontSystem() {
        return frontSystem;
    }

    public void setFrontSystem(FrontSystem frontSystem) {
        this.frontSystem = frontSystem;
    }

    public BackSystem getBackSystem() {
        return backSystem;
    }

    public void setBackSystem(BackSystem backSystem) {
        this.backSystem = backSystem;
    }


    @Override
    public void run() {
        while (!this.isInterrupted()) {
            Request request = frontSystem.getRequestFromInputQueue();
            boolean workResult = false;
            if (Objects.nonNull(request)) {
                view.viewRequestControllerAcceptedRequest(request, this);
                switch (request.getType()) {
                    case CREDIT:
                        workResult = backSystem.reduceBalance(request);
                        break;
                    case REPAYMENT:
                        workResult = backSystem.increaseBalance(request);
                        break;
                }
                view.viewBackSystemWork(request, this, backSystem, workResult);
            }
        }
    }

}
