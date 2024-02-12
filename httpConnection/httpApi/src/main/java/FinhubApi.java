import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class FinhubApi {

    public static FinhubParser parseJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, FinhubParser.class);
    }

    public static String convertToJson(FinhubParser finhubParser) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(finhubParser);
    }

    public static void main(String[] args) {

        String symbol = "AAPL";
        String resolution = "D"; // Daily resolution
        long from = System.currentTimeMillis() * 60 * 1000; // 5 days ago
        long to = System.currentTimeMillis();
        String FINNHUB_API_KEY = "cks4gv9r01qstsqsq8ogcks4gv9r01qstsqsq8p0";


        try {
            String completeURL = String.format("https://finnhub.io/api/v1/stock/candle?symbol=%s&resolution=%s&from=%d&to=%d&token=%s",
                    symbol, resolution, from, to, FINNHUB_API_KEY);

            URL url = new URL(completeURL);
            //XDBUB8LIKUD71Y37
//            CB4VVOF5JPYWD0HW
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            ;

//            Check if connection is made
            int responseCode = conn.getResponseCode();

            //200  OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner((url.openStream()));

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
//                Close the scanner
                scanner.close();

//                System.out.println(informationString);
//                      TODO : Attempt 1, rework attempt 1
                StringBuilder firstJsonParse = new StringBuilder();


                JSONParser parse = new JSONParser();
                Object obj = parse.parse(String.valueOf(informationString));
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(obj);
                firstJsonParse.append(jsonArray);

                FinhubParser parseData = parseJson(informationString.toString());
                String convertToJson = convertToJson(parseData);
                System.out.println(convertToJson);
//                System.out.println(firstJsonParse);
            }

        }catch (IOException | ParseException e){
            e.printStackTrace();
        }
    }
}