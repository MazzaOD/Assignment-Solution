/**
 * CLASS: SOFTWARE IMPLEMENTATION
 * INSTRUCTOR: MARIA BOYLE
 * DESCRIPTION: CLASS BOOKINGTEST - DEVELOPED FOR JUNIT TEST CASE FOR BOOKING CLASS
 * DATE: 12/12/2023
 * @AUTHOR MARY O'DONNELL
 * @VERSION 1.0
 **/
package ie.lyit.testers;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import ie.lyit.flight.Booking;
import ie.lyit.flight.CreditCard;
import ie.lyit.flight.Flight;
import ie.lyit.flight.Name;
import ie.lyit.flight.Passenger;
import ie.lyit.flight.Date;
import ie.lyit.flight.Time;

public class BookingTest {
	private Booking booking;

	@Before
	public void setUp() throws Exception {
		// SET UP A BOOKING INSTANCE WITH SOME INITIAL VALUES
		Flight outboundFlight = new Flight("781DER", "Derry", "London Stanstead", new Date(23, 12, 2021),
				new Time(8, 30), 50.0);
		Flight inboundFlight = new Flight("BR418", "London Stanstead", "Derry", new Date(30, 12, 2018),
				new Time(10, 15), 50.0);
		ArrayList<Passenger> passengers = new ArrayList<>();
		passengers.add(new Passenger());
		// CREATE A BOOKING INSTANCE USING THE PROVIDED VALUES
		booking = new Booking(outboundFlight, inboundFlight, passengers);
	}

	@Test
	public void testBooking() {
		// TEST IF THE BOOKING INSTANCE IS CREATED SUCCESSFULLY
		assertNotNull(booking);
		// TEST IF THE OUTBOUND FLIGHT NUMBER IS SET CORRECTLY
		assertEquals("781DER", booking.getOutbound().getFlightNumber());
		// TEST IF THE INBOUND FLIGHT NUMBER IS SET CORRECTLY
		assertEquals("BR418", booking.getInbound().getFlightNumber());
		// TEST IF THE INITIAL NUMBER OF PASSENGERS IS SET CORRECTLY
		assertEquals(1, booking.getPassengers().size());
	}

	@Test
	public void testOverloadedConstructor() {
		// CREATE TEST DATA
		Flight outboundFlight = new Flight("TEST123", "TestCity1", "TestCity2", new Date(1, 1, 2022), new Time(9, 0),
				60.0);
		Flight inboundFlight = new Flight("TEST456", "TestCity2", "TestCity1", new Date(2, 1, 2022), new Time(15, 30),
				75.0);
		ArrayList<Passenger> passengers = new ArrayList<>();
		//CREATE PASSENGER OBJECT
		Name name = new Name("Mr", "Joe", "Bloggs");
		CreditCard joesCard = new CreditCard(1111222233334444L, new Date(31, 12, 2024), 123);
		Passenger joeBloggs = new Passenger(name, "087 1234567", "joe@gmail.com", 1, false, joesCard);
		
		passengers.add(joeBloggs); // ADD IT TO THE ARRAYLIST

		// Create a Booking instance using the overloaded constructor
		Booking booking = new Booking(outboundFlight, inboundFlight, passengers);

		// Assertions to check if the instance is created correctly
		assertNotNull(booking);
		assertEquals("TEST123", booking.getOutbound().getFlightNumber());
		assertEquals("TEST456", booking.getInbound().getFlightNumber());
		assertEquals(1, booking.getPassengers().size());
		assertEquals(135.0, booking.getTotalPrice(), 0.001); // Adjust the expected value based on your test data
	}

	@Test
	public void testSetOutbound() {
		// CREATE A NEW OUTBOUND FLIGHT FOR TESTING
		Flight newOutboundFlight = new Flight("NEW123", "Derry", "London Stanstead", new Date(1, 1, 2022),
				new Time(12, 0), 75.0);
		// TEST IF THE OUTBOUND FLIGHT CAN BE UPDATED SUCCESSFULLY
		booking.setOutbound(newOutboundFlight);
		assertEquals(newOutboundFlight, booking.getOutbound());
	}

	@Test
	public void testSetInbound() {
		// CREATE A NEW INBOUND FLIGHT FOR TESTING
		Flight newInboundFlight = new Flight("NEW456", "London Stanstead", "Derry", new Date(2, 1, 2022),
				new Time(14, 30), 75.0);
		// TEST IF THE INBOUND FLIGHT CAN BE UPDATED SUCCESSFULLY
		booking.setInbound(newInboundFlight);
		assertEquals(newInboundFlight, booking.getInbound());
	}

	@Test
	public void testSetPassengers() {
		// CREATE A NEW LIST OF PASSENGERS FOR TESTING
		ArrayList<Passenger> newPassengers = new ArrayList<>();
		newPassengers.add(new Passenger());
		newPassengers.add(new Passenger());
		// TEST IF THE LIST OF PASSENGERS CAN BE UPDATED SUCCESSFULLY
		booking.setPassengers(newPassengers);
		assertEquals(newPassengers, booking.getPassengers());
	}

	// TEST SETPASSENGERS METHOD WITH AN EMPTY ARRAYLIST (EXPECTING ILLEGALARGUMENTEXCEPTION)
	@Test(expected = IllegalArgumentException.class)
	public void testSetPassengersWithEmptyList() {
		booking.setPassengers(new ArrayList<>());
	}

	// TEST SETPASSENGERS METHOD WITH TOO MANY PASSENGERS (EXPECTING ILLEGALARGUMENTEXCEPTION)
	@Test(expected = IllegalArgumentException.class)
	public void testSetPassengersWithTooManyPassengers() {
		ArrayList<Passenger> tooManyPassengers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			tooManyPassengers.add(new Passenger());
		}
		booking.setPassengers(tooManyPassengers);
	}
}
