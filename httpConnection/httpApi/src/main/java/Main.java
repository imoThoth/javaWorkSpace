import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

String jsonString = "[{\"Time Series (5min)\": {\"2023-10-06 17:25:00\": {\"3. low\":\"177.5000\",\"5. volume\":\"1927\"," +
        "\"1. open\":\"177.5000\",\"2. high\":\"182.7300\",\"4. close\":\"177.5100\"},\"2023-10-06 14:40:00\": {\"3. low\"" +
        ":\"177.5630\",\"5. volume\":\"388005\",\"1. open\":\"177.6180\",\"2. high\":\"177.6900\",\"4. close\":\"177.6200\"}" +
        ",\"2023-10-06 13:35:00\": {\"3. low\":\"177.1200\",\"5. volume\":\"410354\",\"1. open\":\"177.2590\",\"2. high\"" +
        ":\"177.3900\",\"4. close\":\"177.3450\"},\"2023-10-06 19:00:00\": {\"3. low\":\"177.5100\",\"5. volume\":\"565\"," +
        "\"1. open\":\"177.5300\",\"2. high\":\"177.5400\",\"4. close\":\"177.5150\"}},\"Meta Data\": {\"5. Output Size\":\"C" +
        "ompact\",\"2. Symbol\":\"AAPL\",\"4. Interval\":\"5min\",\"1. Information\":\"Intraday (5min) open, high, low, cl" +
        "ose prices and volume\",\"3. Last Refreshed\":\"2023-10-06 19:55:00\",\"6. Time Zone\":\"US\\/Eastern\"}}]";

        try{

            URL url = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=AAPL&interval=5min&apikey=CB4VVOF5JPYWD0HW");
            //XDBUB8LIKUD71Y37
//            CB4VVOF5JPYWD0HW
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();;

//            Check if connection is made
            int responseCode = conn.getResponseCode();

            //200  OK
            if(responseCode != 200){
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            }else{

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner((url.openStream()));

                while(scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
//                Close the scanner
                scanner.close();

//                      TODO : Attempt 1, rework attempt 1
                StringBuilder firstJsonParse = new StringBuilder();
                

                JSONParser parse = new JSONParser();
                Object obj = parse.parse(String.valueOf(informationString));
                JSONArray jsonArray = new JSONArray();
                jsonArray.add(obj);
                firstJsonParse.append(jsonArray);


                System.out.println(firstJsonParse);
//                TODO: Attempt 2
                ObjectMapper objectMapper = new ObjectMapper();
                ResponseParser[] response = objectMapper.readValue(firstJsonParse.toString(), ResponseParser[].class);

                //Access Parsed Data
                ResponseParser singleResponse = response[0];
                TimeSeries singleTimeSeries = singleResponse.getTimeSeries();
                MetaData metaData = singleResponse.getMetaData();
//                Map<String, TimeEntry> dataEntry = singleTimeSeries.getEntries();


//                 for (Map.Entry<String, TimeEntry> entry : dataEntry.entrySet()) {
//                                System.out.println("Timestamp: " + entry.getKey());
//                                TimeEntry timeEntry = entry.getValue();
//                                System.out.println("Low: " + timeEntry.getLow());
//                                System.out.println("Volume: " + timeEntry.getVolume());
//                                System.out.println("Open: " + timeEntry.getOpen());
//                                System.out.println("High: " + timeEntry.getHigh());
//                                System.out.println("Close: " + timeEntry.getClose());
//                                System.out.println("-----");
//                            }
//                System.out.println("Time Series" + timeSeries);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
