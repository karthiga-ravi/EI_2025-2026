# ☕ Coffee Shop – Creational Design Patterns

This project demonstrates **Creational Design Patterns** in Java, specifically:  

- **Abstract Factory Pattern** – to create families of related products (hot or cold drinks).  
- **Builder Pattern** – to build complex coffee objects step by step with customizations.  

---

## Features
- **Abstract Factory Pattern**  
  - Choose between **Hot** and **Cold** drinks.  
  - Each factory produces a family of drinks (Coffee and Tea).  
- **Builder Pattern**  
  - Customize a Coffee order with milk, sugar, syrup, and size.  
  - Flexible construction of coffee objects without multiple constructors.  

---

## Design Patterns Used

### 1. Abstract Factory Pattern
- **Abstract Factory (DrinkFactory)**: Defines methods to create coffee and tea.  
- **Concrete Factories (HotDrinkFactory, ColdDrinkFactory)**: Create hot or cold drinks.  
- **Products (CoffeeDrink, TeaDrink)**: Interfaces for drink types.  
- **Concrete Products (HotEspresso, HotGreenTea, IcedLatte, IcedTea)**: Implement specific drinks.  

---

### 2. Builder Pattern
- **Product (Coffee)**: The final coffee object with type, milk, sugar, syrup, and size.  
- **Builder (Coffee.Builder)**: Inner class to incrementally build a Coffee object.  

