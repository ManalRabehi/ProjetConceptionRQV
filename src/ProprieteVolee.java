public abstract class ProprieteVolee {
    private String couleur;
    private String marque;
    private String description;


    public ProprieteVolee(String couleur, String marque, String description) {
        super();
        this.couleur = couleur;
        this.marque = marque;
        this.description = description;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
