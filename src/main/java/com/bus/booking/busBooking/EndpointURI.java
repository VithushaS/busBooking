package com.bus.booking.busBooking;

public final class EndpointURI {

    public static final String BASE_API_PATH="/api/";
    public static final String ID="/{id}";

    public static final String BUS_DETAILS= BASE_API_PATH+"bus";
    public static final String BUSES = BASE_API_PATH + "buses";
    public static final String BUS_BYID = BASE_API_PATH+ "bus"+ID;
    public static final String BUS_BOOKING = BASE_API_PATH + "booking";
    public static final String CANCELL_BOOKING = BUS_BOOKING + ID;
    public static final String  ALL_BOOKINGS = BASE_API_PATH + "allBookings";
}
