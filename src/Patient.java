import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Patient extends Person {
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Patient> patientList = new ArrayList<>();

    private ArrayList<MedicalNotes> medicalNotesList = new ArrayList<>();

    static { loadPatient(); }

    public Patient(String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress, String pesel) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress, pesel);

        patientList.add(this);
    }

    public List<MedicalNotes> getMedicalNotesList() {
        return Collections.unmodifiableList(medicalNotesList);
    }

    public void addMedicalNotes(MedicalNotes newMedicalNotes) {
        if (this.medicalNotesList.contains(newMedicalNotes)) return;
        if (newMedicalNotes == null) return;

        this.medicalNotesList.add(newMedicalNotes);

        newMedicalNotes.setPatient(this);
    }

    public void removeMedicalNotes(MedicalNotes medicalNotes) {
        if (!this.medicalNotesList.contains(medicalNotes)) return;
        if (medicalNotes == null) return;

        this.medicalNotesList.remove(medicalNotes);

        medicalNotes.delete();
    }

    public void delete(){
        List<MedicalNotes> notesToDelete = new ArrayList<>(this.medicalNotesList);
        for (MedicalNotes notes : notesToDelete) {
            notes.delete();
        }
        patientList.remove(this);
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
