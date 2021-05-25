package Challenge;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted = 0;
    private Boolean duplexPrinter = true;

    public Printer(int tonerLevel, int pagesPrinted, Boolean duplexPrinter) {
        if(tonerLevel < 100 && tonerLevel <=200){
            this.tonerLevel = tonerLevel;
        }

        this.pagesPrinted = pagesPrinted;
        this.duplexPrinter = duplexPrinter;
    }
    public void fill(int amount){
        if(tonerLevel < 100){
            tonerLevel = tonerLevel + amount;
        }
    }
    public void print(){
        this.pagesPrinted++;
    }
}
