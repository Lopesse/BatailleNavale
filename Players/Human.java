package Players;
import java.util.Scanner;

import BatailleNavale.Bateau;
import BatailleNavale.PlateauJoueur;

public class Human implements Player{
    public String name;
    Scanner scanner = new Scanner(System.in);
    PlateauJoueur plateau;
    Bateau[] bateaux;

    public Human(String name){
        this.name=name;
        this.plateau = new PlateauJoueur(this);
    }

    public String getName(){
        return this.name;
    }

    public PlateauJoueur getPlateau(){
        return this.plateau;
    }

    public void placerBateau(Bateau bateau, int ligne, int colonne, String sens){
        if((sens == "V") || (sens=="H")){
            if(sens=="V"){
                if((bateau.getLongueur()>this.plateau.nbLignes-ligne+1)||this.plateau.plateau[ligne-1][colonne-1].getContenu()!=null){
                    System.out.println("Impossible de placer le bateau ici\n");
                }
                else{
                    for(int i=ligne-1, partie = 0; i<ligne-1+ bateau.getLongueur() && partie < bateau.getLongueur();i++,partie++){                      // avec 'partie' on parcourt l'array de parties du bateau pour creer la case respective
                        this.plateau.plateau[i][colonne-1].placerPartie(bateau.partiesBateau[partie]);
                    }
                }

            }
            if(sens=="H"){
                if((bateau.getLongueur()>this.plateau.nbColonnes-colonne+1)||this.plateau.plateau[ligne-1][colonne-1].getContenu()!=null) {
                    System.out.println("Impossible de placer le bateau ici\n");
                }
                else{
                    for (int j=colonne-1, partie = 0; j<colonne-1+bateau.getLongueur() && partie < bateau.getLongueur();j++, partie++){
                        this.plateau.plateau[ligne-1][j].placerPartie(bateau.partiesBateau[partie]);
                    }
                }

            }
        }
        else{
            System.out.println("Sens non compris (H pour horizontal, V pour vertical)\n");
        }
    }

}