import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        try {
            Address address1 = new Address("USA", "New York", "Broadway", "5A", "10001");
            Address address2 = new Address("UK", "London", "Baker Street", "221B", "NW1 6XE");
            LocalDate dob1 = LocalDate.of(1985, 8, 15);
            LocalDate dob2 = LocalDate.of(1992, 11, 23);

            Patient patient1 = new Patient("John", "Robert", "Doe", dob1, "Male", address1);
            Patient patient2 = new Patient("Jane", "", "Smith", dob2, "Female", address2);

            patient1.addPhoneNumber("+15551234567");
            patient1.addPhoneNumber("+15559876543");

            patient2.addPhoneNumber("+442079460958");

            System.out.println("--- Patient 1 Details ---");
            System.out.println(patient1.getDetails());
            System.out.println("Age: " + patient1.getAge());
            System.out.println("Middle Name: " + patient1.getMiddleName().orElse("N/A"));
            System.out.println("Phone Numbers: " + patient1.getPhoneNumber());

            System.out.println("\n--- Patient 2 Details ---");
            System.out.println(patient2.getDetails());
            System.out.println("Age: " + patient2.getAge());
            System.out.println("Middle Name: " + patient2.getMiddleName().orElse("N/A"));

            System.out.println("\n--- Appointments ---");
            patient1.scheduleAppointment(new Date());
            patient2.scheduleAppointment(new Date(), "Routine cardiology checkup");

            System.out.println("\nTotal Patients in System: " + Patient.getTotalPatients());

            System.out.println("\n--- Validation Test ---");
            System.out.println("Attempting to create a patient with an empty name...");
            Patient invalidPatient = new Patient("", "Error", "Test", LocalDate.now(), "Unknown", address1);

        } catch (IllegalArgumentException e) {
            System.err.println("Registration Failed! Error details: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}