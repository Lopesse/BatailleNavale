package BatailleNavale.Modeles;
import java.util.*;

public class AbstractModelListenable {
    ArrayList<ModelListener> abonnes;

    public AbstractModelListenable(){
        this.abonnes = new ArrayList<ModelListener>();
    }

    public void addModelListener(ModelListener ecouteur){
        this.abonnes.add(ecouteur);
    }

    public void removeModeListener(ModelListener ecouteur){
        this.abonnes.remove(ecouteur);
    }
    
    protected void fireChange(){
        for(ModelListener ecouteur: this.abonnes){
            ecouteur.modelUpdatedOb(this);
        }
    }

    // protected void placerPartie(){
    //     for(ModelListener ecouteur: this.abonnes){
    //         ecouteur.placerPartie(this);
    //     }
    // }
}
