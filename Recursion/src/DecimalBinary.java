public class DecimalBinary {

    public static String findBinary(int decimal, String result){

        // base condition
        if(decimal == 0){
            return result;
        }

        // smallest possible step to achieve result
        result = decimal % 2 + result;

        return findBinary(decimal / 2, result);
    }

    public static void main(String[] args) {
        String binary = findBinary(223, "");
        System.out.println("Binary: " + binary);
    }
}
