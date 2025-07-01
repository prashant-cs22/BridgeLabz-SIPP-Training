package inheritence;

class Order {
	int orderId;
	String orderDate;
	
	Order(int orderId, String orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	
	void orderStatus() {
		System.out.println("Order placed on " + orderDate);
	}
	
	void displayDetails() {
		System.out.println("Order id: " + this.orderId);
		System.out.println("Order date: " + this.orderDate);
	}
}

class ShippedOrder extends Order {
	int trackingId;
	
	ShippedOrder(int orderId, String orderDate, int trackingId) {
		super(orderId, orderDate);
		this.trackingId = trackingId;
	}
	
	@Override
	void orderStatus() {
		System.out.println("Order shipped with tracking id " + trackingId);
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Tracking id: " + trackingId);
	}
}

class DeliveredOrder extends ShippedOrder {
	String deliveryDate;
	
	DeliveredOrder(int orderId, String orderDate, int trackingId, String deliveryDate) {
		super(orderId, orderDate, trackingId);
		this.deliveryDate = deliveryDate;
	}
	
	@Override
	void orderStatus() {
		System.out.println("Order has delivered on " + deliveryDate);
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Delivery date: " + deliveryDate);
	}
}

public class OnlineOrderManagement {

	public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(01, "2025-07-01", 5455244, "2025-07-04");

        System.out.println("--- Order Lifecycle ---");
        order.displayDetails();
        order.orderStatus();
	}

}
