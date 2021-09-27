package happyHotel;

import java.time.temporal.ChronoUnit;

public class BookingService {

    private final PaymentService paymentService;
    private final RoomService roomService;
    private final BookingDAO bookingDAO;
    private final MailSender mailSender;

    private final static double BASE_PRICE_USD = 50.0;

    public BookingService(PaymentService paymentService, RoomService roomService, BookingDAO bookingDAO, MailSender mailSender){
        super();
        this.paymentService = paymentService;
        this.roomService = roomService;
        this.bookingDAO = bookingDAO;
        this.mailSender = mailSender;
    }


    //and reduce operation for the sum of all places
    //result gives total amount of people able to stay in all rooms
    public int getAvailablePlaceCount(){
        return roomService.getAvailableRooms()
                .stream()//Use stream to get capacity of each rooms
                .map(Room::getCapacity)//for reach room get capacity to find amount of ppl who can stay overnight
                .reduce(0, Integer::sum); //reduce operation to sum of all places and return amount of people able to stay in all rooms
    }

    public double calculatePrice(BookingRequest bookingRequest){
        long nights = ChronoUnit.DAYS.between(bookingRequest.getDateFrom(),bookingRequest.getDateTo());
        return BASE_PRICE_USD * bookingRequest.getGuestCount() * nights;
    }

    public double calculatePriceEuro(BookingRequest bookingRequest){
        long nights = ChronoUnit.DAYS.between(bookingRequest.getDateFrom(),bookingRequest.getDateTo());
        return CurrencyConverter.toEuro(BASE_PRICE_USD * bookingRequest.getGuestCount() * nights);
    }

    public String makeBooking(BookingRequest bookingRequest){
        //Find available room id from booking request and store to variable
        //calculates the price of the booking request
        String roomId = roomService.findAvailableRoomId(bookingRequest);
        double price = calculatePrice(bookingRequest);

        //Check if booking should be paid in advance
        // if true use paymentService dependency, then add roomId to bookingRequest
        if(bookingRequest.isPrepaid()){
            paymentService.pay(bookingRequest, price);
        }
        bookingRequest.setRoomId(roomId);
        String bookingId = bookingDAO.save(bookingRequest); //save booking request room id to  booking Id
        roomService.bookRoom(roomId); //make room unavailable for other booking
        mailSender.sendBookingConfirmation(bookingId); //sending booking information
        return bookingId;
    }

    public void cancelBooking(String id){
        BookingRequest request = bookingDAO.get(id);
        roomService.unbookRoom(request.getRoomId());
        bookingDAO.delete(id);
    }


}
