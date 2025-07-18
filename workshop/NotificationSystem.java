package workshop;

//File: NotificationSystem.java

import java.util.LinkedList;

interface Notification {
	void deliver();
}

//Email Notification implementation
class EmailNotification implements Notification {
	private String emailAddress;

	public EmailNotification(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public void deliver() {
		System.out.println("Sending Email to " + emailAddress);
	}
}

//SMS Notification implementation
class SMSNotification implements Notification {
	private String phoneNumber;

	public SMSNotification(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public void deliver() {
		System.out.println("Sending SMS to " + phoneNumber);
	}
}

//Push Notification implementation
class PushNotification implements Notification {
	private String deviceToken;

	public PushNotification(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	@Override
	public void deliver() {
		System.out.println("Sending Push Notification to device " + deviceToken);
	}
}

//NotificationQueue encapsulates the delivery queue
class NotificationQueue {
	private LinkedList<Notification> deliveryQueue;

	public NotificationQueue() {
		deliveryQueue = new LinkedList<>();
	}

	public void add(Notification notification) {
		deliveryQueue.add(notification);
	}

	public void sendAll() {
		while (!deliveryQueue.isEmpty()) {
			Notification currentNotification = deliveryQueue.removeFirst();
			currentNotification.deliver();
		}
	}
}

//Test Class
public class NotificationSystem {
	public static void main(String[] args) {
		NotificationQueue queue = new NotificationQueue();

		queue.add(new EmailNotification("govind@example.com"));
		queue.add(new SMSNotification("+919876543210"));
		queue.add(new PushNotification("device_token_123"));

		queue.sendAll();
	}
}
