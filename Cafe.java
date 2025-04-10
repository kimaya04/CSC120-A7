/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    // Attributes
    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /* Constructor */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        nCoffeeOunces = 100;
        nSugarPackets = 10; 
        nCreams = 10;
        nCups = 10; 
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells coffee to a customer.
     * Checks inventory and restocks first if necessary.
     * Reduces inventory stock according to order specifications.
     * @param size the size of the coffee in ounces
     * @param nSugarPackets the number of sugar packets
     * @param nCreams the number of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size > nCoffeeOunces || nSugarPackets>this.nSugarPackets || nCreams > this.nCreams || nCups <= 0) {
            System.out.println("Need to restock inventory, please wait...");
            restock(100, 10, 10, 10);
        }
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        nCups -= 1;
        System.out.println("Order complete.");
    }

    /**
     * Restocks the cafe inventory.
     * @param nCoffeeOunces the number of coffee ounces to add
     * @param nSugarPackets the number of sugar packets to add
     * @param nCreams the number of creams to add
     * @param nCups the number of cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Inventory restocked.");
    }

    /**
     * Converts the cafe object to a string representation.
     * @return the string representation of the cafe information
     */
    public String toString() {
        return super.toString() + " The cafe has " + nCoffeeOunces + " ounces of coffee, " + nSugarPackets + " sugar packets, " + nCreams + " creams, and " + nCups + " cups.";
    }
    
    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "7 Neilson Drive, Northampton MA 01063", 1);
        System.out.println(compass);
        compass.sellCoffee(8, 2, 10);
        compass.sellCoffee(15, 2, 5);

    }
    
}
