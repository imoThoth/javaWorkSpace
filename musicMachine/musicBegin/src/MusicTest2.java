import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*; // used to call constant in short message class
import javax.sound.midi.Sequencer;

public class MusicTest2 {

//    public static void main(String[] args) {
//        MusicTest2 mini = new MusicTest2();
//        if(args.length < 2){
//            System.out.println("Dont forget instrument and note args");
//        }else{
//            int instrument = Integer.parseInt(args[0]);
//            int note = Integer.parseInt(args[1]);
//            mini.playAdv(instrument, note);
//        }
//    }
    public void playAdv(int instrument, int note){
        try{
            Sequencer sequencerPlayer = MidiSystem.getSequencer();
            sequencerPlayer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);
            Track track = sequence.createTrack();

            ShortMessage msg1 = new ShortMessage();
            msg1.setMessage(PROGRAM_CHANGE, 1, instrument, 0);
            MidiEvent changeInstrument = new MidiEvent(msg1, 1);
            track.add(changeInstrument);

            ShortMessage msg2 = new ShortMessage();
            msg1.setMessage(NOTE_ON, 1, note, 100);
            MidiEvent noteOn = new MidiEvent(msg2, 1);
            track.add(noteOn);

            ShortMessage msg3 = new ShortMessage();
            msg1.setMessage(NOTE_OFF, 1, note, 100);
            MidiEvent noteOff = new MidiEvent(msg3, 16);
            track.add(noteOff);

            sequencerPlayer.setSequence(sequence);
            sequencerPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
