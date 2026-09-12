public class SmartphoneBuilder implements SmartDeviceBuilder {
    private static final double MIN_PHONE_SCREEN_SIZE = 4.0;
    private static final int MIN_PHONE_BATTERY = 1000;
    private static final double DEFAULT_PHONE_SCREEN_SIZE = 6.1;
    private static final int DEFAULT_PHONE_BATTERY = 4000;

    private String brand;
    private String model;
    private String cpu;
    private double screenSize;
    private int batteryCapacity;
    private String operatingSystem;
    private boolean hasCellular;
    private boolean hasHeartRateMonitor;
    private String waterResistanceRating;

    public SmartphoneBuilder() {
        this.reset();
    }

    @Override
    public SmartDeviceBuilder reset() {
        this.brand = "Unknown Brand";
        this.model = "Base Model";
        this.cpu = "ARM Cortex";
        this.screenSize = DEFAULT_PHONE_SCREEN_SIZE;
        this.batteryCapacity = DEFAULT_PHONE_BATTERY;
        this.operatingSystem = "Android";
        this.hasCellular = false;
        this.hasHeartRateMonitor = false;
        this.waterResistanceRating = "IP68";
        return this;
    }

    @Override
    public SmartDeviceBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public SmartDeviceBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    @Override
    public SmartDeviceBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @Override
    public SmartDeviceBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    @Override
    public SmartDeviceBuilder setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    @Override
    public SmartDeviceBuilder setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    @Override
    public SmartDeviceBuilder enableCellular() {
        this.hasCellular = true;
        return this;
    }

    @Override
    public SmartDeviceBuilder enableHeartRateMonitor() {
        this.hasHeartRateMonitor = true;
        return this;
    }

    @Override
    public SmartDeviceBuilder setWaterResistanceRating(String waterResistanceRating) {
        this.waterResistanceRating = waterResistanceRating;
        return this;
    }

    @Override
    public SmartDevice build() {
        if (brand == null || model == null || cpu == null || operatingSystem == null) {
            throw new IllegalStateException("Brand, model, CPU, and operating system cannot be null");
        }
        if (screenSize < MIN_PHONE_SCREEN_SIZE) {
            throw new IllegalStateException(
                    "A smartphone screen cannot be smaller than " + MIN_PHONE_SCREEN_SIZE + " inches. Given: " + screenSize
            );
        }
        if (batteryCapacity < MIN_PHONE_BATTERY) {
            throw new IllegalStateException(
                    "A smartphone battery capacity must be at least " + MIN_PHONE_BATTERY + " mAh. Given: " + batteryCapacity
            );
        }
        return new SmartDevice(
                brand,
                model,
                cpu,
                screenSize,
                batteryCapacity,
                operatingSystem,
                hasCellular,
                hasHeartRateMonitor,
                waterResistanceRating
        );
    }
}