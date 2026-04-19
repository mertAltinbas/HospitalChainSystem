import java.util.*;

public class Hospital implements Extent{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Hospital> hospitalList = new ArrayList<>();

    private Address hospitalAddress;

    private HashMap<String, Department> departmentMap = new HashMap<>();

    static { loadHospital(); }

    public Hospital(Address hospitalAddress){
        this.hospitalAddress = hospitalAddress;

        if (hospitalList.contains(this)) return;
        hospitalList.add(this);
    }

    public Department getDepartmentQualifier(String departmentName){
        return departmentMap.get(departmentName);
    }

    public Map<String, Department> getDepartmentList(){
        return Collections.unmodifiableMap(departmentMap);
    }

    public void addDepartment(Department department){
        String key = department.getDepartmentName();
        Objects.requireNonNull(department, "Department cannot be null");
        Objects.requireNonNull(key, "Department name (key) cannot be null");

        if (departmentMap.containsKey(key) && this.departmentMap.get(key) == department) return;

        departmentMap.put(key, department);
        department.addHospital(this);
    }

    public void removeDepartment(Department department){
        String key = department.getDepartmentName();
        Objects.requireNonNull(department, "Department cannot be null");
        Objects.requireNonNull(key, "Department name (key) cannot be null");
        if (!departmentMap.containsKey(key) || this.departmentMap.get(key) != department) return;

        departmentMap.remove(key);
        department.removeHospital(this);
    }

    public void delete(){
        HashMap<String, Department> departmentMapToNull = new HashMap<>(this.departmentMap);
        for (Map.Entry<String, Department> entry : departmentMapToNull.entrySet()) {
            Department department = entry.getValue();
            department.removeHospital(this);
        }
        hospitalList.remove(this);
    }

    public Address getAddress(){
        return this.hospitalAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.hospitalAddress = Objects.requireNonNull(homeAddress, "homeAddress cannot be null");
    }

    //extent methods
    public static void loadHospital(){
        hospitalList = Extent.loadClassList(FILE_NAME);
    }

    public static void saveHospital(){
        Extent.saveClassList(FILE_NAME, hospitalList);
    }

    public static List<Hospital> getHospitalList(){
        return Extent.getImmutableClassList(hospitalList);
    }
}
