public class SmartDevice {
    private  String brand;
    private  String model;
    private  String cpu;
    private  double screenSize;
    private  int batteryCapacity;
    private  String operatingSystem;
    private  boolean hasCellular;
    private  boolean hasHeartRateMonitor;
    private  String waterResistanceRating;

     SmartDevice(String brand, String model, String cpu, double screenSize, int batteryCapacity,
                       String operatingSystem, boolean hasCellular, boolean hasHeartRateMonitor,
                       String waterResistanceRating) {
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.screenSize = screenSize;
        this.batteryCapacity = batteryCapacity;
        this.operatingSystem = operatingSystem;
        this.hasCellular = hasCellular;
        this.hasHeartRateMonitor = hasHeartRateMonitor;
        this.waterResistanceRating = waterResistanceRating;
    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", cpu='" + cpu + '\'' +
                ", sreenSize=" + screenSize +
                ", batteryCapacity=" + batteryCapacity +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", hasCellular=" + hasCellular +
                ", hasHeartRateMonitor=" + hasHeartRateMonitor +
                ", waterResistanceRating='" + waterResistanceRating + '\'' +
                '}';
    }

}
