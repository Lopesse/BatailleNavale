package InterfaceBataille;

import java.awt.*;
import javax.swing.*;

import BatailleNavale.*;
import Players.*;
import java.awt.event.*;

public class ChampBataille extends JFrame implements ActionListener{
    PlateauJoueur pJoueur1, pJoueur2;
    Player joueur, adversaire;
    public ChampBataille(Player player1, Player player2){
        super("Bataille Navale");
        this.joueur = player1;
        this.adversaire = player2;
        this.pJoueur1 = this.joueur.getPlateau();
        this.pJoueur2 = this.adversaire.getPlateau();

        Container cp = this.getContentPane();
        
        cp.setLayout(new GridLayout(2,1));

        PanneauPlateau plateau_j1 = new PanneauPlateau(this.pJoueur1,this.joueur);
        PanneauPlateau plateau_j2 = new PanneauPlateau(this.pJoueur2,this.joueur);

        cp.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, plateau_j1, plateau_j2));    // diviseur de panneaux

        JButton ajoutBoutton = new JButton("Placer les bateaux");
        ajoutBoutton.addActionListener(this);
        cp.add(ajoutBoutton);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i<4; i++){
            String ligneBateau = JOptionPane.showInputDialog("ligne");
            String colonneBateau = JOptionPane.showInputDialog("colonne");
            int directionBateau = JOptionPane.showConfirmDialog(this, "Horizontal", "Sens du bateau", JOptionPane.YES_NO_OPTION);
            String sens = directionBateau == JOptionPane.YES_OPTION ? "H" : "V";
            int ligne = Integer.parseInt(ligneBateau);
            int colonne = Integer.parseInt(colonneBateau);
            this.joueur.placerBateau(this.pJoueur1.getBateaux()[i], ligne, colonne,sens);
        }
    }

    




}