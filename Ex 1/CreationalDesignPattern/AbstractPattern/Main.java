import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Do you want a Hot or Cold drink? (hot/cold): ");
        String type = sc.nextLine().trim().toLowerCase();

        DrinkFactory factory;

        if (type.equals("hot")) {
            factory = new HotDrinkFactory();
        } 
        else if (type.equals("cold")) {
            factory = new ColdDrinkFactory();
        } 
        else {
            System.out.println("Invalid choice. Defaulting to cold drinks.");
            factory = new ColdDrinkFactory();
        }

        System.out.print("Do you want Coffee or Tea? (coffee/tea): ");
        String drinkChoice = sc.nextLine().trim().toLowerCase();

        if (drinkChoice.equals("coffee")){
            CoffeeDrink coffee = factory.createCoffee();
            coffee.serve();
        } 
        else if (drinkChoice.equals("tea")){
            TeaDrink tea = factory.createTea();
            tea.serve();
        } 
        else{
            System.out.println("Invalid choice. No drink served.");
        }

        sc.close();
    }
}

// Product Interfaces
interface CoffeeDrink{ 
    void serve(); 
}
interface TeaDrink{ 
    void serve(); 
}

// Abstract Factory
interface DrinkFactory{
    CoffeeDrink createCoffee();
    TeaDrink createTea();
}

// Cold Drink Products
class IcedLatte implements CoffeeDrink{
    public void serve(){ 
        System.out.println("Serving Iced Latte"); 
    }
}

class IcedTea implements TeaDrink{
    public void serve(){
        System.out.println("Serving Iced Tea"); 
    }
}

// Hot Drink Products
class HotEspresso implements CoffeeDrink{
    public void serve(){ 
        System.out.println("Serving Hot Espresso"); 
    }
}

class HotGreenTea implements TeaDrink{
    public void serve(){ 
        System.out.println("Serving Hot Green Tea"); 
    }
}

// Concrete Factories
class HotDrinkFactory implements DrinkFactory{
    public CoffeeDrink createCoffee(){
        return new HotEspresso(); 
    }
    public TeaDrink createTea(){ 
        return new HotGreenTea(); 
    }
}

class ColdDrinkFactory implements DrinkFactory{
    public CoffeeDrink createCoffee(){
        return new IcedLatte();
    }
    public TeaDrink createTea(){ 
        return new IcedTea(); 
    }
}
