import java.util.ArrayList;
import java.util.List;

public class ObjetTrouve {
    private ProprieteVolee type;
    private List<Utilisateur> observateurs = new ArrayList<>();

    public void attach(Utilisateur u) {
        observateurs.add(u);
    }

    public void detach(Utilisateur u) {
        observateurs.remove(u);
    }

    public void notify(String message) {
        for(Utilisateur u : observateurs) {
            u.update(message);
        }
    }

    public ProprieteVolee getType() {
        return type;
    }

    public void setType(ProprieteVolee type) {
        this.type = type;
    }

    public List<Utilisateur> getUtilisateurs() {
        return observateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.observateurs = utilisateurs;
    }
}
