public class SmartwatchBuilder implements SmartDeviceBuilder {
    private static final double MAX_WATCH_SCREEN_SIZE = 2.5;
    private static final int MIN_WATCH_BATTERY = 50;
    private static final int MAX_WATCH_BATTERY = 1000;
    private static final double DEFAULT_WATCH_SCREEN_SIZE = 1.4;
    private static final int DEFAULT_WATCH_BATTERY = 300;


    private String brand;
    private String model;
    private String cpu;
    private double screenSize;
    private int batteryCapacity;
    private String operatingSystem;
    private boolean hasCellular;
    private boolean hasHeartRateMonitor;
    private String waterResistanceRating;

    public SmartwatchBuilder() {
        this.reset();
    }

    @Override
    public SmartDeviceBuilder reset() {
        this.brand = "Generic Wearable";
        this.model = "Smart Band";
        this.cpu = "Dual-Core S-Chip";
        this.screenSize = DEFAULT_WATCH_SCREEN_SIZE;
        this.batteryCapacity = DEFAULT_WATCH_BATTERY;
        this.operatingSystem = "WearOS";
        this.hasCellular = false;
        this.hasHeartRateMonitor = false;
        this.waterResistanceRating = "5ATM";
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
            throw new IllegalStateException("Brand, model, CPU, and operating system cannot be null.");
        }
        if (screenSize > MAX_WATCH_SCREEN_SIZE) {
            throw new IllegalStateException(
                    "Smartwatch screen size cannot exceed " + MAX_WATCH_SCREEN_SIZE + " inches. Given: " + screenSize
            );
        }
        if (batteryCapacity < MIN_WATCH_BATTERY || batteryCapacity > MAX_WATCH_BATTERY) {
            throw new IllegalStateException(
                    "Smartwatch battery capacity must be between " + MIN_WATCH_BATTERY +
                            " and " + MAX_WATCH_BATTERY + " mAh Given: " + batteryCapacity
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