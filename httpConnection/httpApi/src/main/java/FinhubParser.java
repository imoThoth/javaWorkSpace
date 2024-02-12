import com.fasterxml.jackson.annotation.JsonProperty;

public class FinhubParser {

    @JsonProperty("c")
    private long[] c;
    @JsonProperty("h")
    private long[] h;
    @JsonProperty("l")
    private long[] l;
    @JsonProperty("o")
    private long[] o;
    @JsonProperty("s")
    private String s;
    @JsonProperty("t")
    private long[] t;
    @JsonProperty("v")
    private long[] v;

    public long[] getC() {
        return this.c;
    }

    public void setC(long[] c) {
        this.c = c;
    }

    public long[] getH() {
        return this.h;
    }

    public void setH(long[] h) {
        this.h = h;
    }

    public long[] getL() {
        return this.l;
    }

    public void setL(long[] l) {
        this.l = l;
    }

    public long[] getO() {
        return this.o;
    }

    public void setO(long[] o) {
        this.o = o;
    }

    public String getS() {
        return this.s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public long[] getT() {
        return this.t;
    }

    public void setT(long[] t) {
        this.t = t;
    }

    public long[] getV() {
        return this.v;
    }

    public void setV(long[] v) {
        this.v = v;
    }
}
