/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Payable Interface
 * Date: 12/12/2023
 * @author Mary O'Donnell
 * @version 1.0
**/
package ie.lyit.flight;

public interface Payable {
	public abstract double calculatePay(double taxPercentage);
	// Don't have to put in public abstract
	double incrementSalary(double incrementAmount);
}

// A Java interface can contain only abstract 
// methods, i.e. methods without a body, & constants
// It describes WHAT an implementing class will do,
// not HOW it will do it.