package workshop;

//File: BrowserNavigationSystem.java

import java.util.Stack;

//Interface for navigation management
interface NavigationManager {
 void visit(String url);
 void goBack();
 void goForward();
 void currentPage();
}

//Desktop browser implementation
class DesktopNavigationManager implements NavigationManager {
 private Stack<String> backStack;
 private Stack<String> forwardStack;
 private String current;

 public DesktopNavigationManager() {
     backStack = new Stack<>();
     forwardStack = new Stack<>();
     current = null;
 }

 @Override
 public void visit(String url) {
     if (current != null) {
         backStack.push(current);
     }
     current = url;
     forwardStack.clear();
     System.out.println("Visited: " + url);
 }

 @Override
 public void goBack() {
     if (!backStack.isEmpty()) {
         forwardStack.push(current);
         current = backStack.pop();
         System.out.println("Went Back to: " + current);
     } else {
         System.out.println("No page to go back to.");
     }
 }

 @Override
 public void goForward() {
     if (!forwardStack.isEmpty()) {
         backStack.push(current);
         current = forwardStack.pop();
         System.out.println("Went Forward to: " + current);
     } else {
         System.out.println("No page to go forward to.");
     }
 }

 @Override
 public void currentPage() {
     System.out.println("Current Page: " + current);
 }
}

//Test class
public class BrowserNavigationSystem {
 public static void main(String[] args) {
     NavigationManager browser = new DesktopNavigationManager();

     browser.visit("google.com");
     browser.visit("github.com");
     browser.visit("stackoverflow.com");

     browser.goBack();
     browser.goBack();
     browser.goForward();

     browser.currentPage();
 }
}

