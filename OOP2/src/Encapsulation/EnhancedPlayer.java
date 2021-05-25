package Encapsulation;

public class EnhancedPlayer {
    private String name;
    private int hp = 100;
    private String weapon;

    public EnhancedPlayer(String name, int hp, String weapon) {
        this.name = name;
        if(hp>100 && hp <=200){
            this.hp = hp;
        }
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public String getWeapon() {
        return weapon;
    }

    public void loseHealth(int damage){
        this.hp = this.hp - damage;
        if(this.hp <= 0){
            System.out.println("You have been killed");
        }
    }
}