public class DeviceDirector {
    public SmartDevice constructFlagshipPhone(SmartDeviceBuilder builder) {
        return builder
                .setBrand("Samsung")
                .setModel("Galaxy S24 Ultra")
                .setCpu("Snapdragon 8 Gen 3")
                .setScreenSize(6.8)
                .setBatteryCapacity(5000)
                .setOperatingSystem("Android 14")
                .enableCellular()
                .setWaterResistanceRating("IP68")
                .build();
    }

    public SmartDevice constructBudgetPhone(SmartDeviceBuilder builder) {
        return builder
                .setBrand("Xiaomi")
                .setModel("Redmi Note 13")
                .setCpu("MediaTek Dimensity 6080")
                .setScreenSize(6.67)
                .setBatteryCapacity(5000)
                .setOperatingSystem("Android 13")
                .enableCellular()
                .setWaterResistanceRating("IP54")
                .build();
    }

    public SmartDevice constructSportSmartwatch(SmartDeviceBuilder builder) {
        return builder
                .setBrand("Garmin")
                .setModel("Forerunner 965")
                .setCpu("Garmin Dual-Core")
                .setScreenSize(1.4)
                .setBatteryCapacity(450)
                .setOperatingSystem("Garmin OS")
                .enableHeartRateMonitor()
                .setWaterResistanceRating("5ATM")
                .build();
    }

    public SmartDevice constructPremiumSmartwatch(SmartDeviceBuilder builder) {
        return builder
                .setBrand("Apple")
                .setModel("Watch Ultra 2")
                .setCpu("Apple S9 SiP")
                .setScreenSize(1.92)
                .setBatteryCapacity(564)
                .setOperatingSystem("watchOS 10")
                .enableCellular()
                .enableHeartRateMonitor()
                .setWaterResistanceRating("100m")
                .build();
    }
}