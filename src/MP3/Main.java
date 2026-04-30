package MP3;

import MP3.Abstract.Doctor;
import MP3.Abstract.Patient;
import MP3.Abstract.Person;

public class Main {
    public static void main(String[] args) {
        // Testing polymorphic method
        Person doctor1 = new Doctor(0.85f, "Doctor 1");
        Person patient1 = new Patient(0.80f, "Patient 1");
        System.out.println(doctor1.calculateFinalBill(1200f));
        System.out.println(patient1.calculateFinalBill(1200f));
    }
}
