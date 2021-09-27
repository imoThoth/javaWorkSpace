package happyHotel;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PaymentService {

    private final Map<String, Double> payments = new HashMap<>();

    public String pay(BookingRequest bookingRequest, double price){
        if(price > 200.0 && bookingRequest.getGuestCount() < 3){
            throw new UnsupportedOperationException("Only Small Payments Supported");
        }
        String id = UUID.randomUUID().toString();
        payments.put(id,price);
        return id;
    }
}
