public class Test {

    public static void main(String[] args) {

        String originalBookingReference = "AVC123";
        String thirdParty = "ABC123";
//        boolean test = (originalBookingReference = thirdParty);
        originalBookingReference = thirdParty;

        System.out.println(originalBookingReference);
    }
}
