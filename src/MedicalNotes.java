import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MedicalNotes implements Extent{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<MedicalNotes> medicalNotesList = new ArrayList<>();

    private String description;

    private Patient patient;

    static { loadMedicalNotes(); }

    public MedicalNotes(String description, Patient patient) {
        Validation.validateString(description, "Medical Notes Description");
        Objects.requireNonNull(patient, "Patient cannot be null");
        this.description = description;

        this.patient = patient;
        this.patient.addMedicalNotes(this);

        if (medicalNotesList.contains(this)) return;
        medicalNotesList.add(this);
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        Objects.requireNonNull(patient, "Patient cannot be null");
        if(this.patient == patient) return;

        if (this.patient != null) {
            Patient oldPatient = this.patient;
            this.patient = null;
            oldPatient.removeMedicalNotes(this);
        }
        this.patient = patient;
        this.patient.addMedicalNotes(this);
    }

    public void delete(){
        if (this.patient != null) {
            Patient oldPatient = this.patient;
            this.patient = null;
            oldPatient.removeMedicalNotes(this);
        }
        this.medicalNotesList.remove(this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        Validation.validateString(description, "Medical Notes Description setter");
        this.description = description;
    }


    // extent methods
    public static void loadMedicalNotes(){
        medicalNotesList = Extent.loadClassList(FILE_NAME);
    }

    public static void saveMedicalNotes(){
        Extent.saveClassList(FILE_NAME, medicalNotesList);
    }

    public static List<MedicalNotes> getMedicalNotes(){
        return Extent.getImmutableClassList(medicalNotesList);
    }
}
