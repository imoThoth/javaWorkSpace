import javax.sound.midi.*;
import static javax.sound.midi.ShortMessage.*; // used to call constant in short message class
import javax.sound.midi.Sequencer;

public class MusicTest1 {

    public void play(){
        try{
            Sequencer sequencerPlayer = MidiSystem.getSequencer();
            sequencerPlayer.open();

            Sequence sequence = new Sequence(Sequence.PPQ, 4);

            //ask sequence for track
            //track lives in sequence and midi data lives inside track
            Track track = sequence.createTrack();

            ShortMessage msg1 = new ShortMessage();
            //msgType, 144 on 128 off
            // channel[drum/piano],
            // note to play[middle c,b sharp](0 - 127),
            // velocity
            msg1.setMessage(144, 1, 89, 100); // turn the note on, and start playing note 44
            MidiEvent noteOn = new MidiEvent(msg1, 1); //moment in time, when message should be triggered
            track.add(noteOn);

            sequencerPlayer.setSequence(sequence);
            sequencerPlayer.start();
            System.out.println("Successfully received sequence");
        }catch(Exception e){
            System.out.println("Unable to receive Midi Sequence");
        }
    }
}
