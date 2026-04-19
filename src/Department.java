import java.util.*;

public class Department implements Extent{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Department> departmentList = new ArrayList<>();

    private String departmentName;

    private HashSet<Doctor> doctorList = new HashSet<>();
    private HashSet<Hospital> hospitalList = new HashSet<>();

    static { loadDepartment(); }

    public Department(String departmentName) {
        Validation.validateString(departmentName, "departmentName cannot be null or empty");
        this.departmentName = departmentName;

        if (!departmentList.contains(this)) departmentList.add(this);
    }

    public Set<Hospital> getHospitalList() {
        return Collections.unmodifiableSet(hospitalList);
    }

    public void addHospital(Hospital hospital) {
        Objects.requireNonNull(hospital, "hospital cannot be null");
        if  (hospitalList.contains(hospital)) return;
        hospitalList.add(hospital);
        hospital.addDepartment(this);
    }

    public void removeHospital(Hospital hospital) {
        Objects.requireNonNull(hospital, "hospital cannot be null");
        if(!hospitalList.contains(hospital)) return;

        hospitalList.remove(hospital);
        hospital.removeDepartment(this);
    }

    public void delete() {
        HashSet<Hospital> hospitalsToUnlink = new HashSet<>(this.hospitalList);
        HashSet<Doctor> doctorsToUnlink = new HashSet<>(this.doctorList);
        for (Hospital hospital : hospitalsToUnlink) {
            hospital.removeDepartment(this);
        }
        for (Doctor doctor : doctorsToUnlink) {
            doctor.removeDepartment(this);
        }
        departmentList.remove(this);
    }

    public Set<Doctor> getDoctor(){
        return Collections.unmodifiableSet(doctorList);
    }

    public void addDoctor(Doctor doctor) {
        if (doctor == null) return;
        if (this.doctorList.contains(doctor)) return;

        this.doctorList.add(doctor);

        doctor.setDepartment(this);
    }

    public void removeDoctor(Doctor doctor) {
        if (doctor == null) return;
        if (!this.doctorList.contains(doctor)) return;

        this.doctorList.remove(doctor);

        doctor.setDepartment(null);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        Validation.validateString(departmentName, "departmentName cannot be null or empty");
        this.departmentName = departmentName;
    }

    //extent methods
    public static void loadDepartment(){
        departmentList = Extent.loadClassList(FILE_NAME);
    }

    public static void saveDepartment(){
        Extent.saveClassList(FILE_NAME, departmentList);
    }

    public static List<Department> loadDepartmentList(){
        return Extent.getImmutableClassList(departmentList);
    }
}
