/**
 * The Building class represents a generic building with a name, address, and number of floors.
*/
public class Building {

    /**
     * The name of the building.
     */
    private String name = "<Name Unknown>";
    /**
     * The address of the building.
     */
    private String address = "<Address Unknown>";
    /**
     * The number of floors of the building.
     */
    private int nFloors = 1;

    /**
     * Creates a new Building object with the specified name, address, and number of floors.
     * @param name the name of the building
     * @param address the address of the building
     * @param nFloors the number of floors in the building
     * @throws RuntimeException if nFloors is less than 1
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * Returns the name of the building.
     * @return the name of the building
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the address of the building.
     * @return the address of the building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Returns the number of floors in the building.
     * @return the number of floors in the building
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * Returns a string representation of the building, including its name, number of floors, and address.
     * @return a string representation of the building
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
    * Main method for testing the Building class.
    */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}