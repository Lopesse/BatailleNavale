package BatailleNavale;

public class Bateau{
    int longueur;
    public PartieBateau[] partiesBateau;
    boolean estDetruit;

    public Bateau(int longueur){
        this.longueur=longueur;
        this.partiesBateau = new PartieBateau[longueur];
        this.estDetruit = false;
        this.creerBateau();
    }

    public int getLongueur() {
        return longueur;
    }

    public void creerBateau(){
        for (int i=0; i<this.longueur; i++){
            if((i == 0) || (i == this.longueur - 1)){
                this.partiesBateau[i] = new PartieBateau(true);
            }
            else{
                this.partiesBateau[i] = new PartieBateau(false);
            }
        }
    }

    public PartieBateau[] getParties(){
        return this.partiesBateau;
    }

    public void estDetruit(){
        for(PartieBateau pb : this.partiesBateau){
            this.estDetruit &= pb.getEtat();
        }
    }

    public boolean getEtat(){
        return this.estDetruit;
    }
}