import java.time.LocalDate;
import java.time.LocalTime;

public class Victime extends Personne{
    public Victime(String cni, String nom, String prenom, Role role, String adresse, int telephone){
        super(cni, nom, prenom, role, adresse, telephone);
    }

    public DeclarationDeVol declarerVol(ProprieteVolee propriete,
                                        LocalDate dateVol,
                                        LocalTime heureVol,
                                        Lieu lieu,
                                        String description){
        return new DeclarationDeVol(propriete,
                dateVol,
                heureVol,
                lieu);
    }

    @Override
    public void update(String message){
        System.out.println("Nptification envoyée à la victime : " + nom + " " + prenom);
    }

}
