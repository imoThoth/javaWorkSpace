import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class TimeSeries {


    @JsonProperty("Time Series (5min)")
    private Map<String, TimeEntry> entries;

    // Default constructor (no-argument constructor) required by Jackson
    public TimeSeries() {
    }

    // Constructor with entries parameter
    @JsonCreator
    public TimeSeries(@JsonProperty("Time Series (5min)")Map<String, TimeEntry> entries) {
        this.entries = entries;
    }

    /**
     * method called for any unrecognized JSON property
     * adds data using unrecognized JSON as the key
     * in this case the date
     * @param key
     * @param entry
     */
    @JsonAnySetter
    public void addEntry(String key, TimeEntry entry) {
        if (entries == null) {
            entries = new HashMap<>();
        }

        // Use the key as a date if it's not recognized
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(key);
            DateTime dateTime =new DateTime(date, DateTimeZone.UTC);
            entries.put(String.valueOf(dateTime), entry);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Use the key as a date if it's not recognized
    }

    // Getter and setter methods
    public Map<String, TimeEntry> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, TimeEntry> entries) {
        this.entries = entries;
    }
}


class TimeEntry{

    @JsonProperty("3. low")
    private String low;

    @JsonProperty("5. volume")
    private String volume;

    @JsonProperty("1. open")
    private String open;

    @JsonProperty("2. high")
    private String high;

    @JsonProperty("4. close")
    private String close;
    private Date timeStamp;

    public String getLow() {
        return this.low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getOpen() {
        return this.open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return this.high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getClose() {
        return this.close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public Date getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}