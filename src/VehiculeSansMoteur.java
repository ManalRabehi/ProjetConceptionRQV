
public class VehiculeSansMoteur extends ProprieteVolee {
    private int numDeSerie;

    public VehiculeSansMoteur(String couleur, String marque, String description, int numDeSeine) {
        super(couleur, marque, description);
        this.numDeSerie = numDeSeine;
    }

    public int getNumDeSerie() {
        return numDeSerie;
    }

    public void setNumDeSerie(int numDeSeine) {
        this.numDeSerie = numDeSeine;
    }



}
