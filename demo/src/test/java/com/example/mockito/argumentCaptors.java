package com.example.mockito;

import happyHotel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class argumentCaptors {
    private BookingService bookingService;
    private PaymentService paymentServiceMock;
    private RoomService roomServiceMock;
    private BookingDAO bookingDAOMock;
    private MailSender mailSenderMock;
    private ArgumentCaptor<Double> doubleArgumentCaptor;

    @BeforeEach
    void setup() {

        this.bookingService = mock(BookingService.class);
        this.paymentServiceMock = mock(PaymentService.class);
        this.roomServiceMock = mock(RoomService.class);
        this.bookingDAOMock = mock(BookingDAO.class);
        this.mailSenderMock = mock(MailSender.class);

        this.bookingService = new BookingService(paymentServiceMock, roomServiceMock,
                bookingDAOMock, mailSenderMock);

        this.doubleArgumentCaptor = ArgumentCaptor.forClass(Double.class);
    }

    @Test
    void should_CaptureArguments_When_MethodCalled(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);

        //when
        bookingService.makeBooking(bookingRequest);
        //then
        verify(paymentServiceMock,times(1)).pay(eq(bookingRequest),doubleArgumentCaptor.capture());
        double captureArgument = doubleArgumentCaptor.getValue();

        assertEquals(400.0, captureArgument);
    }

    @Test
    void should_CaptureArguments_When_MethodCalledMultipleTimes(){
        //given
        BookingRequest bookingRequest = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);

        BookingRequest bookingRequest2 = new BookingRequest("1",
                LocalDate.of(2020,1,1),
                LocalDate.of(2020,1,5), 2, true);

        List<Double> expectedValues = Arrays.asList(400.0,100.0);

        //when
        bookingService.makeBooking(bookingRequest);
        bookingService.makeBooking(bookingRequest2);
        //then
        verify(paymentServiceMock,times(2)).pay(eq(any()),doubleArgumentCaptor.capture());
        List<Double> captureArgument = doubleArgumentCaptor.getAllValues();

        assertEquals(expectedValues, captureArgument);
    }


}
