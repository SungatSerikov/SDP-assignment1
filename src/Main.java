public class Main {
    public static void main(String[] args) {
        DeviceDirector director = new DeviceDirector();
        SmartDeviceBuilder phoneBuilder = new SmartphoneBuilder();
        SmartDeviceBuilder watchBuilder = new SmartwatchBuilder();

        SmartDevice flagshipPhone = director.constructFlagshipPhone(phoneBuilder.reset());
        System.out.println("Flagship Smartphone:");
        System.out.println(flagshipPhone);

        SmartDevice budgetPhone = director.constructBudgetPhone(phoneBuilder.reset());
        System.out.println("Budget Smartphone:");
        System.out.println(budgetPhone);

        SmartDevice sportWatch = director.constructSportSmartwatch(watchBuilder.reset());
        System.out.println("Sport Smartwatch:");
        System.out.println(sportWatch);

        SmartDevice premiumWatch = director.constructPremiumSmartwatch(watchBuilder.reset());
        System.out.println("Premium Smartwatch (with eSIM):");
        System.out.println(premiumWatch);

        SmartDevice customGamingPhone = new SmartphoneBuilder()
                .reset()
                .setBrand("ASUS")
                .setModel("ROG Phone")
                .setCpu("Snapdragon 8 Gen 3 ")
                .setScreenSize(6.78)
                .setBatteryCapacity(5500)
                .setOperatingSystem("Android 14")
                .enableCellular()
                .setWaterResistanceRating("IP68")
                .build();

        System.out.println("Custom Gaming Smartphone:");
        System.out.println(customGamingPhone);


        try {
            SmartDevice invalidWatch = new SmartwatchBuilder()
                    .reset()
                    .setBrand("Garmin")
                    .setModel("Giant Prototype")
                    .setScreenSize(6.5)
                    .build();
            System.out.println(invalidWatch);
        } catch (IllegalStateException e) {
            System.err.println("Validation caught successfully: " + e.getMessage());
        }

        try {
            SmartDevice invalidPhone = new SmartphoneBuilder()
                    .reset()
                    .setBrand("TinyPhone")
                    .setModel("Micro 1")
                    .setScreenSize(2.0)
                    .build();
            System.out.println(invalidPhone);
        } catch (IllegalStateException e) {
            System.err.println("Validation caught successfully: " + e.getMessage());
        }
    }
}