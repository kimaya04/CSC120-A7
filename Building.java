public class Building implements BuildingRequirements {

    // Attributes
    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    /* Constructor */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /* Getter
    *Used to access the name of the building
    * @return String name of the building
    */
    public String getName() {
        return this.name;
    }

    /* Getter
    *Used to access the address of the building
    * @return String address of the building
    */
    public String getAddress() {
        return this.address;
    }

    /* Getter
    *Used to access the number of floors of the building
    * @return int number of floors
    */
    public int getFloors() {
        return this.nFloors;
    }

    /* Converts building information into a string
     * Used to print out the building information
     * @return String representation of the building
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
