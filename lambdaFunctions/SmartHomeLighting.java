package lambdaFunctions;

import java.util.function.Consumer;

public class SmartHomeLighting {

    public static void main(String[] args) {
        Consumer<String> motionSensorBehavior = (trigger) -> System.out.println("Triggered by " + trigger + ": Activating bright white lights.");
        Consumer<String> timeOfDayBehavior = (trigger) -> System.out.println("Triggered by " + trigger + ": Setting a warm, dimmed light.");
        Consumer<String> voiceCommandBehavior = (trigger) -> System.out.println("Triggered by " + trigger + ": Executing rainbow light pattern.");

        System.out.println("Simulating triggers...");
        motionSensorBehavior.accept("motion");
        timeOfDayBehavior.accept("time of day");
        voiceCommandBehavior.accept("voice command");
    }
}
