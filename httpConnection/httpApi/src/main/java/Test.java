import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {
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
            ObjectMapper objectMapper = new ObjectMapper();
            ResponseParser[] response = objectMapper.readValue(jsonString, ResponseParser[].class);

            //Access Parsed Data
            ResponseParser singleResponse = response[0];
            TimeSeries timeSeries = singleResponse.getTimeSeries();
            MetaData metaData = singleResponse.getMetaData();


            System.out.println("Time Series" + timeSeries);

            Map<String, TimeEntry> entries = new TreeMap<>();
            entries = timeSeries.getEntries();
            System.out.println("entries: " + entries);
//            System.out.println("Entry Size" + entries.size());
            Map<DateTime, TimeEntry> sortedEntry = new HashMap<>();

            for (Map.Entry<String, TimeEntry> entry : entries.entrySet()) {
                System.out.println("Timestamp: " + DateTime.parse(entry.getKey()));
                TimeEntry timeEntry = entry.getValue();
                System.out.println("Low: " + timeEntry.getLow());
                System.out.println("Volume: " + timeEntry.getVolume());
                System.out.println("Open: " + timeEntry.getOpen());
                System.out.println("High: " + timeEntry.getHigh());
                System.out.println("Close: " + timeEntry.getClose());
                sortedEntry.put(DateTime.parse(entry.getKey()), timeEntry);
                System.out.println("-----");
            }

            System.out.println("Sorted ENtry" + sortedEntry);

            System.out.println("Meta Data Symbol" + metaData.getSymbol());
        }catch(JsonProcessingException e){
            e.printStackTrace();
        }

    }
}
