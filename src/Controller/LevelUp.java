package Controller;

import Model.Player;

public class LevelUp {
    public static boolean levelUp(Player player){
        if(player.xp >= 1000 && player.level < 1){
            player.level = 1;
            System.out.println("leveled up " + player.level + "\n");
            return true;
        }
        else if(player.xp >= 2450 && player.level < 2){
            player.level = 2;
            System.out.println("leveled up " + player.level + "\n");
            return true;
        }
        else if(player.xp >= 4800 && player.level < 3){
            player.level = 3;
            System.out.println("leveled up " + player.level + "\n");
            return true;
        }
        else if(player.xp >= 8050 && player.level < 4){
            player.level = 4;
            System.out.println("leveled up " + player.level + "\n");
            return true;
        }
        else if(player.xp >= 12200 && player.level < 5){
            player.level = 5;
            System.out.println("leveled up " + player.level + "\n");
            return true;
        }
        else
            return false;
    }
}
