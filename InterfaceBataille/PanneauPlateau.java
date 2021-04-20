package InterfaceBataille;

import BatailleNavale.CasePlateau;
import BatailleNavale.*;
import Players.*;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;


import java.awt.event.*;

public class PanneauPlateau extends JPanel{
    PlateauJoueur pJoueur;
    Player joueur;
    JPanel[][] plateau;
    //public static JPanel champ = new JPanel();

    public PanneauPlateau(PlateauJoueur pJoueur, Player joueur){
        super();
        this.pJoueur = pJoueur;
        this.joueur = joueur;
        this.plateau = new JPanel[10][10];
        this.setLayout(new GridLayout(10,10));
        this.dessiner();
        this.setPreferredSize(new Dimension(800,600));
    	this.setVisible(true);
    }


    public void dessiner(){
        for(int i=0;i<10;i++){
            for(int j=0; j<10;j++){
                this.add(new PanneauCase(this.pJoueur.plateau[i][j],this.pJoueur));
            }
        }
    }

}