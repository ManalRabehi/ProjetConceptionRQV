public class Lieu {
    private int nRue ;
    private String ville ;
    private int codePostal ;

    public Lieu(int rue, String ville, int CP) {
        this.nRue = rue;
        this.ville = ville;
        this.codePostal =  CP;
    }

    public int getnRue() {
        return nRue;
    }

    public String getVille() {
        return ville;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setnRue(int nRue) {
        this.nRue = nRue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void modifierLieu(int numeroRue, String ville, int codePostal) {
        this.nRue = numeroRue;
        this.ville = ville;
        this.codePostal = codePostal;
    }
}
