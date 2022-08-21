public interface ITelephone {

    //defining interface contract/signatures
    void poweredON();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    public boolean isRinging();
}
