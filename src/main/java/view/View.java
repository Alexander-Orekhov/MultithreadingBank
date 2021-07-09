package main.java.view;

import main.java.controllers.RequestController;
import main.java.controllers.BackSystem;
import main.java.model.applications.Request;

public class View {

    public void viewRequestSent(Request application) {
        System.out.println("Заявка " + application + " отправленна в банк");
    }

    public void viewRequestControllerAcceptedRequest(Request application, RequestController controller) {
        System.out.println("Обработчик заявок " + controller.getName()
                + ": получена заявка на обработку по клиенту - " + application.getCustomerName());
    }

    public void viewBackSystemWork(Request application, RequestController controller, BackSystem backSystem,
                                   boolean workResult) {
        System.out.println("Бек система: Заявка " + application + (workResult ? " ВЫПОЛНЕНА" : " НЕ ВЫПОЛНЕНА")
                + ". Получена от обработчика заявок "
                + controller.getName() + ". Баланс банка: " + backSystem.getBalance());

    }


}
