package Model;

public class Villain{
    public typeOfVillain villain;
    public String name;
    public String artifact;
    public int power;

    public Villain() {
        String[] artifacts = {"Armor", "Weapon", "Helm"};
        String[] names = {"Giant", "Ghoul", "Hell_Hound"};

        int random = (int) (Math.random() * 3);
        this.name = names[random];
        switch (name) {
            case "Hell_Hound" -> {
                this.artifact = artifacts[0];
                this.power = 500;
            }
            case "Ghoul" -> {
                this.artifact = artifacts[1];
                this.power = 700;
            }
            case "Gaint" -> {
                this.artifact = artifacts[2];
                this.power = 800;
            }
            default -> System.out.println("Nothing was picked");
        }
    }
    public String getName(){
        return this.name;
    }
}
