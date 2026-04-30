package MP3.Dynamic;

public abstract class Rank {
    private float baseConsultationFee;
    private String name;

    public Rank(float baseConsultationFee, String name) {
        this.baseConsultationFee = baseConsultationFee;
        this.name = name;
    }

    public float getBaseConsultationFee() {
        return baseConsultationFee;
    }

    public void setBaseConsultationFee(float baseConsultationFee) {
        this.baseConsultationFee = baseConsultationFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class Name: " + this.getClass().getSimpleName();
    }
}
