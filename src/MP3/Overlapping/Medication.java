package MP3.Overlapping;

import java.util.EnumSet;
import java.util.Objects;

public class Medication{
    private String activeIngredient;
    private int clinicalStockQuantity;
    private String prescribedDosageFrequency;

    private EnumSet<MedicationType> medicationType = EnumSet.of(MedicationType.MEDICATION);

    public Medication(String activeIngredient){
        this.activeIngredient = activeIngredient;
    }

    public Medication(String activeIngredient, String prescribedDosageFrequency){
        this.activeIngredient = activeIngredient;
        this.prescribedDosageFrequency = prescribedDosageFrequency;

        this.medicationType.add(MedicationType.PRESCRIBED);
    }

    public Medication(String activeIngredient, int clinicalStockQuantity){
        this.activeIngredient = activeIngredient;
        this.clinicalStockQuantity = clinicalStockQuantity;

        this.medicationType.add(MedicationType.CLINICAL);
    }

    public Medication(String activeIngredient, int clinicalStockQuantity, String prescribedDosageFrequency){
        this.activeIngredient = activeIngredient;
        this.clinicalStockQuantity = clinicalStockQuantity;
        this.prescribedDosageFrequency = prescribedDosageFrequency;

        this.medicationType.add(MedicationType.PRESCRIBED);
        this.medicationType.add(MedicationType.CLINICAL);
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    public int getClinicalStockQuantity() {
        if(!medicationType.contains(MedicationType.CLINICAL)){
            throw new IllegalStateException("This is not a clinical medication");
        }
        return clinicalStockQuantity;
    }

    public void setClinicalStockQuantity(int clinicalStockQuantity) {
        this.clinicalStockQuantity = clinicalStockQuantity;
        this.medicationType.add(MedicationType.CLINICAL);
    }

    public String getPrescribedDosageFrequency() {
        if(!medicationType.contains(MedicationType.PRESCRIBED)){
            throw new IllegalStateException("This is not a prescribed medication");
        }
        return prescribedDosageFrequency;
    }

    public void setPrescribedDosageFrequency(String prescribedDosageFrequency) {
        this.prescribedDosageFrequency = prescribedDosageFrequency;
        this.medicationType.add(MedicationType.PRESCRIBED);
    }

    public boolean isPrescribed(){
        return medicationType.contains(MedicationType.PRESCRIBED);
    }

    public boolean isClinical(){
        return medicationType.contains(MedicationType.CLINICAL);
    }
}
