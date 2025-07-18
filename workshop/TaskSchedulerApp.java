package workshop;

import java.util.LinkedList;

interface Task {
	int getPriority();
	void execute();
	String getDescription();
}

class EmailTask implements Task {
	private final String recipient;
	private final String subject;
	private final int priority;

	public EmailTask(String recipient, String subject, int priority) {
		this.recipient = recipient;
		this.subject = subject;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void execute() {
		System.out.println("Sending email to: " + recipient + " | Subject: " + subject);
	}

	public String getDescription() {
		return "Email to " + recipient + " [Priority: " + priority + "]";
	}
}


class ReportTask implements Task {
	private final String reportName;
	private final int priority;

	public ReportTask(String reportName, int priority) {
		this.reportName = reportName;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void execute() {
		System.out.println("Generating report: " + reportName);
	}

	public String getDescription() {
		return "Report: " + reportName + " [Priority: " + priority + "]";
	}
}

class TaskScheduler {
	private final LinkedList<Task> taskQueue = new LinkedList<>();

	public void addTask(Task task) {
		int insertIndex = 0;
		while (insertIndex < taskQueue.size() && taskQueue.get(insertIndex).getPriority() >= task.getPriority()) {
			insertIndex++;
		}
		taskQueue.add(insertIndex, task);
	}

	public void runAllTasks() {
		while (!taskQueue.isEmpty()) {
			Task task = taskQueue.removeFirst();
			System.out.println("Executing: " + task.getDescription());
			task.execute();
		}
	}
}

public class TaskSchedulerApp {
	public static void main(String[] args) {
		TaskScheduler scheduler = new TaskScheduler();

		scheduler.addTask(new EmailTask("alice@example.com", "Project Update", 2));
		scheduler.addTask(new ReportTask("Quarterly Report", 3));
		scheduler.addTask(new EmailTask("bob@example.com", "Meeting Reminder", 1));

		scheduler.runAllTasks();
	}
}
