package dateTime;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class i18nAndl10n {
    /***
     * Adding Internalisation and Localisation
     * Internationalization - Process of designing prog that can be adapted
     * There is no need to support a lang or country with i18n, as long as you can
     *
     * Localisation - Supporting multiple locales(geo,political/cultural region)
     * */

    public static void main(String[] args){

        //Picking a Locale
        //en_GB  english GreatBritain(langLocation)
        //You can also have language without country but not a reverse
        Locale loci = Locale.getDefault();
        System.out.println(loci);

        //Ways of Printing Locale
        System.out.println("Input Locale.Uk: " + Locale.UK);
        System.out.println("Input Locale.English: " + Locale.ENGLISH);

        System.out.println("Creating Locale with anonymous class initialisers");
        System.out.println("input fr: " + new Locale("fr"));
        System.out.println("input hi, IN " + new Locale("hi", "IN"));

        //Using Builder Pattern to create a locale
        Locale useBuilder = new Locale.Builder()
                .setRegion("GB")
                .setLanguage("en")
                .build();

        //Changing Default Locale
        Locale changeLocale = new Locale("fr");
        Locale.setDefault(changeLocale);

        /**Resource Bundles - contains local specific objects to be used in a program
         * can be thought of as a map and key, and kept within the property file
         *
         * Property File - File in specific format with key/value pairs
         * */

        //Using a Resource Bundle
        System.out.println("Using a resource Bundle");
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        Locale englishCanadian = new Locale("en", "CA");
        Locale frenchCanada = new Locale("fr", "CA");

        /**TO DO **/
//        printProperties(us);
//        System.out.println();
//        printProperties(france);
//        System.out.println();
//        printProperties(frenchCanada);
//        System.out.println();
//        printProperties(englishCanadian);

        /**Number Formatting - way of using static methods to retrieve desired formatter
         *
         * DateTimeFormatter - output dates and times in the desired format
         * */

        //Date Time Formatter
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(20,12,30);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));

        //Number Formatter
        int aLotOfPeople = 3_000_000;
        int letsDivide = aLotOfPeople / 16;
        NumberFormat uState = NumberFormat.getInstance(Locale.US);
        System.out.println("us format: " + uState.format(letsDivide));
        NumberFormat uKing = NumberFormat.getInstance(Locale.UK);
        System.out.println("uk format: " + uKing.format(letsDivide));

        int someMoney = 900;
        NumberFormat moneyForm = NumberFormat.getCurrencyInstance();
        System.out.println("Creating a money format " + moneyForm.format(someMoney));
    }
    public static void printProperties(Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("Zoo_", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));
    }
}
