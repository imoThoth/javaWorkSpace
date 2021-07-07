package DesignPattenPrinciple.Polymor;


interface LivesInOcean {public void makeSound();}

class Dolphin implements LivesInOcean{
    public void makeSound(){
        System.out.println("whistle..inggg"); }
}
class Whale implements LivesInOcean {
    private boolean soundDecibels = true;

    public void makeSound() {
        System.out.println("Sing,,...inging");

    }

    static class Oceangrapher {
        public void checkSound(LivesInOcean animal) {
            animal.makeSound();
        }

        static class Polymorphism {
            /**
             * Ability of a single interface to support multiple underlying forms
             * in java, allows multiple types of objects to be passed to a single method or class
             */
            public static void main(String[] args) {
                Oceangrapher o = new Oceangrapher();
                o.checkSound(new Dolphin());
                o.checkSound(new Whale());
            }
        }
    }
}
