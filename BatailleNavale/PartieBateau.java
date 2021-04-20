package BatailleNavale;
public class PartieBateau {
    boolean estTete, touchee;
    public PartieBateau(boolean estTete){
        this.estTete = estTete;
        this.touchee = false;
    }

    public boolean isTete(){
        return this.estTete;
    }

    public boolean getEtat(){
        return this.touchee;
    }
    
    public void setEtat(){
        if(!this.touchee){
            this.touchee = true;
        }
    }
}