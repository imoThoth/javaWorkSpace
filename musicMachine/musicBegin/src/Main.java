import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MusicTest1 sampleMidiSystem = new MusicTest1();

        sampleMidiSystem.play();

        MusicTest2 mini = new MusicTest2();
        if(args.length < 2){
            System.out.println("Dont forget instrument and note args");
        }else{
            int instrument = Integer.parseInt(args[0]);
            int note = Integer.parseInt(args[1]);
            mini.playAdv(instrument, note);
        }
    }
}
