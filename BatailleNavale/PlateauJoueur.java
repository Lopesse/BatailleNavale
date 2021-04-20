package BatailleNavale;
import Players.*;


public class PlateauJoueur{
    public CasePlateau[][] plateau;
    public int nbLignes, nbColonnes;
    int ligne, colonne;
    Player player;
    Bateau[] bateaux;

    public PlateauJoueur(Player player){
        this.player = player;
        this.nbLignes= 10;
        this.nbColonnes=10;
        this.plateau = new CasePlateau[nbLignes][nbColonnes];
        this.bateaux = new Bateau[4];
        this.creerBateaux();
        this.creerCases();
    }

    public Player getPlauer(){
        return this.player;
    }

    public void creerCases(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.plateau[i][j] = new CasePlateau(i, j, this,null);
            }
        }
    }

    public void creerBateaux(){
        for(int i = 0; i<4; i++){
            switch(i){
                case 0:
                this.bateaux[i] = new Bateau(3);
                break;

                case 3:
                this.bateaux[i] = new Bateau(5);
                break;

                default:
                this.bateaux[i] = new Bateau(4);
            }
        }
    }

    public Bateau[] getBateaux(){
        return this.bateaux;
    }

    public String situationToString(){
        //Affichage du plateau en prenant en compte le joueur courant (celui qui va voir le plateau).
        //Celui-ci pourra seulement voir où sont placés ses bateaux (x) ainsi que les bateaux adverses qu'il a touché (!)
        String rep="";
        rep+="   1  2  3  4  5  6  7  8  9  10\n";
        for(int i=0;i<nbLignes;i++){
            String e = String.valueOf(i+1);
            rep+=e+"  ";
            for(int j=0; j<nbColonnes;j++){
                String suite = j == nbColonnes - 1 ? "\n" : " ";            // si on est à la dernière case, on fait un retour à la ligne, sinon on ajoute un espace. 
                if(this.plateau[i][j].getContenu()==null){                          // Si la case ne contient pas une partie de bateau affiche "."    
                    rep+=". "+ suite;
                }
                else{
                    if(this.plateau[i][j].getContenu().isTete()){               // Si la case contient une tete de bateau affiche "T"
                        rep+="T "+ suite;
                    }
                    else{     
                        rep+="C "+ suite;                                         // Si la case contient une partie du corps d'un bateau affiche "C"
                    }
                }
            }
        }
        return rep;
    }


}