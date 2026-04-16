import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Patient> patients = Patient.getPatientList();

        if (patients.isEmpty()) {
            System.out.println("No patients found in the system.\nCreating and saving new patients");

            Address address1 = new Address("Poland", "Warsaw", "Polwar", "8/10", "01-234");
            Patient patient1 = new Patient("John", "Robert", "Doe", LocalDate.of(1985, 8, 15), "Male", address1, "12332212311");
            patient1.addPhoneNumber("+123456789");

            Address address2 = new Address("Turkey", "Istanbul", "Kadikoy", "12/4", "34000");
            Patient patient2 = new Patient("Jane", "", "Smith", LocalDate.of(1992, 11, 23), "Female", address2, "12332112312");

            System.out.println("New patients created");

        }
        else {
            // Attempt to add new data to existing records
            Address address3 = new Address("Country", "City", "Street", "123", "123213");
            Patient patient3 = new Patient("Bla", "OptionalMiddle", "Bla", LocalDate.of(1992, 11, 23), "Female", address3, "12332112313");

            System.out.println("Records successfully loaded from file");
            System.out.println("Loaded Patient Count: " + patients.size());

            System.out.println("--- Details of Loaded Patients ---");
            for (Patient p : patients) {
                System.out.println(p.getDetails());
                System.out.println("Age: " + p.getAge());
                System.out.println("PESEL: " + p.getPesel());
                System.out.println("Phone: " + (p.getPhoneNumber().isEmpty() ? "None" : p.getPhoneNumber()));
                System.out.println("Middle Name: " + p.getMiddleName().orElse("Not specified"));
                System.out.println("-------------------------------------");
            }
        }
    }
}