import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Doctor extends Person{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Doctor> doctorList = new ArrayList<>();

    private String licenseNumber;
    private BigDecimal salary;

    private Department department;
    private ArrayList<Appointment> appointmentList = new ArrayList<>();

    static{ loadDoctor(); }

    public Doctor(String licenseNumber, BigDecimal salary, String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress, String pesel) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress, pesel);
        Validation.validateString(licenseNumber, "licenseNumber cannot be null or empty");
        Validation.validateBigDecimal(salary, "salary cannot be null or negative");

        this.licenseNumber = licenseNumber;
        this.salary = salary;

        doctorList.add(this);
    }

    public List<Appointment> getAppointments(){
        return Collections.unmodifiableList(appointmentList);
    }

    public void addAppointment(Appointment newAppointment) {
        if (this.appointmentList.contains(newAppointment)) return;
        Objects.requireNonNull(newAppointment, "Appointment cannot be null");

        this.appointmentList.add(newAppointment);
        newAppointment.setDoctor(this);
    }

    public void removeAppointment(Appointment appointment){
        Objects.requireNonNull(appointment, "Appointment cannot be null");
        if (!this.appointmentList.contains(appointment)) return;

        this.appointmentList.remove(appointment);
        appointment.delete();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department newDepartment) {
        if (this.department == newDepartment) return;

        if (this.department != null) {
            Department oldDepartment = this.department;
            this.department = null;
            oldDepartment.removeDoctor(this);
        }

        this.department = newDepartment;

        if (this.department != null) {
            this.department.addDoctor(this);
        }
    }

    public void removeDepartment(Department department) {
        Objects.requireNonNull(department, "Department cannot be null");
        if (this.department != department) return;

        this.department = null;

        department.removeDoctor(this);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        Validation.validateString(licenseNumber, "licenseNumber cannot be null or empty");
        this.licenseNumber = licenseNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        Validation.validateBigDecimal(salary, "salary cannot be null or negative");
        this.salary = salary;
    }

    // extent methods
    public static void loadDoctor(){
        doctorList = Extent.loadClassList(FILE_NAME);
    }

    public static void saveDoctor(){
        Extent.saveClassList(FILE_NAME, doctorList);
    }

    public static List<Doctor> getDoctorList(){
        return Extent.getImmutableClassList(doctorList);
    }


    public void delete(){
        List<Appointment> appointmentsToDelete = new ArrayList<>(this.appointmentList);
        for (Appointment appointment : appointmentsToDelete) {
            appointment.delete();
        }
        if (this.department != null) this.setDepartment(null);

        doctorList.remove(this);
    }
}
