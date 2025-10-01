import java.util.*;

public class Main {
    public static void main(String[] args) {
        OrderNotifier notifier = new OrderNotifier();

        notifier.addObserver(new CoffeeMakerObserver());
        notifier.addObserver(new CustomerObserver());

        notifier.setOrderReady("Order #101");
    }
}

interface Observer {
    void notify(String message);
}

class CoffeeMakerObserver implements Observer {
    public void notify(String msg) {
        System.out.println("CoffeeMaker notified: " + msg);
    }
}

class CustomerObserver implements Observer {
    public void notify(String msg) {
        System.out.println("Customer notified: " + msg);
    }
}

class OrderNotifier {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) { observers.add(o); }

    public void setOrderReady(String order) {
        System.out.println("Order Ready: " + order);
        notifyAllObservers(order);
    }

    private void notifyAllObservers(String message) {
        for (Observer o : observers) {
            o.notify(message);
        }
    }
}
