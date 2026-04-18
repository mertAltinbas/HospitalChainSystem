import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Doctor> doctorList = new ArrayList<>();

    private String licenseNumber;
    private BigDecimal salary;

    private Department department;

    static{ loadDoctor(); }

    public Doctor(String licenseNumber, BigDecimal salary, String name, String middleName, String surname, LocalDate dateOfBirth, String gender, Address homeAddress, String pesel) {
        super(name, middleName, surname, dateOfBirth, gender, homeAddress, pesel);
        Validation.validateString(licenseNumber, "licenseNumber cannot be null or empty");
        Validation.validateBigDecimal(salary, "salary cannot be null or negative");

        this.licenseNumber = licenseNumber;
        this.salary = salary;

        if (!doctorList.contains(this)) doctorList.add(this);
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
}
