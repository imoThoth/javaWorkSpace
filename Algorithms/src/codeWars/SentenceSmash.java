package codeWars;

public class SentenceSmash {

    public static String smash(String... words) {
        // TODO Write your code below this comment please
        StringBuilder resultWord = new StringBuilder();

        if(words.length == 0){
            return "";
        }

        String lastWord = words[words.length - 1];

        for(String singleWord : words){

                resultWord.append(singleWord);

                if(!singleWord.equals(lastWord)){
                    resultWord.append(" ");
                }
            }

        return resultWord.toString();
    }

    public static void main(String[] args) {

        System.out.println(SentenceSmash.smash());
    }
}
