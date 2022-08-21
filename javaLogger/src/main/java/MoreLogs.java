import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreLogs {

    private static final Logger LOG = LoggerFactory.getLogger(MoreLogs.class);

    public void doStuff(int a){
        if(a > 5){
            LOG.info("Hmmm... A number more than 5");
        } else{
            LOG.info("OOOohhh...A number less than 5");
        }
    }
}
