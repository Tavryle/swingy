package Model;

public class  Map {
    public static int size;

    public void mapSize(Player player){
        if(player.level == 0) {
            this.size = 6;
        }
        else{
            if(player.level > 0)
                this.size =  (player.level - 1) * 5 + 10 - ( player.level % 2);
        }
    }
    public void startingLocation(Player player){
        Coordinate place = new Coordinate();
        place.y = this.size / 2;
        place.x = this.size / 2;
        player.coordinate = place;
    }
    public static void newMap(Player player){
        Map map = new Map();
        map.mapSize(player);
        map.startingLocation(player);
    }
}
