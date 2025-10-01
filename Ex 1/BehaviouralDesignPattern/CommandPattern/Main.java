import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMaker maker = new CoffeeMaker();
        OrderManager manager = new OrderManager();

        System.out.print("Enter drink to order (Cappuccino/Latte/Espresso): ");
        String drink = sc.nextLine();

        Command order = new PlaceOrderCommand(maker, drink);
        manager.takeOrder(order);

        System.out.print("Do you want to undo the order? (yes/no): ");
        String undo = sc.nextLine();
        if (undo.equalsIgnoreCase("yes")) {
            manager.undoLastOrder();
        }

        sc.close();
    }
}

// Command interface
interface Command {
    void execute();
    void undo();
}

// Concrete command
class PlaceOrderCommand implements Command {
    private CoffeeMaker maker;
    private String drink;

    public PlaceOrderCommand(CoffeeMaker maker, String drink) {
        this.maker = maker;
        this.drink = drink;
    }

    @Override
    public void execute() {
        maker.makeDrink(drink);
    }

    @Override
    public void undo() {
        maker.cancelDrink(drink);
    }
}

// Receiver
class CoffeeMaker {
    public void makeDrink(String drink) {
        System.out.println("Making " + drink);
    }

    public void cancelDrink(String drink) {
        System.out.println("Cancelled " + drink);
    }
}

// Invoker
class OrderManager {
    private Stack<Command> history = new Stack<>();

    public void takeOrder(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastOrder() {
        if (!history.isEmpty()) {
            history.pop().undo();
        } else {
            System.out.println("No orders to undo.");
        }
    }
}
