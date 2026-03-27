import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private static final String FILE_NAME = "Patient.ser";
    private static ArrayList<Patient> patientList = new ArrayList<>();

    static { loadPatient(); }

    public static int totalPatientCount = 0;

    public Patient(String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress);
        totalPatientCount++;

        patientList.add(this);
    }

    public static int getTotalPatients(){
        return totalPatientCount;
    }

    @Override
    public String getDetails(){
        return super.getDetails() + " - Patient";
    }

    public static void loadPatient(){
        patientList = Extent.loadClassList(FILE_NAME);
    }

    public static void savePatient(){
        Extent.saveClassList(FILE_NAME, patientList);
    }

    public static List<Patient> getPatientList(){
        return Extent.getImmutableClassList(patientList);
    }
}
