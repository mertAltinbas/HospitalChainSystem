import java.util.ArrayList;
import java.util.List;

public class Department implements Extent{
    private static final String FILE_NAME = "DateFile.ser";
    private static ArrayList<Department> departmentList = new ArrayList<>();

    private String departmentName;

    static { loadDepartment(); }

    public Department(String departmentName){
        Validation.validateString(departmentName, "departmentName cannot be null or empty");
        this.departmentName = departmentName;
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
