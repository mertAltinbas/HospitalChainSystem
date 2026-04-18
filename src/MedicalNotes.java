import java.util.ArrayList;
import java.util.List;

public class MedicalNotes implements Extent{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<MedicalNotes> medicalNotesList = new ArrayList<>();

    private String description;

    static { loadMedicalNotes(); }

    public MedicalNotes(String description){
        Validation.validateString(description, "Medical Notes Description");
        this.description = description;

        if (medicalNotesList.contains(this)) return;
        medicalNotesList.add(this);
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
