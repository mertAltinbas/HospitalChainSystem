package MP3;

public class Patient extends Person {
    private float insuranceRate;

    public Patient(float insuranceRate, String name) {
        super(name);
        this.insuranceRate = insuranceRate;
    }

    public float getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(float insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    @Override
    public float calculateFinalBill(float rawFee) {
        return  rawFee * (1 - insuranceRate);
    }
}
