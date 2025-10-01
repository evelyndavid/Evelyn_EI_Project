# Evelyn_EI_Project

Java projects demonstrating OOP principles and key design patterns (Observer, Strategy, Builder, Factory, Bridge, Decorator) through real-world examples like Smart Home System simulation, stock updates, sorting, online courses, transport booking, EV charging, and blockchain transactions. Focused on clean, flexible, and maintainable code.

---

## EXP 1 : Design Patterns Demonstration in Java

This repository demonstrates Behavioral, Creational, and Structural Design Patterns in Java through practical applications. Each example highlights how design patterns improve code flexibility, maintainability, and decoupling.

---

### Behavioral Patterns

#### 1. Observer Pattern – Stock Price Notifier
**Purpose:** Defines a one-to-many dependency so that when the subject changes, all observers are notified automatically.  
**Application:** Stock Market Notifier  

- **Subject:** `StockMarket` → holds stock price  
- **Observers:** `StockObserver` → investors receiving updates  
- **Scenario:** Whenever stock price changes, all registered investors are notified  

**Classes:**
- `Observer` → Interface declaring `update()`  
- `StockObserver` → Concrete observer printing notifications  
- `StockSubject` → Base subject managing observer list  
- `StockMarket` → Concrete subject holding price and notifying observers  
- `Main` → Demo client to simulate updates  

**Pattern Achieved:**
- Observers implement a common interface  
- Subject maintains observer list  
- Changes trigger `notifyObservers()`, updating all observers dynamically  

---

#### 2. Strategy Pattern – Sorting Algorithm Selector
**Purpose:** Defines a family of algorithms, encapsulates each, and makes them interchangeable at runtime.  
**Application:** Dynamic sorting  

- **Context:** `SortContext` → executes chosen strategy  
- **Strategies:** `BubbleSort`, `QuickSort`, `MergeSort`  
- **Scenario:** Switch sorting algorithm at runtime based on dataset  

**Classes:**
- `SortStrategy` → Strategy interface defining `sort()`  
- `BubbleSort`, `QuickSort`, `MergeSort` → Concrete strategies  
- `SortContext` → Context holding and executing a strategy  
- `Main` → Demo client to test sorting algorithms  

**Pattern Achieved:**
- Context delegates sorting to chosen strategy  
- Algorithms are interchangeable without modifying client  

---

### Creational Patterns

#### 1. Builder Pattern – Online Course Builder
**Purpose:** Constructs complex objects step by step with optional components, avoiding complex constructors.  
**Application:** Online Course Assembly  

- **Mandatory:** Course title  
- **Optional:** Modules, Quizzes, Assignments, Certificate  

**Classes:**
- `Course` → Product class  
- `CourseBuilder` → Builder class  
- `OnlineCourseDirector` → Director providing prebuilt courses  
- `Main` → Client requesting courses  

**Pattern Achieved:**
- Builder assembles optional parts dynamically  
- Director offers predefined course configurations  

---

#### 2. Factory Method Pattern – Transport Service Factory
**Purpose:** Creates objects without specifying exact class, delegating to a factory for flexibility.  
**Application:** Transport Booking System  

- **Services:** Bus, Train, Flight  

**Classes:**
- `TransportService` → Interface defining `bookTicket()`  
- `BusService`, `TrainService`, `FlightService` → Concrete implementations  
- `TransportFactory` → Factory returning appropriate service  
- `Main` → Client requesting services via factory  

**Pattern Achieved:**
- Factory creates objects dynamically  
- Client depends on interface only  
- Extensible for adding new services  

---

### Structural Patterns

#### 1. Bridge Pattern – EV Charging Simulation
**Purpose:** Decouples abstraction from implementation for independent variation.  
**Application:** EV charging  

- **Abstraction:** `ChargingSession`  
- **Refined Abstraction:** `ChargingStation`  
- **Implementor:** `ChargerVendor`  
- **Concrete Implementors:** `TeslaCharger`, `TataCharger`, `GenericCharger`  

**Pattern Achieved:**
- Abstraction delegates to implementor  
- New vendors or session types added without modifying existing code  

---

