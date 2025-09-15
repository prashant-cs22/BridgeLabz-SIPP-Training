package lambdaFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NotificationFiltering {

    public static void main(String[] args) {
        List<Notification> notifications = Arrays.asList(
            new Notification("CRITICAL", "Server is down!"),
            new Notification("NORMAL", "New patient admitted."),
            new Notification("URGENT", "Patient heart rate low."),
            new Notification("CRITICAL", "Fire alarm triggered.")
        );

        Predicate<Notification> isUrgentOrCritical = n -> n.getLevel().equals("URGENT") || n.getLevel().equals("CRITICAL");

        List<Notification> urgentNotifications = notifications.stream()
            .filter(isUrgentOrCritical)
            .collect(Collectors.toList());

        System.out.println("All notifications: " + notifications);
        System.out.println("Filtered urgent/critical notifications: " + urgentNotifications);
    }

    static class Notification {
        private String level;
        private String message;

        public Notification(String level, String message) {
            this.level = level;
            this.message = message;
        }

        public String getLevel() { return level; }

        @Override
        public String toString() {
            return String.format("[%s] %s", level, message);
        }
    }
}
