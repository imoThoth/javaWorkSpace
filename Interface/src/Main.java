public class Main {

    public static void main(String[] args) {
	// write your code here
        ITelephone tosinsDesk;
        tosinsDesk = new DeskPhone(5001675);
        tosinsDesk.callPhone(5001675);
        tosinsDesk.answer();
        tosinsDesk.dial(5012912);

        MobilePhone tosinMobile = new MobilePhone(1209123445);

        tosinsDesk = new MobilePhone(1234151);
    }
}
