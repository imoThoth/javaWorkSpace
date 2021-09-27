package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatcher.*;
import static org.mockito.Mockito.mock;

public class verifyingBehaviours {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;

    @BeforeEach
    void setup() {

        this.bookingService = mock(BookingService.class);
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);

    }

    @Test
    void should_invoke_paymentWhenPrepaid() {
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);


        //when
        bookingService.makeBooking(bookingRequest);
        //then
        verify(paymentServiceMock, times(1)).pay(bookingRequest, 400.0);
        verifyNoInteractions(paymentServiceMock);//checks method not invoked mored than times specified
    }

    @Test
    void should_notInvokePayment_WhenNotPrePaid(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, false);

        //when
        bookingService.makeBooking(bookingRequest);
        //then
        verify(paymentServiceMock,never()).pay(any(),anyDouble());

    }

}
