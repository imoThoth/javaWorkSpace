package Encapsulation;

public class Main {

    public static void main(String[] args){
        Player player = new Player();
        player.hp = 100;
        player.name = "zombie";
        player.weapon= "lantern";

        int damage = 80;
        player.loseHealth(damage);
        System.out.println("Remaining hp = " + player.healthRemaining());

        damage = 90;
        player.hp = 100000;
        player.loseHealth(damage);
        System.out.println("Remaining hp = " + player.healthRemaining());

        EnhancedPlayer playerOne = new EnhancedPlayer("dave",100,"grenade");
        System.out.println("Initial Health is " + playerOne.getHp());


    }
}
