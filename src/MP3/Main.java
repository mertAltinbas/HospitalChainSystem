package MP3;

import MP3.Abstract.Doctor;
import MP3.Abstract.Patient;
import MP3.Abstract.Person;
import MP3.Overlapping.Medication;

public class Main {
    public static void main(String[] args) {
        // Testing polymorphic method
        Person doctor1 = new Doctor(0.85f, "Doctor 1");
        Person patient1 = new Patient(0.80f, "Patient 1");
        System.out.println(doctor1.calculateFinalBill(1200f));
        System.out.println(patient1.calculateFinalBill(1200f));

        // Testing overlapping
        Medication prescribed = new Medication("Prescribed", "Every 8 hour");
        Medication clinical = new Medication("Clinical", 123);
        Medication overlappingMedication = new Medication("Overlapping", 222, "Every 12 hour");

        if (overlappingMedication.isClinical()) System.out.println("Dosage: " + overlappingMedication.getPrescribedDosageFrequency());
        if (overlappingMedication.isPrescribed()) System.out.println("Stock: " + overlappingMedication.getClinicalStockQuantity());
    }
}
