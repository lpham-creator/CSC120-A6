/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 15;
        this.nSugarPackets = 15;
        this.nCreams = 15;
        this.nCups = 20;
    }
    
    /* Selling coffee method*/
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1) {
            restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restock needed! Please wait a minute.");
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Here's your order! Enjoy.");
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces*10;
        this.nSugarPackets += nSugarPackets*10;
        this.nCreams += nCreams*10;
        this.nCups += nCups*10;
    }

    public static void main(String[] args) {
        Cafe campusCafe = new Cafe("Campus Cafe", "100 Green Street Northampton, MA 01063", 1);
        System.out.println(campusCafe);
        campusCafe.sellCoffee(15, 6, 9);
        campusCafe.sellCoffee(15, 6, 9);
        campusCafe.sellCoffee(15, 6, 9);
    }
    
}
