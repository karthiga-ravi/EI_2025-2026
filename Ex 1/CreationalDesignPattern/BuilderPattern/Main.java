import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter coffee type (e.g., Espresso, Latte, Cappuccino): ");
        String type = sc.nextLine();

        Coffee.Builder builder = new Coffee.Builder(type);

        System.out.print("Do you want milk? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")){
            builder.addMilk();
        }

        System.out.print("Do you want sugar? (yes/no): ");
        if (sc.nextLine().equalsIgnoreCase("yes")){
            builder.addSugar();
        }

        System.out.print("Enter syrup flavor (or press Enter to skip): ");
        String syrup = sc.nextLine();
        if (!syrup.isEmpty()){
            builder.addSyrup(syrup);
        }

        System.out.print("Enter size (Small/Medium/Large): ");
        String size = sc.nextLine();
        builder.size(size);

        // Build the coffee
        Coffee coffee = builder.build();
        System.out.println("\nYour order: " + coffee);

        sc.close();
    }
}

// Coffee Class with Builder
class Coffee {
    private final String type;
    private final boolean milk;
    private final boolean sugar;
    private final String syrup;
    private final String size;

    private Coffee(Builder builder) {
        this.type = builder.type;
        this.milk = builder.milk;
        this.sugar = builder.sugar;
        this.syrup = builder.syrup;
        this.size = builder.size;
    }

    @Override
    public String toString() {
        return size + " " + type + (milk ? " with milk" : "")
               + (sugar ? ", sugar" : "")
               + (syrup != null ? ", syrup: " + syrup : "");
    }

    // Builder Inner Class
    public static class Builder {
        private final String type;
        private boolean milk;
        private boolean sugar;
        private String syrup;
        private String size = "Medium"; // default

        public Builder(String type){
            this.type = type;
        }

        public Builder addMilk(){
            this.milk = true;
            return this;
        }

        public Builder addSugar(){
            this.sugar = true;
            return this;
        }

        public Builder addSyrup(String syrup){
            this.syrup = syrup;
            return this;
        }

        public Builder size(String size){
            this.size = size;
            return this;
        }

        public Coffee build(){
            return new Coffee(this);
        }
    }
}
