package interfaces;

interface SensitiveData {
}

class UserCredentials implements SensitiveData {
	String username, password;

	UserCredentials(String u, String p) {
		username = u;
		password = p;
	}
}

public class SensitiveDataTagging {
	public static void main(String[] args) {
		UserCredentials c = new UserCredentials("admin", "12345");
		if (c instanceof SensitiveData) {
			System.out.println("Encrypt before saving");
		}
	}
}
