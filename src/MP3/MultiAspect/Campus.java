package MP3.MultiAspect;

public class Campus extends Hospital {
    private int numberOfBuildings;
    private float totalLandArea;

    public Campus(int numberOfBuildings, float totalLandArea, String name) {
        super(name);
        this.numberOfBuildings = numberOfBuildings;
        this.totalLandArea = totalLandArea;
    }

    public Campus(int numberOfBuildings, float totalLandArea, String name, float researchBudget) {
        super(name, researchBudget);
        this.numberOfBuildings = numberOfBuildings;
        this.totalLandArea = totalLandArea;
    }

    public Campus(int numberOfBuildings, float totalLandArea, String name, int outpatientDailyCapacity) {
        super(name, outpatientDailyCapacity);
        this.numberOfBuildings = numberOfBuildings;
        this.totalLandArea = totalLandArea;
    }

    public int getNumberOfBuildings() {
        return numberOfBuildings;
    }
    public void setNumberOfBuildings(int numberOfBuildings) {
        this.numberOfBuildings = numberOfBuildings;
    }

    public float getTotalLandArea() {
        return totalLandArea;
    }

    public void setTotalLandArea(float totalLandArea) {
        this.totalLandArea = totalLandArea;
    }

    public float calculateMaintenanceCost(){
        return (120 * numberOfBuildings) + (25 *  totalLandArea);
    }
}
