package MP3.MultiAspect;

public class Hospital {
    public enum HospitalType { TRAINING_RESEARCH, GENERAL }

    private String name;

    private HospitalType type;
    private float researchBudget; // training & research attr
    private int outpatientDailyCapacity; // general attr

    public Hospital(String name){
        this.name = name;
    }

    public Hospital(String name, float researchBudget){
        this.name = name;
        this.researchBudget = researchBudget;
        this.type =  HospitalType.TRAINING_RESEARCH;
    }

    public Hospital(String name, int outpatientDailyCapacity){
        this.name = name;
        this.outpatientDailyCapacity = outpatientDailyCapacity;
        this.type =  HospitalType.GENERAL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HospitalType getType() {
        return type;
    }

    public float getResearchBudget() {
        if(type != HospitalType.TRAINING_RESEARCH) throw new IllegalArgumentException("This is not a Training Research Hospital");
        return researchBudget;
    }

    public void setResearchBudget(float researchBudget) {
        if (type != HospitalType.TRAINING_RESEARCH) throw new IllegalArgumentException("This is not a Training Research Hospital");
        this.researchBudget = researchBudget;
    }

    public int getOutpatientDailyCapacity() {
        if (type != HospitalType.GENERAL) throw new IllegalArgumentException("This is not a General Hospital");
        return outpatientDailyCapacity;
    }

    public void setOutpatientDailyCapacity(int outpatientDailyCapacity) {
        if (type != HospitalType.GENERAL) throw new IllegalArgumentException("This is not a General Hospital");
        this.outpatientDailyCapacity = outpatientDailyCapacity;
    }
}
