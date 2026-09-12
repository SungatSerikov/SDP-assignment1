# SDP-assignment1

# Smart Device System (SDP Assignment 1)

Implementation of the **Builder Design Pattern** in Java. The project demonstrates constructing complex `SmartDevice` objects (smartphones and smartwatches) with flexible configurations, director presets, and type-       
specific validation rules.

    ---                                                                                                                                                                                                                          
                                                                                                                                                                                                                                 
    ## 1. Project Structure                                                                                                                                                                                                      
                                                                                                                                                                                                                                 
                                                                                                                                                                                                                          
    SDP-assignment1/                                                                                                                                                                                                             
    ├── src/                                                                                                                                                                                                                     
    │   ├── SmartDevice.java          # Product: The complex object being built                                                                                                                                                  
    │   ├── SmartDeviceBuilder.java   # Builder Interface: Declares steps to build device parts                                                                                                                                  
    │   ├── SmartphoneBuilder.java    # Concrete Builder: Builds smartphones with phone-specific rules                                                                                                                           
    │   ├── SmartwatchBuilder.java    # Concrete Builder: Builds smartwatches with watch-specific rules                                                                                                                          
    │   ├── DeviceDirector.java       # Director: Controls the construction sequence for preset models                                                                                                                           
    │   └── Main.java                 # Client: Demonstrates construction, presets, and validation                                                                                                                               
    ├── out/                          # Compiled bytecode (.class files)                                                                                                                                                         
    └── README.md                     # Project documentation                                                                                                                                                                    

### Pattern Roles

• Product (SmartDevice): The target object containing device attributes (hardware, OS, connectivity, etc.).                                                                                                                    
• Builder Interface (SmartDeviceBuilder): Defines fluent setter methods (setBrand, setModel, setScreenSize, etc.), reset(), and build().                                                                                       
• Concrete Builders (SmartphoneBuilder, SmartwatchBuilder): Implement construction steps and validate domain constraints for their respective device categories.                                                               
• Director (DeviceDirector): Encapsulates predefined recipes for popular device configurations.                                                                                                                                
• Client (Main): Interacts with the Director and Builders to instantiate devices.                                                                                                                                              
──────
## 2. What the Product Is

SmartDevice /src/SmartDevice.java represents a wearable or mobile smart device with the following properties:

• brand (String): Manufacturer name (e.g., Samsung, Apple, Garmin).                                                                                                                                                            
• model (String): Model line/name (e.g., Galaxy S24 Ultra, Forerunner 965).                                                                                                                                                    
• cpu (String): Processor chip specification.                                                                                                                                                                                  
• screenSize (double): Display diagonal in inches.                                                                                                                                                                             
• batteryCapacity (int): Battery capacity in mAh.                                                                                                                                                                              
• operatingSystem (String): Operating system (e.g., Android, watchOS, Garmin OS).                                                                                                                                              
• hasCellular (boolean): Cellular/LTE/eSIM support.                                                                                                                                                                            
• hasHeartRateMonitor (boolean): Built-in heart rate biometric sensor.                                                                                                                                                         
• waterResistanceRating (String): Ingress protection rating (e.g., IP68, 5ATM).

### Why the Builder Pattern?

• Eliminates telescoping constructors (constructors with 9+ positional arguments).                                                                                                                                             
• Supports constructing different representations (smartphones vs. smartwatches) using the same construction process.                                                                                                          
• Enforces strict data validation before the final object is instantiated.                                                                                                                                                     
──────
## 3. How to Build Each Representation

### A. Predefined Presets (via DeviceDirector)

The director configures standard models using any compatible builder:

    DeviceDirector director = new DeviceDirector();                                                                                                                                                                              
    SmartDeviceBuilder phoneBuilder = new SmartphoneBuilder();                                                                                                                                                                   
    SmartDeviceBuilder watchBuilder = new SmartwatchBuilder();                                                                                                                                                                   
                                                                                                                                                                                                                                 
    // 1. Flagship Smartphone (Samsung Galaxy S24 Ultra)                                                                                                                                                                         
    SmartDevice flagship = director.constructFlagshipPhone(phoneBuilder.reset());                                                                                                                                                
                                                                                                                                                                                                                                 
    // 2. Budget Smartphone (Xiaomi Redmi Note 13)                                                                                                                                                                               
    SmartDevice budget = director.constructBudgetPhone(phoneBuilder.reset());                                                                                                                                                    
                                                                                                                                                                                                                                 
    // 3. Sport Smartwatch (Garmin Forerunner 965)                                                                                                                                                                               
    SmartDevice sportWatch = director.constructSportSmartwatch(watchBuilder.reset());                                                                                                                                            
                                                                                                                                                                                                                                 
    // 4. Premium Smartwatch with cellular (Apple Watch Ultra 2)                                                                                                                                                                 
    SmartDevice premiumWatch = director.constructPremiumSmartwatch(watchBuilder.reset());                                                                                                                                        
──────
### B. Custom Representation (Direct Builder Chaining)

Clients can bypass the director to construct customized devices using the fluent API:

    SmartDevice customGamingPhone = new SmartphoneBuilder()                                                                                                                                                                      
            .reset()                                                                                                                                                                                                             
            .setBrand("ASUS")                                                                                                                                                                                                    
            .setModel("ROG Phone")                                                                                                                                                                                               
            .setCpu("Snapdragon 8 Gen 3")                                                                                                                                                                                        
            .setScreenSize(6.78)                                                                                                                                                                                                 
            .setBatteryCapacity(5500)                                                                                                                                                                                            
            .setOperatingSystem("Android 14")                                                                                                                                                                                    
            .enableCellular()                                                                                                                                                                                                    
            .setWaterResistanceRating("IP68")                                                                                                                                                                                    
            .build();                                                                                                                                                                                                            
──────
### C. Validation & Invariants

Each concrete builder enforces strict validation upon calling .build():

1. Smartphone Validation (SmartphoneBuilder):                                                                                                                                                                                  
   • screenSize >= 4.0 inches (otherwise throws IllegalStateException).                                                                                                                                                       
   • batteryCapacity >= 1000 mAh (otherwise throws IllegalStateException).                                                                                                                                                    
   • brand, model, cpu, and operatingSystem must not be null.
2. Smartwatch Validation (SmartwatchBuilder):                                                                                                                                                                                  
   • screenSize <= 2.5 inches (otherwise throws IllegalStateException).                                                                                                                                                       
   • batteryCapacity must be between 50 and 1000 mAh (otherwise throws IllegalStateException).                                                                                                                                
   • brand, model, cpu, and operatingSystem must not be null.


Example of catching validation errors:

    try {                                                                                                                                                                                                                        
        SmartDevice invalidWatch = new SmartwatchBuilder()                                                                                                                                                                       
                .reset()                                                                                                                                                                                                         
                .setBrand("Garmin")                                                                                                                                                                                              
                .setModel("Giant Prototype")                                                                                                                                                                                     
                .setScreenSize(6.5) // Exceeds 2.5" limit                                                                                                                                                                        
                .build();                                                                                                                                                                                                        
    } catch (IllegalStateException e) {                                                                                                                                                                                          
        System.err.println("Validation caught: " + e.getMessage());                                                                                                                                                              
    }                                                                                                                                                                                                                            
──────
## 4. How to Run It

### Prerequisites

• JDK (Java Development Kit): version 8 or higher (JDK 17 or 21 recommended).

### Option 1: Command Line

1. Open a terminal in the project root (SDP-assignment1).
2. Compile the Java files:                                                                                                                                                                                                     
   javac -d out src/*.java

3. Run Main:                                                                                                                                                                                                                   
   java -cp out Main