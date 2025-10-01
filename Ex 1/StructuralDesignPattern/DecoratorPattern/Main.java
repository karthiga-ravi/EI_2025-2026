import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Beverage beverage = new Espresso(); // base drink

        System.out.print("Do you want Milk? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")){
            beverage = new Milk(beverage);
        }

        System.out.print("Do you want Sugar? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")){
            beverage = new Sugar(beverage);
        }

        System.out.print("Do you want Whipped Cream? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")){
            beverage = new WhippedCream(beverage);
        }

        System.out.println("\nOrder: " + beverage.getDescription());
        System.out.println("Cost: Rs" + beverage.getCost());

        sc.close();
    }
}

// Beverage interface
interface Beverage {
    String getDescription();
    double getCost();
}

// Base coffee
class Espresso implements Beverage {
    public String getDescription(){ 
        return "Espresso"; 
    }
    public double getCost(){ 
        return 3.0; 
    }
}

// Decorator base
abstract class AddOnDecorator implements Beverage {
    protected Beverage beverage;
    public AddOnDecorator(Beverage beverage){ 
        this.beverage = beverage; 
    }
}

// Add-ons
class Milk extends AddOnDecorator {
    public Milk(Beverage b){ 
        super(b); 
    }
    public String getDescription(){ 
        return beverage.getDescription() + ", Milk";
    }
    public double getCost(){ 
        return beverage.getCost() + 0.5; 
    }
}

class Sugar extends AddOnDecorator {
    public Sugar(Beverage b){ 
        super(b); 
    }
    public String getDescription(){ 
        return beverage.getDescription() + ", Sugar";
    }
    public double getCost(){ 
        return beverage.getCost() + 0.2; 
    }
}

class WhippedCream extends AddOnDecorator {
    public WhippedCream(Beverage b){ 
        super(b); 
    }
    public String getDescription(){ 
        return beverage.getDescription() + ", Whipped Cream"; 
    }
    public double getCost(){ 
        return beverage.getCost() + 0.7; 
    }
}
