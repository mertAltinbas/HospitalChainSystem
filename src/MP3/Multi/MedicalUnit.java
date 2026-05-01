package MP3.Multi;

import java.util.List;

public class MedicalUnit {
    private List<String> medicalSupplies;

    public MedicalUnit(List<String> medicalSupplies) {
        this.medicalSupplies = medicalSupplies;
    }

    public List<String> getMedicalSupplies() {
        return medicalSupplies;
    }

    public void setMedicalSupplies(List<String> medicalSupplies) {
        this.medicalSupplies = medicalSupplies;
    }

    public void treatPatient(String name){
        System.out.println("Medical unit is treating to " + name);
    }
}
