package Encapsulation;

public class Player {
    public String name;
    public int hp;
    public String weapon;

    public void loseHealth(int damage){
        this.hp = this.hp - damage;
        if(this.hp <= 0){
            System.out.println("You have been killed");
        }
    }
    public int healthRemaining(){
        return this.hp;
    }
}
