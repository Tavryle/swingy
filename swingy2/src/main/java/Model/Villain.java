package Model;

import javax.validation.constraints.NotNull;

public class Villain{
    public typeOfVillain villain;
    @NotNull(message = "Player Name is needed")
    public String name;
    public String artifact;
    public int power;
    public int y;
    public int x;

    public Villain() {
        String[] artifacts = {"Armor", "Weapon", "Helm"};
        String[] names = {"Giant", "Ghoul", "Hell_Hound"};

        int random = (int) (Math.random() * 3);
        this.name = names[random];
        switch (name) {
            case "Hell_Hound": {
                this.artifact = artifacts[0];
                this.power = 500;
            }
            break;
            case "Ghoul": {
                this.artifact = artifacts[1];
                this.power = 700;
            }
            break;
            case "Gaint": {
                this.artifact = artifacts[2];
                this.power = 800;
            }
            break;
        }
    }
    public String getName(){
        return this.name;
    }
}
