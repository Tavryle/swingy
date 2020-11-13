package Model;

public class Map {
    public int size;

    public void mapSize(character){
        if(character.level == 0) {
            this.size = 6;
        }
        else{
            if(character.level > 0)
                this.size =  (level - 1) * 5 + 10 - ( level % 2);
        }
    }
}
