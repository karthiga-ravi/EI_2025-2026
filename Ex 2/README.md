# 🛰️ Satellite Command System

## Overview

The **Satellite Command System** is a Java-based application that simulates controlling a satellite in orbit.  
The system allows users to issue commands such as rotating the satellite, activating/deactivating solar panels, and collecting data.

The project emphasizes **Object-Oriented Programming (OOP)** principles and **design patterns**, ensuring scalability, maintainability, and clean code practices.

---

## Features

* **Satellite Control**: Rotate the satellite (North, South, East, West) with type-safe `Enum` validation.  
* **Solar Panel Management**: Activate or deactivate panels dynamically.  
* **Data Collection**: Simulate satellite data collection.  
* **Logging**: Every command execution is timestamped and logged for tracking.  
* **Case-Insensitive Input**: User commands work regardless of input case (e.g., `NORTH`, `north`, `North`).  

---

## Key Components

### 1. Core 

* `Satellite` → Handles satellite operations (rotate, panels, collect data).  
* `SatelliteState` → Stores the satellite’s current status (orientation, panels, data) without behavior.
* `Direction` → Enum for valid directions (`NORTH`, `SOUTH`, `EAST`, `WEST`) ensuring type safety.  
* `SatelliteLogger` → Handles logging of all operations with timestamps.  

### 2. Commands

Encapsulates user actions using the **Command Pattern**:

* `RotateCommand` → Rotates the satellite to a valid direction.  
* `ActivatePanelsCommand` → Activates solar panels.  
* `DeactivatePanelsCommand` → Deactivates solar panels.  
* `CollectDataCommand` → Collects scientific data.  
* `Command` (interface) → Defines the base structure for all commands.  

### 3. Patterns

* `CommandFactory` → Creates command objects dynamically based on user input.  
* `SatelliteSingleton` → Ensures only one satellite instance exists in the system.  

### 4. Main Entry Point

* `Main.java` → Handles user interaction (menu options) and drives the simulation loop.

---

## Design Patterns

* **Command Pattern** → Encapsulates satellite operations as commands.  
* **Factory Pattern** → Dynamically instantiates commands from user input.  
* **Singleton Pattern** → Maintains a single satellite instance across the system.

---

## Example Usage

```text
Welcome to the Satellite Command System
Available Options:
1. Rotate Satellite
2. Activate Panels
3. Deactivate Panels
4. Collect Data
5. Show Status
6. Exit

Enter option: 1
Enter direction (North, South, East, West): east
2025-09-24T15:04:55.112762500 [LOG] Rotated to EAST

Enter option: 2
2025-09-24T15:05:01.145872300 [LOG] Panels Activated

Enter option: 4
2025-09-24T15:05:10.889172100 [LOG] Data Collected: 10 units
