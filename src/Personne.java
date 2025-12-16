public abstract class Personne implements Utilisateur{
    protected String cni;
    protected String nom;
    protected String prenom;
    protected Role role;
    protected String adresse;
    protected int telephone;

    Personne(String cni, String nom, String prenom, Role role, String adresse, int telephone){
        this.cni = cni;
        this.nom = nom;
        this.role = role;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public String getCni() {
        return cni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    @Override
    public abstract void update();
}
