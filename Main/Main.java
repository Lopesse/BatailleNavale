package Main;
import BatailleNavale.*;
import Players.*;
import InterfaceBataille.*;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Player player1 = new Human("Gertrude");
        Player player2 = new Human("Raymonde");

        ChampBataille pp = new ChampBataille(player1,player2);
    }
}