public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;

    }

    @Override
    public void poweredON() {
        isOn = true;
        System.out.println("Mobile Phone is now powered on");
    }

    @Override
    public void dial(int phoneNumber) {
        if(isOn){
            System.out.println("Now Ringing " + " mobile phone");
        }else{
            System.out.println("Switched off");
        }

    }

    @Override
    public void answer() {
        if(isRinging){
            System.out.println("Answering Mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber && isOn){
            isRinging = true;
            System.out.println("Ring-A-Ling-A-Ring");
        }else{
            isRinging = false;
            System.out.println("You have reached the mobile voicemail");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }

}
