package interfaces;

interface BackupSerializable {}

class Employee implements BackupSerializable {
    String name;
    Employee(String name) { this.name = name; }
}

public class DataSerializationBackup {
    public static void main(String[] args) {
        Employee e = new Employee("Amit");
        if(e instanceof BackupSerializable) {
            System.out.println("Employee marked for backup");
        }
    }
}
