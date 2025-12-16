import java.util.Date;
import java.util.List;

public class AgentPolicier extends Personne {
    private String login ;
    private String mdp ;

    public AgentPolicier(String CNI, String nom, String prenom, String adresse, int telephone, String login, String mdp) {
        super(CNI,nom, prenom, Role.AgentPolicier, adresse, telephone);
        this.login = login;
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public RQV creerRQV(Date date) {
        List<DeclarationDeVol> declarations = DeclarationDeVol.rechercherDeclarations(new java.sql.Date(date.getTime()));

        RQV rqv = new RQV(new java.sql.Date(date.getTime()));

        for (DeclarationDeVol d : declarations) {
            switch (d.getEtat()) {
                case Etat.Nouvelle:
                    rqv.ajouterNewDeclaration(d);
                case Etat.MiseAJour:
                    rqv.ajouterDeclarationMAJ(d);
                case Etat.Résolue:
                    rqv.ajouterDeclarationResolues(d);
            }
        }
        return rqv;

    }

    public void modifierEtatDeclaration(DeclarationDeVol d, Etat etat) {
        d.changerEtat(etat);
        d.modifier();

    }

    public boolean authentifier(String login, String mdp) {
        return this.login.equals(login) && this.mdp.equals(mdp);

    }

    @Override
    public void update() {

    }
}
