public class SquareNum {
    public static int squareSum(int[] n)
    {
        //Your Code
        int score = 0;
        for(int i=0; i < n.length; i++){
            System.out.println(score += n[i] * n[i]);
        }
        return score;
    }

    public static int squareSumSimp(int[] n){
        int score = 0;
        for(int num: n){
            score += num * num;
        }
        return score;
    }

    public static void main(String[] args) {

        System.out.println("Num: " + squareSumSimp(new int[] {1, 2, 2}));
    }
}
