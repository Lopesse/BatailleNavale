package BatailleNavale;


import BatailleNavale.Modeles.*;

public class CasePlateau extends AbstractModelListenable{
    boolean obus;
    int ligne, colonne;
    public PlateauJoueur appartenance;
    PartieBateau contenu;
    public CasePlateau(int ligne, int colonne, PlateauJoueur appartenance, PartieBateau contenu){          // changer appartenance au plateau 
        this.colonne = colonne;
        this.ligne = ligne;
        this.appartenance=appartenance;
        this.contenu = contenu;
        this.obus = false;
    }

    public String toString(){
        return "Ligne de la case : "+this.ligne+"\nColonne de la case : "+this.colonne+"\nCase détruite : "+ this.obus +"\nPlateau: " + this.getPlateau();
    }
    public boolean getEtat(){
        return this.obus;
    }

    public int getLigne(){
        return this.ligne;
    }

    public int getColonne(){
        return this.colonne;
    }

    public PlateauJoueur getPlateau(){
        return this.appartenance;
    }

    public PartieBateau getContenu(){
        return this.contenu;
    }

    public void setEtat(boolean etat){
        this.obus = etat;                                               // lors du changemant d'état, on dit aux écouteurs qu'il a changé
        if(this.contenu != null){
            this.contenu.setEtat();
        }
        this.fireChange();
    }

    public void placerPartie(PartieBateau partie){
        this.contenu = partie;
        this.fireChange();
    }
}