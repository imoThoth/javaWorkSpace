package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class firstOfTest {

    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup(){

        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock,mailSenderMock);

        System.out.println("List Returned " + roomServiceMock.getAvailableRooms());
        System.out.println("Object Returned " + roomServiceMock.findAvailableRoomId(null));
        System.out.println("Primitive Returned " + roomServiceMock.getRoomCount());
    }

    @Test
    void should_CalculatePrice_With_CorrectInput(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1", LocalDate.of(2021,10,20),
                LocalDate.of(2021,10,24), 2,false);

        double expected = 4 * 2 * 50.0; //expted = nights * ppl * base_amount
        //when
        double actual = bookingService.calculatePrice(bookingRequest);
        //then
        assertEquals(expected,actual);
    }

    //Mockito uses non-strict mocks/stub which ignores call to default method
    //and returns type of the method rather than a strict return  value
    @Test
    void should_GetAvailablePlaceCount(){
        //Uses room service class dependency, by calling get availableRooms method
        //method returns list of all available rooms in hotel
       //returns sum of all places in empty list = 0
        int expected = 0;
        //when
        int actual = bookingService.getAvailablePlaceCount();
        //then
        assertEquals(expected,actual);
    }
}

//Mockito uses nice mocks