package app;

public class VehiculeSansMoteur extends ProprieteVolee {
    private String numDeSerie;

    public VehiculeSansMoteur(String couleur, String marque, String description, String numDeSerie) {
        super(couleur, marque, description);
        this.numDeSerie = numDeSerie;
    }

    public String getNumDeSerie() {
        return numDeSerie;
    }

    public void setNumDeSerie(String numDeSerie) {
        this.numDeSerie = numDeSerie;
    }



}