package main.java.model.applications;

public class Request {

    private String customerName;
    private RequestType type;
    private int amount;

    public Request(String customerName, RequestType type, int value) {
        this.customerName = customerName;
        this.type = type;
        this.amount = value;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "{" +
                "customerName='" + customerName + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
