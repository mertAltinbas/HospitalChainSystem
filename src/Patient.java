import java.time.LocalDate;

public class Patient extends Person {
    public static int totalPatientCount = 0;

    public Patient(String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress);
        totalPatientCount++;
    }

    public static int getTotalPatients(){
        return totalPatientCount;
    }

    @Override
    public String getDetails(){
        return super.getDetails() + " Patient";
    }
}
