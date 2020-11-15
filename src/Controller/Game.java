package Controller;

import Model.Map;
import Model.Player;
import Model.Villain;

public class Game {
    public Villain[] createVillains(){
        int number = Map.size / 2;
        Villain[] vill = new Villain[number];
        for(int i = 0; i < vill.length; i++){
            vill[i] = new Villain();
        }
        return vill;
    }

    public void makeCoordinates(Villain[] villain, Player player){
        int y;
        int x;

        for(int i = 0; i < villain.length; i++){
            x = (int) (Math.random() * Map.size);
            villain[i].x = x;
        }
        for(int i = 0; i < villain.length; i++){
            y = (int) (Math.random() * Map.size);
            villain[i].y = y;

            if((villain[i].x == player.coordinate.x) && (villain[i].y == player.coordinate.y)){
                while(villain[i].x == player.coordinate.x){
                    villain[i].x = (int) (Math.random() * Map.size);
                }
            }
        }
    }
}
