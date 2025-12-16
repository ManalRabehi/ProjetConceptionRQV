import java.util.Date;
import java.util.List;

public class AgentPolicier extends Personne {
    private String login ;
    private String mdp ;

    public AgentPolicier(String CNI, String nom, String prenom, String adresse, int telephone, String login, String mdp) {
        super(CNI,nom, prenom, adresse, telephone);
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
                case "nouvelle" :
                    rqv.ajouterNewDeclaration(d);
                case "mise à jour" :
                    rqv.ajouterDeclarationMAJ(d);
                case "résolue":
                    rqv.ajouterDeclarationResolues(d);
            }
        }
        return rqv;

    }

    public void modifierEtatDeclaration(DeclarationDeVol d, String etat) {
        d.changerEtat(etat);
        d.modifier();

    }

    public boolean authentifier(String login, String mdp) {
        return this.login.equals(login) && this.mdp.equals(mdp);

    }
}
