import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Appointment implements Extent{
    private static final String FILE_NAME = "DateFile.ser";
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    private LocalDate appointmentDate;

    private Patient patient;
    private Doctor doctor;

    static { loadAppointment(); }

    public Appointment(LocalDate appointmentDate, Patient patient, Doctor doctor) {
        Objects.requireNonNull(appointmentDate, "Appointment date cannot be null.");
        Objects.requireNonNull(patient, "Patient cannot be null.");
        Objects.requireNonNull(doctor, "Doctor cannot be null.");

        this.appointmentDate = appointmentDate;
        this.patient = patient;
        this.patient.addAppointment(this);
        this.doctor = doctor;
        this.doctor.addAppointment(this);

        if (appointmentList.contains(this)) return;
        appointmentList.add(this);
    }

    public Patient getPatient(){
        return patient;
    }

    public void setPatient(Patient patient){
        Objects.requireNonNull(patient, "Patient cannot be null.");
        if (appointmentList.contains(this)) return;

        if (this.patient != null){
            Patient oldPatient = this.patient;
            this.patient = null;
            oldPatient.removeAppointment(this);
        }
        this.patient = patient;
        this.patient.addAppointment(this);
    }

    public Doctor getDoctor(){
        return doctor;
    }

    public void setDoctor(Doctor doctor){
        Objects.requireNonNull(doctor, "Doctor cannot be null.");
        if(this.doctor == doctor) return;

        if (this.doctor != null){
            Doctor oldDoctor = this.doctor;
            this.doctor = null;
            oldDoctor.removeAppointment(this);
        }
        this.doctor = doctor;
        this.doctor.addAppointment(this);
    }

    public void delete(){
        if (this.patient != null){
            Patient oldPatient = this.patient;
            this.patient = null;
            oldPatient.removeAppointment(this);
        }
        if(this.doctor != null){
            Doctor oldDoctor = this.doctor;
            this.doctor = null;
            oldDoctor.removeAppointment(this);
        }
        appointmentList.remove(this);
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        Objects.requireNonNull(appointmentDate, "Appointment date cannot be null.");
        this.appointmentDate = appointmentDate;
    }

    //extent methods
    public static void loadAppointment(){
        appointmentList = Extent.loadClassList(FILE_NAME);
    }

    public static void saveAppointment(){
        Extent.saveClassList(FILE_NAME, appointmentList);
    }

    public static List<Appointment> getAppointmentList(){
        return Extent.getImmutableClassList(appointmentList);
    }
}
