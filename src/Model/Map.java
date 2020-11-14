package Model;

public class  Map {
    public int size;

    public void mapSize(player){
        if(player.level == 0) {
            this.size = 6;
        }
        else{
            if(player.level > 0)
                this.size =  (level - 1) * 5 + 10 - ( level % 2);
        }
    }
}
