package app;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestSysteme {

	public static void main(String[] args) {
		
		
		System.out.println("Systeme de gestion des declarations de vol");
		
		// ==========PARTIE 1: Creation des utilisateurs ================
		
		System.out.println("\n PARTIE 1 : Creation des utilisateurs");
		System.out.println();
		
		Victime victime = new Victime ("XA23789ED"," Rohaut","Cédric",Role.Victime,"5 avenue Léon Blum ", "0612345678");
		Victime victime2 = new Victime ("BA23789ED"," Charlie","Thomas",Role.Victime,"12 avenue jean jaures ", "0610334679");
		Victime victime3 = new Victime ("CA23789ED"," Blanchetot ","Julien",Role.Victime,"12 avenue saint Pierre ", "0610334999");
		System.out.println("3 victimes creees :"+ victime.getNom() + " " + victime.getPrenom()  + ", " + victime2.getNom() + " " + victime2.getPrenom() +", "+ victime3.getNom() + " " + victime3.getPrenom() );
        
		// Creation des temoins
       
		Temoin temoin1 = new Temoin("AB78FG901", "Martin", "Charlot", Role.Temoin, "83 av Saint Exupéry,", "0698765432");
		Temoin temoin2 = new Temoin("AV556G901", "Marie", "Lola", Role.Temoin, "84 av Saint Martin,", "0689065432");
		System.out.println("2 temoins crees : " + temoin1.getNom() + " " + temoin1.getPrenom()+", " + temoin2.getNom() + " " + temoin2.getPrenom() );
		
		// Creation de l'agent de police
        
        AgentPolicier agentP = new AgentPolicier("GP00FF1C3", "PIERRET", "Sophie", "9 avenue Jean Chaubet,", "0611223344",  "agentP123", "mdp123:");
        System.out.println("Agent de police cree :"+ agentP.getNom()+" " + agentP.getPrenom() );
		
        //=====Declaration de vol par victime =========== 
        
        System.out.println("\n PARTIE 2 : Declarations de vol par les victimes");
        System.out.println();
        
        // Declaration 1 : Cédric (trottinette Xiaomi noire)
        
        System.out.println("Declaration 1 : Cédric declare le vol de sa trottinette");
        VehiculeSansMoteur Trottinette = new VehiculeSansMoteur("Noir", "Xiaomi",  "Trotinette électrique", "ARF673");
        Lieu lieu = new Lieu(15,"avenue Minimes" ,"Toulouse", 31000);
        LocalDate dateVol = LocalDate.now();
        LocalTime heureVol = LocalTime.of(16, 30);
        
        //ID1
        DeclarationDeVol declaration1 = victime.declarerVol(Trottinette , dateVol, heureVol,  lieu,
        		                   "Ma trottinette était stationnée devant le lycée. Je suis sorti à 16h30 et elle avait disparu.");
        declaration1.sauvegarder();
        
        System.out.println("Déclaration créée par " + victime.getNom() + " " + victime.getPrenom());
        System.out.println("  + ID : " + declaration1.getId());
        System.out.println("  + Rôle :"+ Role.Victime);
        System.out.println("  + Objet : " + Trottinette.getCouleur() + " " + Trottinette.getMarque() + " (N°série: " + Trottinette.getNumDeSerie() + ")");
        System.out.println("  + Lieu : " + lieu.getnRue() + " " + lieu.getNomRue() + ", " + lieu.getVille()+ ", " + lieu.getCodePostal());
        System.out.println("  + Date : " + dateVol);
        System.out.println("  + Heure : " + heureVol);
        System.out.println();
        
        // Declaration 2 : Thomas (trottinette Xiaomi noire)
        
        System.out.println("Declaration 2 : Thomas declare le vol de sa trottinette");
        VehiculeSansMoteur trottinette2 = new VehiculeSansMoteur("Noir", "Xiaomi", "Trottinette électrique", "ZZ9999");
        //TD2
        DeclarationDeVol declaration2 = victime2.declarerVol(trottinette2,dateVol,LocalTime.of(15, 10), new Lieu(5, "rue Alsace", "Toulouse", 31000), "Ma trottinette rouge a disparu devant la gare.");
        declaration2.sauvegarder();
        
        System.out.println("Declaration creee par " + victime2.getNom() + " " + victime2.getPrenom());
        System.out.println("  + ID : " + declaration2.getId());
        System.out.println("  + Objet : " + trottinette2.getCouleur() + " " + trottinette2.getMarque());
        System.out.println();
        
     // Declaration 3 : Julien (trottinette HIKERBOY bleue)
        
        System.out.println("Declaration 3 : Julien declare le vol de sa trottinette");
        VehiculeSansMoteur trottinette3= new VehiculeSansMoteur("Bleu", "HIKERBOY", "Trottinette électrique", "ZZ9999");
        //ID3
        DeclarationDeVol declaration3  = victime3.declarerVol(trottinette3,dateVol,LocalTime.of(10, 10), new Lieu(5, "rue Allée Antoine Osete", "Toulouse", 31000), "Ma trottinette rouge a disparu devant l'hopital.");
        declaration3.sauvegarder();
        
        System.out.println("Declaration creee par " + victime3.getNom() + " " + victime3.getPrenom());
        System.out.println("  + ID : " + declaration3.getId());
        System.out.println("  + Objet : " + trottinette3.getCouleur() + " " + trottinette3.getMarque());
        System.out.println();
        
      ///========Declaration de vol par les temoins===========
        
        System.out.println("\n PARTIE 3 : Declarations de vol par les temoins");
        System.out.println();
        
     // Declaration par temoin 1 : Charlot (temoin du vol de la trottinette de Cédric)
        
        System.out.println("Declaration par temoin : Charlot a vu le vol de la trottinette");
        
        Lieu lieu2= new Lieu(17,"avenue Minimes" ,"Toulouse", 31000);  
        //ID4
        DeclarationDeVol declaration4 = temoin1.declarerVol(Trottinette, dateVol, LocalTime.of(16, 25),lieu2, 
        		                          new Date(System.currentTimeMillis()) ,Etat.Nouvelle);
        declaration4.sauvegarder();
        
        System.out.println("Déclaration créée par " + temoin1.getNom() + " " + temoin1.getPrenom());
        System.out.println("  + ID : " + declaration3.getId());
        System.out.println("  + Rôle : " + Role.Temoin);
        System.out.println("  + Objet : " + Trottinette.getCouleur() + " " + Trottinette.getMarque() + " (N°série: " + Trottinette.getNumDeSerie() + ")");
        System.out.println("  + Lieu : " + lieu2.getnRue() + " " + lieu2.getNomRue() + ", " + lieu2.getVille() + ", " + lieu2.getCodePostal());
        System.out.println("   Le témoin a vu le vol en cours à 16:25. ");
        
        
      // Declaration par temoin 2 : Lola (trottinette NIU rouge)
        System.out.println("Declaration par temoin : Lola a vu le vol d'un scooter rouge");
        VehiculeAMoteur scooter = new VehiculeAMoteur("Rouge","NIU", "Scooter électrique","BRF634");
        Lieu lieu3 = new Lieu(5, "avenue Saint Michel", "Toulouse", 31000);

        //ID5
        DeclarationDeVol declaration5 = temoin2.declarerVol( scooter, dateVol, LocalTime.of(16, 0), lieu3,new Date(System.currentTimeMillis()), Etat.Nouvelle);
        
        System.out.println("Declaration creee par " + temoin2.getNom() + " " + temoin2.getPrenom());
        System.out.println("  + ID : " + declaration5.getId());
        System.out.println("  + Rôle : " + Role.Temoin);
        System.out.println("  + Objet : " + scooter.getCouleur() + " " + scooter.getMarque() + " (Matricule: " + scooter.getMatricule() + ")");
        System.out.println("  + Lieu : " + lieu2.getnRue() + " " + lieu2.getNomRue() + ", " + lieu2.getVille() + ", " + lieu2.getCodePostal());
        System.out.println();
        
     // =========PARTIE 4 : Modifications des declarations ============
        
        System.out.println("PARTIE 4 : Modification des declarations");
        System.out.println();
        
        // Modification par la victime Cédric
        
        System.out.println("Modification de la declaration par Cédric (victime)");
        System.out.println("Cédric se souvient : c'était au numero 17, pas 15");
        
        System.out.println("+ État initial : " + declaration1.getEtat());
        System.out.println("+ Lieu initial : " + declaration1.getLieu().getnRue() + " " + 
                           declaration1.getLieu().getNomRue() + ", " + 
                           declaration1.getLieu().getVille()+"," + lieu2.getCodePostal());

        System.out.println("\n Cédric se souvient : c'était au numéro de rue 17, pas 15");

        declaration1.modifierLieu(17,"avenue Minimes", "Toulouse", 31000);
        declaration1.sauvegarder();  

        System.out.println(" + État après modification : " + declaration1.getEtat());
        System.out.println(" + Nouveau lieu : " + declaration1.getLieu().getnRue() + " " + 
                           declaration1.getLieu().getNomRue() + ", " + 
                           declaration1.getLieu().getVille() + "," + lieu2.getCodePostal());
        System.out.println(" + Date de modification : " + declaration1.getDateDerniereModification()) ;
        System.out.println();
        
        // Modification par le temoin Lola
        
        System.out.println("Modification de la declaration par Lola (temoin)");
        System.out.println("Lola se souvient : c'était Av. de Muret, pas av Saint Michel");
        System.out.println("+ État initial : " + declaration5.getEtat());
        System.out.println("+ Lieu initial : " + declaration5.getLieu().getnRue() + " " + 
                           declaration5.getLieu().getNomRue() + ", " + 
                           declaration5.getLieu().getVille()+"," + lieu3.getCodePostal());

        declaration5.modifierLieu(85,"Av. de Muret", "Toulouse", 31000);
        declaration5.sauvegarder();  
        System.out.println(" + État après modification : " + declaration5.getEtat());
        System.out.println(" + Nouveau lieu : " + declaration5.getLieu().getnRue() + " " + 
                           declaration5.getLieu().getNomRue() + ", " + 
                           declaration5.getLieu().getVille() + "," + lieu3.getCodePostal());
        System.out.println(" + Date de modification : " + declaration5.getDateDerniereModification()) ;
        
        // ==============PARTIE 5 : Objet trouver et notification (Pattern Observer) 
        
        System.out.println("\n PARTIE 5 : Objet trouve et notification des victimes");
        System.out.println();
        
        System.out.println("Une trottinette est retrouvee par la police");
        VehiculeSansMoteur trottinetteRetrouvee = new VehiculeSansMoteur("Noir", "Xiaomi", "Trottinette électrique", "ARF673");
        System.out.println("  Caracteristiques : " + trottinetteRetrouvee.getCouleur() + " " 
                + trottinetteRetrouvee.getMarque() + " (N° serie: " 
                + trottinetteRetrouvee.getNumDeSerie() + ")");
        System.out.println();
        
      // Creation de l'objet trouve et notification des victimes concernees
        
        ObjetTrouve objetTrouve = new ObjetTrouve();
        objetTrouve.setType(trottinetteRetrouvee);
        objetTrouve.attach(victime);
        objetTrouve.attach(victime2);
        objetTrouve.notify("Une trottinette Xiaomi noire a été retrouvée au commissariat !");
        System.out.println();
        
        
        // L'agent marque la declaration comme resolue

        agentP.modifierEtatDeclaration(declaration1, Etat.Résolue);
        declaration1.sauvegarder();  
        System.out.println("Declaration " + declaration1.getId() + " marquee comme resolue");
        System.out.println();
         
     // PARTIE 6 : Authentification et rapport quotidien  
        System.out.println("\n PARTIE 6 : Authentification de l'agent et generation du rapport");
        System.out.println();
        
        System.out.println("L'agent Sophie tente de se connecter au systeme.");
        if (agentP.authentifier("agentP123", "mdp123:")) {
            System.out.println("Connexion reussie");
            System.out.println();
            
            
         // Generation du rapport quotidien de vol (RQV)
            
            System.out.println(" Generation du Rapport Quotidien de Vol (RQV)");
            RQV rqv = agentP.creerRQV(new Date(System.currentTimeMillis()));
            System.out.println(" RQV du " + rqv.getDate());
            
            //// Affichage des nouvelles declarations
            
            System.out.println("  Liste des nouvelles déclarations :");
            for (DeclarationDeVol d : rqv.getNewDeclarations()) {
                ProprieteVolee p = d.getPropriete();
                System.out.println("+ ID " + d.getId() + " - "  + p.getMarque() + " " + p.getCouleur());
            }
            System.out.println();
            
         // Affichage des declarations mises a jour
            
            System.out.println("Liste des declarations mises a jour :");
            for (DeclarationDeVol d : rqv.getDeclarationsMAJ()) {
            	ProprieteVolee p = d.getPropriete();
                System.out.println("+ ID " + d.getId() + " - "  + p.getMarque() + " " + p.getCouleur());
            }
            System.out.println();
            
            // Affichage des declarations resolues
            System.out.println("Liste des declarations resolues :");
            for (DeclarationDeVol d : rqv.getDeclarationsResolue()) {
            	ProprieteVolee p = d.getPropriete();
                System.out.println("+ ID " + d.getId() + " - "  + p.getMarque() + " " + p.getCouleur());
            }
               
            // ==========PARTIE 7 : Supprission d'une declaration============
            
            System.out.println("Suppression de la déclaration ID " + declaration3.getId() + " (" 
                    + declaration3.getPropriete().getMarque() + " " + declaration3.getPropriete().getCouleur() + ")");
            declaration3.supprimer();
            
            System.out.println("Vérification après suppression :");
            for (DeclarationDeVol d : DeclarationDeVol.rechercherDeclarations(new java.sql.Date(System.currentTimeMillis()))) {
                ProprieteVolee p = d.getPropriete();
                System.out.println("+ ID " + d.getId() + " - " + p.getMarque() + " " + p.getCouleur());
            }
                
            }else {
                System.out.println("Connexion échouée.");
            }
            
          
        }
        		
}

	