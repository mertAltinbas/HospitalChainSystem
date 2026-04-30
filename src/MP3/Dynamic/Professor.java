package MP3.Dynamic;

public class Professor extends Rank {
    private int publicationCount;

    public Professor(float baseConsultationFee, String name, int publicationCount) {
        super(baseConsultationFee, name);
        this.publicationCount = publicationCount;
    }

    public Professor(Rank prevRank, int publicationCount) {
        super(prevRank.getBaseConsultationFee(),  prevRank.getName());
        this.publicationCount = publicationCount;
    }

    public int getPublicationCount() {
        return publicationCount;
    }

    public void setPublicationCount(int publicationCount) {
        if (publicationCount < 0) return;
        this.publicationCount = publicationCount;
    }
}
