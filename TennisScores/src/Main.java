import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        if(args.length != 2){
            System.out.println("Usage: Could find java tennis score input and output file");
            System.exit(1);
        }

        String inputFiles = args[0], outputFiles = args[1];

        File inputFile = new File(args[0]);
        File outputFile = new File(args[1]);

        if(!inputFile.exists() || !outputFile.exists()){
            System.out.println("The input or output file does not exist");
        }

        try {
            Scanner scanner = new Scanner(inputFile);
            PrintWriter  writer = new PrintWriter(new FileWriter(outputFile, true));

            while (scanner.hasNextLine()) {
                String tennisGameSequence = scanner.nextLine();
                String score = calculateScore(tennisGameSequence, writer);
                writer.println(score);
            }
            scanner.close();
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String calculateScore(String sequence, PrintWriter writer) {

        int playerAPoints = 0, playerBPoints = 0, playerAGamesWon = 0, playerBGamesWon = 0, playerASetsWon = 0, playerBSetsWon = 0;
        char server = 0;

        if(sequence.toCharArray().length > 1){
            server = sequence.toCharArray()[1];
        }

        StringBuilder result = new StringBuilder();

        for (char point : sequence.toCharArray()) {

            if (point == 'A') {
                playerAPoints++;
            } else if (point == 'B') {
                playerBPoints++;
            }

            if (playerAPoints >= 4 && playerAPoints - playerBPoints >= 2) {
                playerAGamesWon++;
                    playerBPoints = 0;
                    playerAPoints = 0;

            } else if (playerBPoints >= 4 && playerBPoints - playerAPoints >= 2) {
                playerBGamesWon++;
                    playerBPoints = 0;
                    playerAPoints = 0;
            }

            if (playerAGamesWon >= 6) {
                result.append(playerAGamesWon).append("-").append(playerBGamesWon).append(" ");
                playerAGamesWon = 0;
                playerBGamesWon = 0;
                playerASetsWon++;

            }else if(playerBGamesWon >= 6) {
                result.append(playerAGamesWon).append("-").append(playerBGamesWon).append(" ");
                playerAGamesWon = 0;
                playerBGamesWon = 0;
                playerASetsWon++;
            }

        }

        result.append(formatScore(playerAPoints, playerBPoints, playerAGamesWon, playerBGamesWon)).append(" ");

        return result.toString().trim();
    }

    private static String formatScore(int playerAPoints, int playerBPoints, int playerASets, int playerBSets) {
            return playerASets + "-" + playerBSets + " "  +  formatPoints(playerAPoints, playerBPoints);
    }

    private static String formatPoints(int playerAScore, int playerBScore) {
        if (playerAScore == 0 && playerBScore == 0) {
            return " ";
        } else {
            String formatName = formatName(playerAScore) + "-" + formatName(playerBScore);

            if(formatName.equals("A-A")){
                return "Deuce-Deuce";
            }

            return formatName(playerAScore) + "-" + formatName(playerBScore);
        }
    }

    private static String formatName(int score){
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> score % 2 == 0 ? "A" : "Deuce";
        };
    }

}