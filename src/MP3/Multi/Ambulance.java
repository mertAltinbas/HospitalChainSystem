package MP3.Multi;

import java.util.List;

public class Ambulance extends MedicalUnit implements Vehicle {
    private String serialNumber;

    // vehicle class attribute
    private String plateNumber;

    public Ambulance(String serialNumber, String plateNumber, List<String> medicalSupplies) {
        super(medicalSupplies);
        this.serialNumber = serialNumber;
        this.plateNumber = plateNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void emergencyResponse(String destination, String patientName){
        System.out.println(drive(destination));
        treatPatient(patientName);
    }

    @Override
    public String drive(String destination) {
        return "Driving to " + destination;
    }

    @Override
    public String toString() {
        return "Ambulance{" +
                "serialNumber='" + serialNumber + '\'' +
                ", plateNumber='" + plateNumber + '\'' +
                '}';
    }
}
