package codeWars;

public class GrassHopper {

    public static char getGrade(int s1, int s2, int s3){


        int score = s1 + s2 + s3 ;
        int result = score / 3;
        char singleChar = 0;

        if(result < 0 || result > 100){
            return 0;
        }

        if(90 <= result ){
            singleChar = 'A';
        }else if(80 <= result ){
            singleChar = 'B';
        }else if(70 <= result){
            singleChar = 'C';
        }else if(60 <= result){
            singleChar = 'D';
        }else if(0 <= result){
            singleChar = 'F';
        }

        return singleChar;

    }

    public static void main(String[] args) {

        System.out.println(getGrade(95, 90, 93));

    }
}
