/**
 * CLASS: SOFTWARE IMPLEMENTATION
 * INSTRUCTOR: MARIA BOYLE
 * DESCRIPTION: CLASS BOOKING - DEVELOPED FOR THE FLIGHT BOOKING SYSTEM
 * DATE: 12/12/2023
 * @AUTHOR MARY O'DONNELL
 * @VERSION 1.0
 **/
package ie.lyit.flight;

import java.util.ArrayList;

public class Booking {
	private Flight outbound;
	private Flight inbound;
	private ArrayList<Passenger> passengers;
	private double totalPrice;
	private int bookingNo;
	private static int nextUniqueBookingNumber = 10000;

	// CONSTRUCTOR FOR CREATING A BOOKING INSTANCE
	public Booking(Flight outbound, Flight inbound, ArrayList<Passenger> passengers) {
		// VALIDATE PARAMETERS TO ENSURE THEY MEET BOOKING CRITERIA
		if (outbound == null || passengers.isEmpty() || passengers.size() > 9) {
			throw new IllegalArgumentException("Invalid parameters for booking");
		}
		// INITIALIZE INSTANCE VARIABLES
		this.outbound = outbound;
		this.inbound = inbound;
		this.passengers = passengers;
		this.bookingNo = nextUniqueBookingNumber++;
		this.totalPrice = calculatePrice();
	}

	// GETTER FOR THE OUTBOUND FLIGHT
	public Flight getOutbound() {
		return outbound;
	}

	// SETTER FOR THE OUTBOUND FLIGHT
	public void setOutbound(Flight outbound) {
		// VALIDATE THAT THE OUTBOUND FLIGHT IS NOT NULL
		if (outbound == null) {
			throw new IllegalArgumentException("Outbound flight cannot be null");
		}
		this.outbound = outbound;
		// RECALCULATE AND UPDATE THE TOTAL PRICE
		setTotalPrice(calculatePrice());
	}

	// GETTER FOR THE INBOUND FLIGHT
	public Flight getInbound() {
		return inbound;
	}

	// SETTER FOR THE INBOUND FLIGHT
	public void setInbound(Flight inbound) {
		this.inbound = inbound;
		// RECALCULATE AND UPDATE THE TOTAL PRICE
		setTotalPrice(calculatePrice());
	}

	// GETTER FOR THE LIST OF PASSENGERS
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	// SETTER FOR THE LIST OF PASSENGERS
	public void setPassengers(ArrayList<Passenger> passengers) {
		// VALIDATE THE NUMBER OF PASSENGERS
		if (passengers.isEmpty() || passengers.size() > 9) {
			throw new IllegalArgumentException("Invalid number of passengers");
		}
		this.passengers = passengers;
		// RECALCULATE AND UPDATE THE TOTAL PRICE
		setTotalPrice(calculatePrice());
	}

	// GETTER FOR THE TOTAL PRICE
	public double getTotalPrice() {
		return totalPrice;
	}

	// SETTER FOR THE TOTAL PRICE
	private void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	// GETTER FOR THE BOOKING NUMBER
	public int getBookingNo() {
		return bookingNo;
	}

	// METHOD TO FIND A PASSENGER IN THE LIST
	public boolean findPassenger(Passenger p) {
		return passengers.contains(p);
	}

	// METHOD TO CALCULATE THE TOTAL PRICE OF THE BOOKING
	public double calculatePrice() {
		double price = outbound.getPrice();
		if (inbound != null) {
			price += inbound.getPrice();
		}
		return price * passengers.size();
	}

	// OVERRIDE OF THE TOSTRING METHOD FOR A CUSTOM STRING REPRESENTATION
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("BOOKING NUMBER ").append(bookingNo).append("\n");
		result.append("OUTBOUND FLIGHT ").append(outbound).append("\n");
		if (inbound != null) {
			result.append("INBOUND FLIGHT ").append(inbound).append("\n");
		}
		result.append("PASSENGERS ").append(passengers).append("\n");
		result.append("TOTAL PRICE €").append(String.format("%.2f", totalPrice)).append("\n");
		return result.toString();
	}

	// OVERRIDE OF THE EQUALS METHOD TO COMPARE BOOKING OBJECTS BASED ON BOOKING NUMBER
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Booking booking = (Booking) obj;
		return bookingNo == booking.bookingNo;
	}

	
}
