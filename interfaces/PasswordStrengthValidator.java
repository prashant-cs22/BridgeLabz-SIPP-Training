package interfaces;

interface SecurityUtils {
    static boolean isStrongPassword(String pwd) {
        return pwd.length() >= 8 && pwd.matches(".*[A-Z].*") && pwd.matches(".*[0-9].*");
    }
}

public class PasswordStrengthValidator {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Pass1234"));
        System.out.println(SecurityUtils.isStrongPassword("weak"));
    }
}

