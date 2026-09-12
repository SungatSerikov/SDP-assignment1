public interface SmartDeviceBuilder {
    SmartDeviceBuilder setBrand(String brand);
    SmartDeviceBuilder setModel(String model);
    SmartDeviceBuilder setCpu(String cpu);
    SmartDeviceBuilder setScreenSize(double screenSize);
    SmartDeviceBuilder setBatteryCapacity(int batteryCapacity);
    SmartDeviceBuilder setOperatingSystem(String operatingSystem);
    SmartDeviceBuilder enableCellular();
    SmartDeviceBuilder enableHeartRateMonitor();
    SmartDeviceBuilder setWaterResistanceRating(String waterResistanceRating);
    SmartDeviceBuilder reset();
    SmartDevice build();


}
