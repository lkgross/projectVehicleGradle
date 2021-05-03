package bsu.comp152;
/**
 * Automobile.java
 * <p>
 * A class that represents an automobile
 * <p>
 * It is a subclass of Vehicle, so it inherits the fields and methods
 * of Vehicle!
 * <p>
 * It also extends the capabilities of the Vehicle class with more
 * specialized functionality.
 * <p>
 * Note the required syntax "extends Vehicle".
 * <p>
 * Starter code from Computer Science 111, Boston University
 * <p>
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 * <p>
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class Automobile extends Vehicle {

    private int numSeats;
    private boolean isSUV;
    private boolean isMiniVan;

    /**
     * A constructor with five parameters
     * <p>
     * To initialize inherited fields, the constructor must
     * call a constructor from the superclass.
     * <p>
     * It calls the other constructor using the keyword super,
     * followed by appropriate parameters for the superclass constructor.
     * <p>
     * Make the call as the very first line of the constructor
     * (as when one constructor calls another with the reference variable this
     * from within the same class)
     * <p>
     * If we omit the call to super, then the compiler tries to insert a
     * default call to the superclass constructor with no parameters.
     * If there isn't such a constructor, we get a compile-time error.
     */
    public Automobile(String make, String model, int year,
                      int numSeats, boolean isSUV, boolean isMiniVan) {
        super(make, model, year, 4);
        this.numSeats = numSeats;
        this.isSUV = isSUV;
        this.isMiniVan = isMiniVan;
    }

    /**
     * A constructor with three parameters
     */
    public Automobile(String make, String model, int year) {
        super(make, model, year, 4);
        numSeats = 5;
        isSUV = false;
        isMiniVan = false;
    }
    /* Note: Don't try to illegally access inherited private fields.
     * For example, Automobile constructor cannot include
     * this.make = make; this.model = model;
     */

    /*** accessors ***/

    public int getNumSeats() {
        return numSeats;
    }

    public boolean isSUV() {
        return isSUV;
    }

    /**
     * Method to override the toString method inherited from Vehicle.
     * <p>
     * To *override* a method, the new method in the subclass must have the same:
     * name, number and types of parameters, and return type.
     * <p>
     * This constraint is different from method *overloading*.
     * <p>
     * Use @Override to have Java tell you if you accidentally don't use the same
     * name, number and types of parameters, and return type as the inherited method.
     */
    @Override
    public String toString() {
        return getMake() + " " + getModel() + " (" + numSeats + " seats)";
    }
    // What do you notice about method calls and instance variables in this
    // toString method?
    /*
     * Fields defined in Automobile can be accessed directly by methods defined in Automobile. 
     * Fields inherited from Vehicle cannot be accessed directly by methods defined in Automobile.
     */
    /* Note: Don't try to illegally access inherited private fields.
     * For example, the toString method cannot include
     * make + " " + model
     *
     */
    public boolean moreSeats(Automobile other) {
        return numSeats > other.numSeats;
    }
}