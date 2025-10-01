import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create the notifier (subject)
        OrderNotifier notifier = new OrderNotifier();

        // Add observers
        notifier.addObserver(new CoffeeMakerObserver());
        notifier.addObserver(new CustomerObserver());

        // Get order input from user
        System.out.print("Enter order name: ");
        String order = sc.nextLine();

        // Notify observers
        notifier.setOrderReady(order);

        sc.close();
    }
}

// Observer interface
interface Observer {
    void notify(String message);
}

// Concrete observer: CoffeeMaker
class CoffeeMakerObserver implements Observer {
    public void notify(String msg) {
        System.out.println("CoffeeMaker notified: " + msg);
    }
}

// Concrete observer: Customer
class CustomerObserver implements Observer {
    public void notify(String msg) {
        System.out.println("Customer notified: " + msg);
    }
}

// Subject / Notifier
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
