public class VehiculeAMoteur extends ProprieteVolee{


    private String matricule;


    public VehiculeAMoteur(String couleur, String marque, String description, String matricule) {
        super(couleur, marque, description);
        this.matricule = matricule;
    }


    public String getMatricule() {
        return matricule;
    }


    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }





}


