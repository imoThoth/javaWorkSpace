package dateTime;
import java.time.*; //imports time class

public class Main {

    public static void main(String[] args) {
	/**
     * LocalDate - Contains just date, no time and no time zone... e.g birthday
     *LocalTime - Contains time, no date and no time zone... 00:00
     * LocalDateTime - Contains Date and Time but no time zone
     * ZonedDateTime - Contains Date, Time and a Time Zone
     * **/

	    // Demonstrates the .now static method of each class
        System.out.println("Show local date " + LocalDate.now());
        System.out.println("Show Local time " + LocalTime.now());
        System.out.println("Show local date and time " + LocalDateTime.now());
        System.out.println("Show zone date and time " + ZonedDateTime.now());

        //2 ways of creating date with no time
        LocalDate meth1 = LocalDate.of(2015, Month.APRIL, 10);
        LocalDate meth2 = LocalDate.of(2015, 4,10);

        //month is an example of an enum and how to compare enums
        Month month = Month.AUGUST;
        boolean comp = month == Month.AUGUST;

        //Creating Time
        LocalTime metho1 = LocalTime.of(6,15); //Creates hours and minutes
        LocalTime metho2 = LocalTime.of(7,30,10);//Creates hours, minutes, seconds
        LocalTime metho3 = LocalTime.of(7,30,10,5);//creates hours, minutes, seconds, nanoSeconds

        //Combining Date and Time into a single Object
        LocalDateTime meh1 = LocalDateTime.of(meth1, metho2);
        LocalDateTime meh2 = LocalDateTime.of(2015,Month.APRIL,10,12,24,10,20);

        //Creating local zone
        ZoneId zone = ZoneId.of("Europe/Paris");
        ZonedDateTime zoned = ZonedDateTime.of(2012, 12, 6, 18, 15, 39, 20, zone); //uses local date time zone
        ZonedDateTime zoned1 = ZonedDateTime.of(meth1, metho1, zone);// uses local date, local time and zone
        ZonedDateTime zoned2 = ZonedDateTime.of(meh1, zone); //uses zone and local datetime

        //Finding a time zone
        ZoneId.getAvailableZoneIds().stream()
                .filter(z -> z.contains("London") || z.contains("Europe"))
                .sorted().forEach(System.out::println);

       //Changing and Manipulating Time Date Methods
        LocalDate date = LocalDate.of(2020, Month.JUNE, 20);
        LocalTime time = LocalTime.of(5,15);
        LocalDateTime dateTime = LocalDateTime.of(date,time)
                .minusDays(1).minusHours(10).minusSeconds(30);

        //Working With Periods
        //Period measures large quantites of time, years, months, week days
        Period anually = Period.ofYears(1);
        Period quaterly = Period.ofMonths(3);
        Period threeWeeks = Period.ofWeeks(3);
        Period ofDays = Period.ofDays(20);
        Period yearAndWeek = Period.of(20, 2, 21);
        System.out.println("Perods " + " anually: " + anually + " quaterly: " + quaterly);

        //Working with Durations
        //Duration works with smaller quantities of time, seconds, hours, nanos, days
        //Instant is a point in time
        Duration daily = Duration.ofDays(1);
        System.out.println("Displays daily " + daily);
        Duration hourly = Duration.ofHours(1);
        System.out.println("Displays hourly " + hourly);
        Duration everyMinute = Duration.ofMinutes(1);
        System.out.println("Displays everyMinutes " + everyMinute);
        Duration everyTenSeconds = Duration.ofSeconds(10);
        System.out.println("everyTenSeconds " + everyTenSeconds);
        Duration everyMilli = Duration.ofMillis(10);
        System.out.println("everyMilliSeconds " + everyMilli);
        Duration everyNano = Duration.ofNanos(60);

    }
}
