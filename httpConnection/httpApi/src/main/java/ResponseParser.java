
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseParser {

    @JsonProperty("Time Series (5min)")
    private TimeSeries timeSeries;

    @JsonProperty("Meta Data")
    private MetaData metaData;

    public TimeSeries getTimeSeries() {
        return this.timeSeries;
    }

    public void setTimeSeries(TimeSeries timeSeries) {
        this.timeSeries = timeSeries;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }
}


class MetaData{

    @JsonProperty("1. Information")
    private String information;
    @JsonProperty("2. Symbol")
    private String symbol;
    @JsonProperty("3. Last Refreshed")
    private String lastRefreshed;
    @JsonProperty("4. Interval")
    private String interval;
    @JsonProperty("5. Output Size")
    private String outputSize;
    @JsonProperty("6. Time Zone")
    private String timeZone;

    public String getInformation() {
        return this.information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLastRefreshed() {
        return this.lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getInterval() {
        return this.interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getOutputSize() {
        return this.outputSize;
    }

    public void setOutputSize(String outputSize) {
        this.outputSize = outputSize;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "information='" + information + '\'' +
                ", symbol='" + symbol + '\'' +
                ", lastRefreshed='" + lastRefreshed + '\'' +
                ", interval='" + interval + '\'' +
                ", outputSize='" + outputSize + '\'' +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}





