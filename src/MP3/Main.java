package MP3;

public class Main {
    public static void main(String[] args) {
        // Testing polymorphic method
        Person doctor1 = new Doctor(0.85f);
        Person patient1 = new Patient(0.80f);
        System.out.println(doctor1.calculateFinalBill(1200f));
        System.out.println(patient1.calculateFinalBill(1200f));
    }
}
