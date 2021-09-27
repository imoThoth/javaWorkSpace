package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class totallySpies {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup() {


        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = spy(BookingDAO.class);
        //this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);

    }
    /**
     * Mocks vs Spys
     * mock = dummy object imitating an actual object
     * mocks: when(mock.method).thenReturn()
     * spy=real object with logic that can be modified
     * spies: doReturn().when(spy).method()
     * *Spies are also known as partial mocks
     * */

    @Test
    void should_MakeBooking_When_InputOk() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);


        //when
        String bookingId = bookingService.makeBooking(bookingRequest);
        //then
        verify(bookingDAOMock).save(bookingRequest);
        System.out.println("bookingId: "+ bookingId);
    }

    @Test
    void should_CancelBooking_When_InputOk() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);
        bookingRequest.setRoomId("1.3");
        String bookingId = "1";

        doReturn(bookingRequest)
                .when(bookingDAOMock).get(bookingId);
        //when
       bookingService.cancelBooking(bookingId);


    }

}
