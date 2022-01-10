package com.project.coronavirustracker;

import org.apache.commons.csv.CSVFormat;
import org.springframework.stereotype.Service;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusData {

        private static String Virus_Data_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/" +
                "master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

        private List<LocationStats> allStats = new ArrayList<LocationStats>();

        @PostConstruct
        @Scheduled(cron = "* * 1 * * *")
        public void fetchData() throws IOException, InterruptedException {
            List<LocationStats> currentStats = new ArrayList<>();

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(Virus_Data_URL))
                    .build();
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

            //System.out.println(httpResponse.body()); //Prints out the data from the api
            StringReader apiData = new StringReader(httpResponse.body());
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(apiData);

            for(CSVRecord record: records){
                LocationStats loci = new LocationStats();
                loci.setState(record.get("Province/State"));
                loci.setCountry(record.get("Country/Region"));
                loci.setLatestTotalCases(Integer.parseInt(record.get(record.size()-1)));
                System.out.println(loci);
                currentStats.add(loci);
            }
            this.allStats = currentStats;
        }
    }


