import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Appointment implements Extent{
    private static final String FILE_NAME = "DateFile.ser";
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    private LocalDate appointmentDate;

    static { loadAppointment(); }

    public Appointment(LocalDate appointmentDate){
        Objects.requireNonNull(appointmentDate, "Appointment date cannot be null.");
        this.appointmentDate = appointmentDate;
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
