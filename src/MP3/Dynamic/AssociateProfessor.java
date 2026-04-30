package MP3.Dynamic;

public class AssociateProfessor extends Rank{
    private String researchArea;

    public AssociateProfessor(float baseConsultationFee, String name, String researchArea) {
        super(baseConsultationFee, name);
        this.researchArea = researchArea;
    }

    public AssociateProfessor(Rank prevRank, String researchArea) {
        super(prevRank.getBaseConsultationFee(),  prevRank.getName());
        this.researchArea = researchArea;
    }

    public String getResearchArea() {
        return researchArea;
    }

    public void setResearchArea(String researchArea) {
        if (researchArea == null) return;
        this.researchArea = researchArea;
    }
}
