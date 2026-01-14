package app;

public class Lieu {
    private int nRue ;
    private String nomRue;
    private String ville ;
    private int codePostal ;

    public Lieu(int rue, String nomRue, String ville, int CP) {
        this.nRue = rue;
        this.ville = ville;
        this.codePostal =  CP;
    }

    public int getnRue() {
        return nRue;
    }
    
    

    public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
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

    public void modifierLieu(int numeroRue, String nomRue, String ville, int codePostal) {
        this.nRue = numeroRue;
        this.nomRue = nomRue;
        this.ville = ville;
        this.codePostal = codePostal;
    }
}