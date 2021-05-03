package bsu.comp152;

/**
 * Truck.java
 * <p>
 * A class that represents a truck.
 * <p>
 * It is a subclass of Vehicle and a superclass of other classes that represent trucks
 * (for now, just TractorTrailer).
 * <p>
 * It inherits many of its fields and methods from Vehicle.
 * <p>
 * Fields and methods that all trucks have in common are defined
 * here so that they can be inherited by the subclasses of this class.
 * <p>
 * Starter code from Computer Science 111, Boston University
 * <p>
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 * <p>
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class Truck extends Vehicle {

    private int capacity;

    /**
     * make, model, etc. are inherited from Vehicle
     **/

    public Truck(String make, String model, int year, int numWheels) {
        // invoke the Vehicle constructor to initialize
        // the fields inherited form Vehicle
        super(make, model, year, numWheels);

        // default value, which can be changed using setCapacity.
        capacity = 0;
    }

    /*** accessors ***/
    /**
     * getMake(), getModel(), etc. are inherited from Vehicle.
     **/

    public int getCapacity() {
        return capacity;
    }

    /*
    * Q: Where should you define a method, for example the getNumAxles method?
    * A: We are interested in the number of axles for trucks.
    * Define the getNumAxles method in the Truck class, rather than in the Vehicle class.
    */
    public int getNumAxles() {
        // We need to invoke getNumWheels(),
        // because numWheels is a private instance
        // variable of the superclass.
        return getNumWheels() / 2;
    }

    /*** mutators ***/
    /**
     * setMileage and setPlateNumber are inherited from Vehicle.
     **/

    public void setCapacity(int c) {
        capacity = c;
    }

    /*
     * Creates a string that can be used when printing
     * a Truck object.  This method overrides the
     * toString() method inherited from the Vehicle class.
     *
     * The method will be inherited by subclasses of Truck.
     * It won't be available to non-truck subclasses of Vehicle.
     */
    @Override
    public String toString() {
        // Call the Vehicle version of this method
        // to get a string containing the make and model.
        String str = super.toString();

        // Add information about the capacity.
        str += ", capacity = " + capacity;
        return str;
    }
}
