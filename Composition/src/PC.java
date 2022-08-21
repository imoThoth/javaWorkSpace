// ultimate composition
// the pc has a case, has a monitor, has a motherboard

public class PC {

    private Case pcCase;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case pcCase, Monitor monitor, Motherboard motherboard) {
        this.pcCase = pcCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        pcCase.pressPowerButton();
        drawLogo();
    }

    public void drawLogo(){
        monitor.drawPixelAt(20, 20, "Orange");
    }

    public Case getPcCase() {
        return pcCase;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }
}
