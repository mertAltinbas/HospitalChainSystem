package MP3.Abstract;

public class Doctor extends Person {
    private float employeeDiscount;

    public Doctor(float employeeDiscount, String name) {
        super(name);
        this.employeeDiscount = employeeDiscount;
    }

    public float getEmployeeDiscount() {
        return employeeDiscount;
    }

    public void setEmployeeDiscount(float employeeDiscount) {
        this.employeeDiscount = employeeDiscount;
    }

    @Override
    public float calculateFinalBill(float rawFee) {
        return rawFee - (rawFee * employeeDiscount);
    }
}
