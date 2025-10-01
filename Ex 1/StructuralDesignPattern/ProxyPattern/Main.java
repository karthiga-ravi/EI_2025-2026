import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ingredient you want to check (e.g., Oat Milk, Almond Milk): ");
        String ingredientName = scanner.nextLine();

        // Create proxy for ingredient stock
        IngredientStock stock = new ProxyIngredientStock(ingredientName);

        System.out.println("\nChecking availability first time:");
        stock.checkAvailability();  // First call loads the data

        System.out.println("\nChecking availability second time (should be cached):");
        stock.checkAvailability();  // Cached result

        scanner.close();
    }
}

// IngredientStock interface
interface IngredientStock {
    void checkAvailability();
}

// Real ingredient stock (expensive to load)
class RealIngredientStock implements IngredientStock {
    private String ingredient;

    public RealIngredientStock(String ingredient){
        this.ingredient = ingredient;
        loadFromDatabase();
    }

    private void loadFromDatabase() {
        System.out.println("Loading " + ingredient + " stock from database...");
        try{
            Thread.sleep(1000); // Simulate delay
        } 
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void checkAvailability(){
        System.out.println(ingredient + " is in stock.");
    }
}

// Proxy ingredient stock (lazy loading / caching)
class ProxyIngredientStock implements IngredientStock{
    private RealIngredientStock realStock;
    private String ingredient;

    public ProxyIngredientStock(String ingredient){
        this.ingredient = ingredient;
    }

    @Override
    public void checkAvailability(){
        if (realStock == null){
            realStock = new RealIngredientStock(ingredient);
        }
        realStock.checkAvailability();
    }
}
