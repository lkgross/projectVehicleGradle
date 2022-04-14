package bsu.comp152;

/**
 * FleetDemo.java
 * <p>
 * A class that illustrates concepts related to polymorphism.
 * <p>
 * Starter code from Computer Science 111, Boston University
 * <p>
 * Modified by Laura K. Gross, COMP 152, Bridgewater State University
 * <p>
 * Completed by: [student name], [student email]
 * date: [date of completion]
 */
public class FleetDemo {

    public static final int CURRENT_YEAR = 2022;

    public static void main(String[] args) {

        /* Polymorphism means "many forms".
         * An object that can pass more than one is-a test can be considered polymorphic.
         * Example: A TractorTrailer object is-a Truck; A TractorTrailer is-a Vehicle.
         * And, of course, a TractorTrailer is-a TractorTrailer.
         * That is, a child class object can take any form of a class in its
         * parent hierarchy and of course itself as well [medium.com].
         */

        /* Polymorphism is useful when we have a collection of objects of
         * different but related types.
         */

        // Consider an array of objects of different but related types.
        Vehicle[] fleet = new Vehicle[4];
        /* Remember all elements in an array in Java must have the same declared type.
         * Here all elements of the array are of declared type Vehicle.
         * Each element has a different "declared type" vs. "actual type."
         * Declared type is specified when declaring a variable.
         * Actual type is specified when creating an object.
         */
        fleet[0] = new Automobile("Honda", "Civic", 2016);
        fleet[1] = new Motorcycle("Harley", "Roadster", 2017);
        fleet[2] = new TractorTrailer("Mack", "Pinnacle DayCab", 2018, 10);
        fleet[3] = new Taxi("Toyota", "Highlander Hybrid", 2016,
                8, true, false, "A12345");

        /*
         * When we call a method on an object,
         * - the COMPILER will check whether the class for the DECLARED type of the object
         *   defines the method
         * - if the class for the DECLARED type of the object DOES define the method,
         *   the JVM will call the method as is most appropriate for the ACTUAL type
         *   of the object.
         */

        for (int i = 0; i < fleet.length; i++) {
            // Implicitly call the toString method on the ith element of the fleet.
            System.out.println(fleet[i].toString());
            /*
             * We can do this because the COMPILER checks for the DECLARED type
             * of each element (Vehicle) confirms that Vehicle has a toString method.
             *
             * At runtime, the Java INTERPRETER selects the version of toString
             * that is appropriate to the ACTUAL type of the object---
             * either from the class of the declared type Vehicle
             * or from the class of the actual type in which toString is overridden.
             * This is known selection process is called dynamic binding.
             * It can be done by the JVM, not by the compiler.
             */

            /*
             * System.out.println(fleet[0]); # invokes the toString method in Automobile, which overrides
             * the toString method in Vehicle.
             * System.out.println(fleet[1]); # invokes the toString method in Vehicle,
             * which is inherited by Motorcycle.  (Motorcycle does not define its own toString method.)
             * System.out.println(fleet[2]); # invokes the toString method in TractorTrailer, which overrides
             * the toString method in Truck, which overrides the toString method in Vehicle.
             * System.out.println(fleet[3]); # invokes the toString method in Taxi, which overrides
             * the toString method in Automobile, which overrides the toString method in Vehicle.
             */
        }

        System.out.println();
        averageAge(fleet);
        System.out.println();

        // TODO: (1) Answer why doesn't this work:
        // System.out.println(fleet[2].getNumAxles());
        /* This doesn't work because the COMPILER finds that the class (Vehicle)
         * for the DECLARED type (Vehicle)
         * of the object (fleet[2]) does NOT define the method (getNumAxles).
         */

        /*
         * We can use CASTING to create a reference with the necessary DECLARED type.
         * THE ACTUAL TYPE REMAINS TractorTrailer.
         */
        Truck truck1 = (Truck) fleet[2];

        // TODO: (2) Answer which version of getNumAxles() will be invoked? Why?
        System.out.println("Number of axles on " + truck1.toString() + ":");
        System.out.println(truck1.getNumAxles());
        System.out.println();
        /*
        For truck1.getNumAxles(), the COMPILER found that the class (Truck) for the DECLARED type
        (Truck) of the object truck1 does define the method (getNumAxles).
        The JVM calls the method that is most appropriate for the ACTUAL type (TractorTrailer)
        of the object.

        For truck1.toString(), the COMPILER found that the class (Truck) for the DECLARED type
        (Truck) of the object truck1 does define the method (toString).
        The JVM calls the method that is most appropriate for the ACTUAL type (TractorTrailer)
        of the object.
        */
        // TODO: (3) Determine whether this code will work. Explain the code performance.
        TractorTrailer big = (TractorTrailer) fleet[2];
        System.out.println(big.getNumAxles());
        // The declared type of big is TractorTrailer.
        // The compiler confirmed that the TractorTrailer class defines a getNumAxles method.
        // The actual type of big is TractorTrailer.
        // The JVM calls the getNumAxles method from the TractorTrailer class.
        /*
         * The Object class is a superclass of all other classes.
         * Thus, we can use an Object variable to store a reference to any object.
         */
        Object obj1;
        obj1 = new Taxi("Ford", "Tempo", 2000, 4, false, false, "T47783");
        // TODO: (4) Determine what is the declared type of obj1?  What is its actual type?
        //  Which toString method will be called? Why?
        System.out.println(obj1.toString());
        // The declared type of obj1 is Object.
        // The COMPILER confirms that the class for the DECLARED type of the object (Object)
        // defines the toString method.
        // The actual type of obj1 is Taxi.
        // The JVM calls the method that is most appropriate for the ACTUAL type (Taxi) of the
        // object.  It calls the toString method from the Taxi class.

        Truck t1;
        t1 = new Truck("Mack", "Pinnacle Day Cab", 2016, 10);
        Truck t2;
        t2 = new TractorTrailer("Mack", "Pinnacle Day Cab", 2016, 10);
        // TODO: (5) Determine the declared and actual types of t1 and t2.
        //  The methods are executed from which classes when the following code is executed? Explain the reasons.
        System.out.println(t1.getNumAxles());
        // The declared type of t1 is Truck.
        // The COMPILER confirms that the class for the DECLARED type of the object (Truck)
        // defines the getNumAxles method.
        // The actual type of t1 is Truck.
        // The JVM calls the method that is most appropriate for the ACTUAL type (Truck) of the
        // object.  It calls the getNumAxles method from the Truck class.
        // The declared type of t2 is Truck.
        // The COMPILER confirms that the class for the DECLARED type of the object (Truck)
        // defines the getNumAxles method.
        // The actual type of t2 is TractorTrailer.
        // The JVM calls the method that is most appropriate for the ACTUAL type (TractorTrailer) of the
        // object.  It calls the getNumAxles method from the TractorTrailer class.
        System.out.println(t2.getNumAxles());
    }

    /*
     * A method to determine the average age of the vehicles in the fleet
     */

    public static void averageAge(Vehicle[] vehicleArray) {
        int totalAge = 0;
        for (int i = 0; i < vehicleArray.length; i++) {
            // Every subclass inherits the getYear method from the Vehicle class.
            int age = CURRENT_YEAR - vehicleArray[i].getYear();
            totalAge += age;
            /*
             * Note: At runtime, the Java *interpreter* selects the version of a method
             * that is appropriate to the *actual type* of the object.
             * This is known as dynamic binding.
             * This can be done by the JVM not by the compiler.
             * As such, what methods are called in averageAge?
             */
        }
        System.out.println("Average fleet age: " + (double) totalAge / vehicleArray.length);
    }

}
