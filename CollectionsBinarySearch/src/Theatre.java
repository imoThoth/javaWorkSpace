import java.util.*;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new LinkedList<Seat>();


    public Theatre(String theatreName, int numRows, int seatsPerRows) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows -1);

        for(char row = 'A'; row <= lastRow; row++){
            for(int seatNum = 1; seatNum < seatsPerRows; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        };
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if(foundSeat > 0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

//        int i = 0;
//        for(Seat seat: seats){
//            System.out.println("....");
//            System.out.println("i" + ++i);
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if(requestedSeat == null){
//            System.out.println("There are no seats available");
//            return false;
//        }
//        return requestedSeat.reserve();
    }

    //Testing
    public void getSeats(){
        for(Seat seat: seats){
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " is reserved");
                return true;
            }else{
                return false;
            }
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.seatNumber);
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            }else{
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }
}


