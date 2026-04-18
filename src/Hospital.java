import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hospital implements Extent{
    private static final String FILE_NAME = "DataFile.ser";
    private static ArrayList<Hospital> hospitalList = new ArrayList<>();

    private Address hospitalAddress;

    static { loadHospital(); }

    public Hospital(Address hospitalAddress){
        this.hospitalAddress = hospitalAddress;
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
