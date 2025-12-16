import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class DeclarationDeVol {
    private int id;
    private ProprieteVolee propriete;
    private LocalDate dateVol;
    private LocalTime heureVol;
    private Lieu lieu;
    private Date dateDerniereModification;
    private Etat etat;
    private static List<DeclarationDeVol> declarations = new ArrayList<>();
    private static int cptId = 1;

    public DeclarationDeVol(ProprieteVolee propriete, Date dateVol, Time heureVol, Lieu lieu) {
        this.id = cptId++;
        this.propriete = propriete;
        this.dateVol = dateVol.toLocalDate();
        this.heureVol = heureVol.toLocalTime();
        this.lieu = lieu;
        this.dateDerniereModification = new Date(System.currentTimeMillis());
        this.etat = Nouvelle; 

    }

    public void modifier() {
        this.etat = MiseAJour;
        this.dateDerniereModification = new Date(System.currentTimeMillis()); 

    }

    public void modifierLieu(int numeroRue, String ville, int codePostal) {
        this.lieu.modifierLieu(numeroRue, ville, codePostal);
        modifier();
    }

    public void changerEtat(Etat nouvelEtat) {
        this.etat = nouvelEtat;
        this.dateDerniereModification = new Date(System.currentTimeMillis());
    }


    public void supprimer() {
        declarations.remove(this); 

    }

    public void sauvegarder() {
        if (!declarations.contains(this)) {
            declarations.add(this); 
        }

    }

    public static List<DeclarationDeVol> rechercherDeclarations(Date date) {
        List<DeclarationDeVol> resultat = new ArrayList<>();

        for (DeclarationDeVol d : declarations) {
            if (d.dateDerniereModification.toLocalDate().equals(date.toLocalDate())) {
                resultat.add(d);
            }

        }
        return resultat;
    }

    public int getId() {
        return id;
    }

    public Date getDateDerniereModification() {
        return dateDerniereModification;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public String getEtat() {
        return etat;
    }
}
