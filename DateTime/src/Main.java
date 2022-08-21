import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

            Calendar c = Calendar.getInstance();
                int date = 14;
                int month = 0;
                int year = 2022;
                c.set(year, month, date);
                
                int dayOfWeek = c.get(Calendar.DAY_OF_MONTH);

                System.out.println(dayOfWeek);


        
    }
}
