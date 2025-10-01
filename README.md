# Evelyn_EI_Project
Java projects demonstrating OOP principles and key design patterns (Observer, Strategy, Builder, Factory, Bridge, Decorator) through real-world examples like Smart Home System simulation, stock updates, sorting, online courses, transport booking, EV charging, and blockchain transactions. Focused on clean, flexible, and maintainable code.


**EXP 1 : Design Patterns Demonstration in Java**

This repository demonstrates Behavioral, Creational, and Structural Design Patterns in Java through practical applications. Each example highlights how design patterns improve code flexibility, maintainability, and decoupling.
________________________________________
**Behavioral Patterns
1. Observer Pattern – Stock Price Notifier**
      Purpose: Defines a one-to-many dependency so that when the subject changes, all observers are notified automatically.
      Application: Stock Market Notifier
          •	Subject: StockMarket → holds stock price
          •	Observers: StockObserver → investors receiving updates
          •	Scenario: Whenever stock price changes, all registered investors are notified
**Classes:**

Observer	=> Interface declaring update()
StockObserver	=> Concrete observer printing notifications
StockSubject	=> Base subject managing observer list
StockMarket	  => Concrete subject holding price and notifying observers
Main	=> Demo client to simulate updates
**Pattern Achieved:**
          •	Observers implement a common interface
          •	Subject maintains observer list
          •	Changes trigger notifyObservers(), updating all observers dynamically
________________________________________
**2. Strategy Pattern – Sorting Algorithm Selector**
      **Purpose: Defines a family of algorithms, encapsulates each, and makes them interchangeable at runtime.
      Application: Dynamic sorting**
            •	Context: SortContext → executes chosen strategy
            •	Strategies: BubbleSort, QuickSort, MergeSort
            •	Scenario: Switch sorting algorithm at runtime based on dataset
**Classes**:
SortStrategy	=> Strategy interface defining sort()
BubbleSort, QuickSort, MergeSort	=> Concrete strategies
SortContext	  => Context holding and executing a strategy
Main	 => Demo client to test sorting algorithms
**Pattern Achieved:**
          •	Context delegates sorting to chosen strategy
          •	Algorithms are interchangeable without modifying client
________________________________________
**Creational Patterns**
**1. Builder Pattern – Online Course Builder**
      **Purpose: Constructs complex objects step by step with optional components, avoiding complex constructors.
      Application: Online Course Assembly**
                •	Mandatory: Course title
                •	Optional: Modules, Quizzes, Assignments, Certificate
**Classes:**
Course	=> Product class
CourseBuilder	=> Builder class
OnlineCourseDirector	=> Director providing prebuilt courses
Main	=> Client requesting courses
    **Pattern Achieved:**
          •	Builder assembles optional parts dynamically
          •	Director offers predefined course configurations
________________________________________
**2. Factory Method Pattern – Transport Service Factory**
        **Purpose: Creates objects without specifying exact class, delegating to a factory for flexibility.
        Application: Transport Booking System**
              •	Services: Bus, Train, Flight
**Classes:**
TransportService	=> Interface defining bookTicket()
BusService, TrainService, FlightService	 => Concrete implementations
TransportFactory	=> Factory returning appropriate service
Main	=>  Client requesting services via factory
**Pattern Achieved:**
        •	Factory creates objects dynamically
        •	Client depends on interface only
        •	Extensible for adding new services
________________________________________
**Structural Patterns**
**1. Bridge Pattern – EV Charging Simulation**
    **Purpose: Decouples abstraction from implementation for independent variation.
    Application: EV charging**  
        •	Abstraction: ChargingSession
        •	Refined Abstraction: ChargingStation
        •	Implementor: ChargerVendor
        •	Concrete Implementors: TeslaCharger, TataCharger, GenericCharger
**Pattern Achieved:**
        •	Abstraction delegates to implementor
        •	New vendors or session types added without modifying existing code

**2. Decorator Pattern – Blockchain Transaction Enhancements**
    **Purpose**: Dynamically adds responsibilities to objects without altering base code.
    **Application**: Enhance blockchain transactions
          •	Component: Transaction → execute()
          •	Concrete Component: BaseTransaction
          •	Decorators: FeeDecorator, EncryptionDecorator, NotificationDecorator, AnalyticsDecorator
**Pattern Achieved:**
          •	Base transaction is wrapped dynamically with decorators
          •	Features like fees, encryption, and analytics added at runtime
________________________________________
**How to Run
1.	Clone the repository:**
    git clone <your-repo-link>
    cd <project-folder>
**2.	Compile Java files:**
    javac *.java
**3.	Run demo programs (example for Observer pattern):**
    java -cp . Main

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

****EXP 2 : Smart Home System ****
A console-based simulation of a Smart Home System that allows users to manage and automate smart devices such as lights, thermostats, and door locks through a central hub. This project focuses on logic, code quality, and the application of OOP principles and design patterns rather than UI aesthetics.
________________________________________
**Features
**1.	Device Management****
      o	Initialize the system with default devices: lights, thermostat, and door locks.
      o	Add new devices dynamically with a unique ID and type.
      o	Remove devices dynamically.
      o	Prevent adding devices with duplicate IDs.
      o	Gracefully handle attempts to remove non-existing devices.