#### 2. Decorator Pattern – Blockchain Transaction Enhancements
**Purpose:** Dynamically adds responsibilities to objects without altering base code.  
**Application:** Enhance blockchain transactions  

- **Component:** `Transaction` → `execute()`  
- **Concrete Component:** `BaseTransaction`  
- **Decorators:** `FeeDecorator`, `EncryptionDecorator`, `NotificationDecorator`, `AnalyticsDecorator`  

**Pattern Achieved:**
- Base transaction is wrapped dynamically with decorators  
- Features like fees, encryption, and analytics added at runtime  

---

### How to Run
```bash
# Clone the repository
git clone <your-repo-link>
cd <project-folder>

# Compile Java files
javac *.java

# Run programs
java -cp . Main

EXP 2 : Smart Home System

A console-based simulation of a Smart Home System that allows users to manage and automate smart devices such as lights, thermostats, and door locks through a central hub. This project focuses on logic, code quality, and the application of OOP principles and design patterns rather than UI aesthetics.

Features
1. Device Management

Initialize the system with default devices: lights, thermostat, and door locks

Add new devices dynamically with a unique ID and type

Remove devices dynamically

Prevent adding devices with duplicate IDs

Gracefully handle attempts to remove non-existing devices

2. Device Control

Turn devices ON or OFF with proper logging

Prevent turning ON an already ON device or turning OFF an already OFF device

Provide meaningful feedback to the user

3. Status Reporting

View the status of all devices at any time

Display device details (type, ID, current state or temperature)

4. Scheduling (Simulation)

Schedule devices to turn ON or OFF at a specific time

Scheduler is simulated for demonstration; actual time-based automation is not implemented

5. Automated Triggers

Create triggers based on device conditions (e.g., thermostat temperature exceeds a threshold)

Automatically perform actions like turning a device ON or OFF

Checks the current state to avoid unnecessary actions

Logs each trigger activation or if the device is already in the desired state

Allows the user to enter triggers dynamically with an example format for guidance

6. Error Handling

Handles invalid device IDs, duplicate device additions, and empty device lists gracefully

Prevents the program from crashing due to exceptions

Logs all important events and errors using a Logging Utility

Classes Overview

1. AbstractDevice (devices package)

Base class for all smart devices

Stores id, type, and isOn state

Methods: turn devices ON/OFF, getStatus(), isDeviceOn()

2. Light, Thermostat, Door (devices package)

Specific implementations of smart devices

Thermostat holds temperature

Light/Door inherit behavior from AbstractDevice

3. SmartDevice Interface

Defines basic operations for all smart devices (turnOn, turnOff, getStatus, getId, getType)

4. DeviceFactory (devices package)

Implements Factory Method pattern

Creates smart device instances based on type and ID

5. DeviceProxy (devices package)

Implements Proxy Pattern

Controls access to devices and logs actions

6. SmartHomeHub (hub package)

Central hub managing devices, schedules, and triggers

7. AutomationEngine (automation package)

Handles automation triggers

Stores triggers and executes actions if conditions are met

8. Trigger (automation package)

Represents an automation rule with condition and action

9. LoggingUtil (util package)

Centralized logging with info(), warn(), error() functions and timestamps

How Functionalities Are Achieved

Turn ON/OFF devices: Uses DeviceProxy, checks state to prevent unnecessary actions

View status: Hub collects device status and prints

Add/Remove devices: Hub validates unique IDs and logs events

Schedule commands: Simulated scheduling; hub maintains a list of commands

Automation triggers: Conditions checked and actions applied if needed; logs indicate results

Error handling: Graceful handling of invalid inputs and empty device lists

Design Patterns Implemented

Factory Method (Creational): DeviceFactory creates devices dynamically

Proxy Pattern (Structural): DeviceProxy controls access to operations

Observer/Automation Concept (Behavioral): AutomationEngine monitors device states

SOLID & OOP Principles: Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Encapsulation

Notes

Scheduler is simulated; tasks are stored and displayed but do not execute in real-time

All interactions happen via console input

Program continues running unless user chooses to exit

How to Run
# Compile all packages
javac Main.java devices/*.java hub/*.java util/*.java scheduler/*.java automation/*.java

# Run the program
java -cp . Main
