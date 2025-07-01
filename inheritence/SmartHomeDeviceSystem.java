package inheritence;

class Device {
 protected String deviceId;
 protected String status;

 Device(String deviceId, String status) {
     this.deviceId = deviceId;
     this.status = status;
 }

 void displayStatus() {
     System.out.println("Device ID: " + deviceId);
     System.out.println("Status: " + status);
 }
}

class Thermostat extends Device {
 private double temperatureSetting;

 Thermostat(String deviceId, String status, double temperatureSetting) {
     super(deviceId, status);
     this.temperatureSetting = temperatureSetting;
 }

 @Override
 void displayStatus() {
     super.displayStatus();
     System.out.println("Device Type: Thermostat");
     System.out.println("Temperature: " + temperatureSetting + "°C");
 }
}

public class SmartHomeDeviceSystem {
 public static void main(String[] args) {
     Thermostat t1 = new Thermostat("TH001", "Active", 22.5);

     System.out.println("--- Smart Device Status ---");
     t1.displayStatus();
 }
}
