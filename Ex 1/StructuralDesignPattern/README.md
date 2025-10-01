# ☕ Coffee Shop – Structural Design Patterns

This project demonstrates **Structural Design Patterns** in Java, specifically:  

- **Decorator Pattern** – to dynamically add add-ons to beverages (milk, sugar, whipped cream).  
- **Proxy Pattern** – to manage access to ingredient stock with lazy loading and caching.  

---

## Features
- **Decorator Pattern**  
  - Start with a base beverage (Espresso).  
  - Dynamically add add-ons like Milk, Sugar, Whipped Cream.  
  - Calculate total cost and display description of the customized beverage.  
- **Proxy Pattern**  
  - Check availability of ingredients (e.g., Oat Milk, Almond Milk).  
  - Simulates expensive database loading.  
  - Uses caching to avoid repeated expensive operations.  

---

## Design Patterns Used

### 1. Decorator Pattern
- **Component (Beverage)**: Interface for drinks.  
- **Concrete Component (Espresso)**: Base drink implementation.  
- **Decorator (AddOnDecorator)**: Abstract class for add-ons.  
- **Concrete Decorators (Milk, Sugar, WhippedCream)**: Extend the base drink dynamically.  


---

### 2. Proxy Pattern
- **Subject (IngredientStock)**: Interface to check ingredient availability.  
- **RealSubject (RealIngredientStock)**: Simulates expensive loading from a database.  
- **Proxy (ProxyIngredientStock)**: Lazily loads the real subject and caches the result for faster access.  



