/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        nCoffeeOunces = 100;
        nSugarPackets = 10; 
        nCreams = 10;
        nCups = 10; 
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (size > nCoffeeOunces || nSugarPackets>this.nSugarPackets || nCreams > this.nCreams || nCups <= 0) {
            System.out.println("Need to restock inventory, please wait...");
            restock(1000, 100, 100, 100);
        }
        nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        nCups -= 1;
        System.out.println("Order complete.");
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Inventory restocked.");
    }

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
