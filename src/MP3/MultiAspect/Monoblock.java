package MP3.MultiAspect;

public class Monoblock extends Hospital {
    private int floorsCount;
    private boolean helipadOnRoof;

    public Monoblock(String name, int floorsCount, boolean helipadOnRoof) {
        super(name);
        this.floorsCount = floorsCount;
        this.helipadOnRoof = helipadOnRoof;
    }

    public Monoblock(String name, float researchBudget, int floorsCount, boolean helipadOnRoof) {
        super(name, researchBudget);
        this.floorsCount = floorsCount;
        this.helipadOnRoof = helipadOnRoof;
    }

    public Monoblock(String name, int outpatientDailyCapacity, int floorsCount, boolean helipadOnRoof) {
        super(name, outpatientDailyCapacity);
        this.floorsCount = floorsCount;
        this.helipadOnRoof = helipadOnRoof;
    }

    public int getFloorsCount() {
        return floorsCount;
    }

    public void setFloorsCount(int floorsCount) {
        this.floorsCount = floorsCount;
    }

    public boolean isHelipadOnRoof() {
        return helipadOnRoof;
    }

    public void setHelipadOnRoof(boolean helipadOnRoof) {
        this.helipadOnRoof = helipadOnRoof;
    }
}
