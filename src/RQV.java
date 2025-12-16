import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class RQV {
    private Date date ;
    private List<DeclarationDeVol> newDeclarations ;
    private List<DeclarationDeVol> declarationsMAJ ;
    private List<DeclarationDeVol> declarationsResolue ;

    public RQV(Date date) {
        this.date = date ;
        this.newDeclarations = new ArrayList<>();
        this.declarationsMAJ = new ArrayList<>();
        this.declarationsResolue = new ArrayList<>();
    }

    public void ajouterNewDeclaration(DeclarationDeVol d) {
        this.newDeclarations.add(d);
    }

    public void ajouterDeclarationMAJ(DeclarationDeVol d) {
        this.declarationsMAJ.add(d);

    }

    public void ajouterDeclarationResolues(DeclarationDeVol d) {
        this.declarationsResolue.add(d);
    }



    public Date getDate() {
        return date;
    }
}