**2.	Device Control**
      o	Turn devices ON or OFF with proper logging.
      o	Prevent turning ON an already ON device or turning OFF an already OFF device.
      o	Provide meaningful feedback to the user.
**3.	Status Reporting**
      o	View the status of all devices at any time.
      o	Display device details (type, ID, current state or temperature).
**4.	Scheduling (Simulation)**
      o	Schedule devices to turn ON or OFF at a specific time.
      o	Scheduler is simulated for demonstration; actual time-based automation is not implemented.
**5.	Automated Triggers**
      o	Create triggers based on device conditions (e.g., thermostat temperature exceeds a threshold).
      o	Automatically perform actions like turning a device ON or OFF.
      o	Checks the current state to avoid unnecessary actions.
      o	Logs each trigger activation or if the device is already in the desired state.
      o	Allows the user to enter triggers dynamically with an example format for guidance.
**6.	Error Handling**
      o	Handles invalid device IDs, duplicate device additions, and empty device lists gracefully.
      o	Prevents the program from crashing due to exceptions.
      o	Logs all important events and errors using a Logging Utility.
________________________________________
****Classes Overview
1. AbstractDevice (devices package)****
    •	Purpose: Base class for all smart devices.
    •	Functionality:
            o	Stores id, type, and isOn state.
            o	Provides methods to turn devices ON/OFF.
            o	Returns the status string for display.
            o	Includes a method to check if a device is currently ON (isDeviceOn()).
**2. Light, Thermostat, Door (devices package)**
    •	Purpose: Specific implementations of smart devices.
    •	Thermostat: Holds temperature and allows temperature checking.
    •	Light / Door: Inherit behavior from AbstractDevice.
**3. SmartDevice Interface**
    •	Purpose: Defines basic operations for all smart devices (turnOn, turnOff, getStatus, getId, getType).
**4. DeviceFactory (devices package)**
    •	Purpose: Implements Factory Method pattern.
    •	Functionality: Creates smart device instances (Light, Thermostat, Door) based on type and ID.
    •	Ensures modular creation without exposing implementation details.
**5. DeviceProxy (devices package)**
    •	Purpose: Implements Proxy Pattern.
    •	Functionality: Controls access to devices and logs when a device is being accessed.
    •	Ensures that all ON/OFF operations are mediated and traceable.
**6. SmartHomeHub (hub package)**
    •	Purpose: Central hub managing all devices, schedules, and triggers.
    •	Functionality:
            o	Adds, removes, and retrieves devices.
            o	Shows device status.
            o	Manages scheduling of commands.
            o	Manages automated triggers using AutomationEngine.
            o	Acts as the main controller connecting all components.
**7. AutomationEngine (automation package)**
    •	Purpose: Handles automation triggers.
    •	Functionality:
            o	Stores all triggers (condition, action).
            o	Executes actions when conditions are met (e.g., thermostat temperature > threshold).
            o	Checks device states before performing actions and logs all results.
**8. Trigger (automation package)**
    •	Purpose: Represents an automation rule.
    •	Contains: condition and action strings.
    •	Used by: AutomationEngine for executing automated tasks.
**9. LoggingUtil (util package)**
    •	Purpose: Centralized logging for all operations and events.
    •	Functions:
            o	info() → General messages.
            o	warn() → Warnings.
            o	error() → Errors.
    •	Adds timestamps for clarity.
________________________________________
**How Functionalities Are Achieved**

Turn ON/OFF devices	=> Uses DeviceProxy to safely turn devices ON or OFF. Checks device state first to prevent unnecessary actions.
View status	        => Hub collects device status strings from all devices and prints them.
Add / Remove devices =>	Hub adds/removes devices dynamically, validates unique IDs, and logs events.
Schedule commands	   => Users can set simulated schedules; hub maintains a list of scheduled commands.
Automation triggers  => User-defined triggers are stored in AutomationEngine. When executed, conditions are checked, actions are applied if needed, and logs indicate what happened.
Error handling	     => Gracefully handles invalid inputs and empty device lists, logs warnings or errors without stopping the program.
________________________________________
**Design Patterns Implemented**
**1.	Factory Method (Creational)**
    o	DeviceFactory creates devices (Light, Thermostat, Door) dynamically.
**2.	Proxy Pattern (Structural)**
    o	DeviceProxy controls access to device operations and logs actions.
**3.	Observer/Automation Concept (Behavioral)******
    o	AutomationEngine acts as an observer for triggers and monitors device states.
**4.	SOLID & OOP Principles**
    o	Single Responsibility: Each class has a single purpose.
    o	Open/Closed: New devices or triggers can be added without changing existing classes.
    o	Liskov Substitution: AbstractDevice can be replaced by any concrete device.
    o	Interface Segregation & Encapsulation: SmartDevice interface and proper getters/setters are used.
________________________________________
**Notes**
      •	Scheduler is simulated: Scheduled tasks are stored and displayed but do not execute in real-time.
      •	All interactions happen via console input.
      •	Program continues running unless the user explicitly chooses to exit.
________________________________________
**How to Run
1.	Compile all packages:**
        javac Main.java devices/*.java hub/*.java util/*.java scheduler/*.java automation/*.java 
**2.	Run the program:**
        java -cp . Main
3.	Follow console prompts to view status, control devices, add/remove devices, schedule tasks, and add triggers.
