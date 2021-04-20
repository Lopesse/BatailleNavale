package Players;

import BatailleNavale.*;

public interface Player{
    public String getName();
    public void placerBateau(Bateau bateau, int ligne, int colonne, String sens);
    public PlateauJoueur getPlateau();
}