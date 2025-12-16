import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class Temoin extends Personne{
    public Temoin(String cni, String nom, String prenom, Role role, String adresse, int telephone){
        super(cni, nom, prenom, role, adresse, telephone);
    }

    public DeclarationDeVol declarerVol(ProprieteVolee propriete,
                                        LocalDate dateVol,
                                        LocalTime heureVol,
                                        Lieu lieu,
                                        Date dateDerniereModification,
                                        Etat etat){
        return new DeclarationDeVol(propriete,
                dateVol,
                heureVol,
                lieu,
                dateDerniereModification,
                etat);
    }

    @Override
    public void update(){
        System.out.println("Nptification envoyée au témoin : " + nom + " " + prenom);
    }

}
