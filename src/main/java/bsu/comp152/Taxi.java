package bsu.comp152;

/**
 * Taxi.java
 * <p>
 * A class that represents a taxi---a subclass of Automobile
 * <p>
 * It inherits fields and methods from Automobile:
 * We don't redefine the fields and methods from Automobile in the Taxi class.
 * <p>
 *
 * Starter code from Computer Science 111, Boston University
 * <p>
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 * <p>
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class Taxi extends Automobile {

    private String taxiID; // the ID number for the taxi
    private double fareTotal; // the amount of money the driver has collected in fares
    private int numFares; // the number of rides the driver has provided

    public Taxi(String make, String model, int year, int numSeats, boolean isSUV, boolean isMiniVan, String id) {
        // Invoke the Automobile constructor to initialize
        // the fields inherited from Automobile.
        super(make, model, year, numSeats, isSUV, isMiniVan);
        taxiID = id;
        // Instance variables fareTotal and numFares are not mentioned.
        // They will be set to 0.0 and 0 by default, respectively.
    }

    /*
    Instance methods are inherited from Automobile.
    Instance methods are inherited from Vehicle.
    Also, we define instance methods that are especially for Taxi objects here.
    */

    /*** mutators ***/

    public void setID(String id) {
        taxiID = id;
    }

    public void addFare(double fare) {
        if (fare <= 0) {
            throw new IllegalArgumentException("Argument to addFare must be positive.");
        }
        fareTotal += fare;
        numFares++;
    }

    public void resetFareInfo() {
        fareTotal = 0;
        numFares = 0;
    }

    /*** accessors ***/

    public String getID() {
        return taxiID;
    }

    public double getFareTotal() {
        return fareTotal;
    }

    public int getNumFares() {
        return numFares;
    }

    public double getAverageFare() {
        if (numFares == 0) {
            System.out.println("no fares collected");
            return 0.0;
        }
        return fareTotal / numFares;
    }

    /*
    The instance method toString is used to print a Taxi object.
    This method overrides the toString() method inherited from the Automobile class.
    */

    /*
    A subclass can override an inherited method, replacing it with its own version.

    To override a method, the new method must have the same:
            - name
            - number and types of parameters
            - return type

    (Note these requirements are different from method overloading, such as constructor overloading.)
    */

    @Override
    public String toString() {
        return "Taxi (id = " + taxiID + ")";
    }

    @Override
    public int getNumSeats(){
        return super.getNumSeats() - 1;
    }

}

