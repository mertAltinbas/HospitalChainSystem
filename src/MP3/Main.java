package MP3;

import MP3.Abstract.Doctor;
import MP3.Abstract.Patient;
import MP3.Abstract.Person;
import MP3.Dynamic.AssociateProfessor;
import MP3.Dynamic.Professor;
import MP3.Dynamic.Rank;
import MP3.Multi.Ambulance;
import MP3.Overlapping.Medication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing polymorphic method ---");
        Person doctor1 = new Doctor(0.85f, "Doctor 1");
        Person patient1 = new Patient(0.80f, "Patient 1");
        System.out.println(doctor1.calculateFinalBill(1200f));
        System.out.println(patient1.calculateFinalBill(1200f));

        System.out.println("--- Testing Overlapping ---");
        Medication prescribed = new Medication("Prescribed", "Every 8 hour");
        Medication clinical = new Medication("Clinical", 123);
        Medication overlappingMedication = new Medication("Overlapping", 222, "Every 12 hour");

        if (overlappingMedication.isClinical()) System.out.println("Dosage: " + overlappingMedication.getPrescribedDosageFrequency());
        if (overlappingMedication.isPrescribed()) System.out.println("Stock: " + overlappingMedication.getClinicalStockQuantity());

        System.out.println("--- Testing Dynamic ---");
        Rank rank = new AssociateProfessor(1700.0f, "Bob", "dynamic inheritance");
        System.out.println(rank);

        rank = new Professor(rank, 45);
        System.out.println(rank);

        System.out.println("--- Testing Multi-Inheritance ---");
        List<String> supplies = Arrays.asList("Oxygen Tank", "First Aid");
        Ambulance ambulance = new Ambulance("serial123", "plate123", supplies);
        System.out.println(ambulance);
        System.out.println("List of medical supplies from ambulance: " + ambulance.getMedicalSupplies());
        ambulance.emergencyResponse("Address 123", "Bob");
    }
}
