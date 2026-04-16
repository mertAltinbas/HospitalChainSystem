import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Patient> patientList = new ArrayList<>();

    static { loadPatient(); }

    public Patient(String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress, String pesel) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress, pesel);

        patientList.add(this);
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
