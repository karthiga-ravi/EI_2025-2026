# Coffee Shop Ordering System ☕

This project demonstrates the use of **Design Patterns in Java**, specifically the **Observer Pattern** and the **Command Pattern**, applied in a simple coffee shop ordering system.  

---

## Features
- **Observer Pattern**  
  - Notifies multiple observers (Coffee Maker and Customer) when an order is ready.  
- **Command Pattern**  
  - Allows placing orders as commands and provides the ability to undo an order.  

---

## Design Patterns Used

### 1. **Observer Pattern**
- **Subject (OrderNotifier)**: Maintains a list of observers and notifies them when an order is ready.  
- **Observers (CoffeeMakerObserver, CustomerObserver)**: Receive notifications when the order is completed.  

### 2. **Command Pattern**
- **Command Interface (Command)**: Defines `execute()` and `undo()` methods.  
- **Concrete Command (PlaceOrderCommand)**: Encapsulates an order action.  
- **Receiver (CoffeeMaker)**: Knows how to perform the actual operations (make/cancel drinks).  
- **Invoker (OrderManager)**: Stores commands and allows undoing the last order.  
