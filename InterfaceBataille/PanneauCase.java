package InterfaceBataille;

import BatailleNavale.CasePlateau;
import Players.Player;
import BatailleNavale.*;
import javax.swing.*;
import java.awt.*;
import BatailleNavale.Modeles.*;
import java.awt.event.*;

public class PanneauCase extends JPanel implements ModelListener,MouseListener{
    PlateauJoueur pJeu;
    PlateauJoueur appartenance;
    CasePlateau modelCaseP;
    int ligne, colonne;

    static Color[] COULEURS = {Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.YELLOW, Color.PINK};
    public PanneauCase(CasePlateau caseP, PlateauJoueur appartenance){
        super();
        this.modelCaseP = caseP;
        this.modelCaseP.addModelListener(this);                                     // écouteur de case
        this.appartenance = appartenance;
        addMouseListener(this);                                                     // écouteur de clicks
        this.dessiner();
    }

    public void dessiner(){
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (this.modelCaseP.getPlateau() != this.appartenance){                           // si la case n'appartient pas au joueur qui la voit, on n'affiche que si la case a été frappée. 
            if(this.modelCaseP.getEtat()){
                if (this.modelCaseP.getContenu()!=null){
                    if(this.modelCaseP.getContenu().isTete()){
                        g.setColor(Color.PINK);
                    }else{
                        g.setColor(Color.ORANGE);
                    }
                }else{
                    g.setColor(Color.BLUE);
                }
                g.fillOval(0, 0, 50,50);
            }
        }else{
            if (this.modelCaseP.getContenu() != null){
                if (this.modelCaseP.getContenu().isTete()){
                    if (this.modelCaseP.getEtat()){
                        g.setColor(Color.PINK); 
                    }else{
                        g.setColor(Color.YELLOW);
                    }
                    g.fillOval(0,0, 50,50);
                }else{
                    if (this.modelCaseP.getEtat()){
                        g.setColor(Color.RED); 
                    }else{
                        g.setColor(Color.GREEN);
                    }
                    g.fillOval(0,0, 50,50);
                } 
            }else{
                if(this.modelCaseP.getEtat()){
                    g.setColor(Color.BLUE);
                    g.fillOval(0,0, 50,50);
                }
            }
             
        }
    }

    @Override
    public void modelUpdatedOb(Object source) {
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.modelCaseP.setEtat(true);                                      // lors d'un click, on change l'état de la case qui a été clickée
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}