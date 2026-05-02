package MP3;

import MP3.Abstract.Doctor;
import MP3.Abstract.Patient;
import MP3.Abstract.Person;
import MP3.Dynamic.AssociateProfessor;
import MP3.Dynamic.Professor;
import MP3.Dynamic.Rank;
import MP3.Multi.Ambulance;
import MP3.MultiAspect.Campus;
import MP3.MultiAspect.Monoblock;
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

        // ------------------------------------------------------------------------------------------------------
        System.out.println("--- Testing Dynamic ---");

        Rank rank = new AssociateProfessor(1700.0f, "Bob", "dynamic inheritance");
        System.out.println(rank);

        rank = new Professor(rank, 45);
        System.out.println(rank);

        // ------------------------------------------------------------------------------------------------------
        System.out.println("--- Testing Multi-Inheritance ---");

        List<String> supplies = Arrays.asList("Oxygen Tank", "First Aid");
        Ambulance ambulance = new Ambulance("serial123", "plate123", supplies);
        System.out.println(ambulance);
        System.out.println("List of medical supplies from ambulance: " + ambulance.getMedicalSupplies());
        ambulance.emergencyResponse("Address 123", "Bob");

        // ------------------------------------------------------------------------------------------------------
        System.out.println("--- Testing Multi-aspect Inheritance ---");

        Campus campusTraining = new Campus(15, 50000.0f, "Campus - Training Hospital", 1500000.0f);
        System.out.println("Hospital Name: " + campusTraining.getName());
        System.out.println("Number of Buildings: " + campusTraining.getNumberOfBuildings());
        System.out.println("Hospital Type: " + campusTraining.getType());
        System.out.println("Research Budget: " + campusTraining.getResearchBudget() + "$");
        System.out.println("Campus Maintenance Cost: " + campusTraining.calculateMaintenanceCost() + "$\n");

        Monoblock monoblockGeneral = new Monoblock("Warsaw City Hospital", 2500, 12, true);
        System.out.println("Hospital Name: " + monoblockGeneral.getName());
        System.out.println("Floors Count: " + monoblockGeneral.getFloorsCount());
        System.out.println("Does have Helipad?: " + (monoblockGeneral.isHelipadOnRoof() ? "Yes" : "No"));
        System.out.println("Hospital Type: " + monoblockGeneral.getType());
        System.out.println("Daily Outpatient Capacity: " + monoblockGeneral.getOutpatientDailyCapacity() + " people");

        try {
            campusTraining.getOutpatientDailyCapacity();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            monoblockGeneral.setResearchBudget(500000.0f);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
