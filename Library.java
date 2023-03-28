import java.util.Hashtable;
/* This is a stub for the Library class */
public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📚");
    this.collection = new Hashtable<String, Boolean>();
  }

  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    } else{
      return false;
    }

  } // returns true if the title appears as a key in the Libary's collection, false otherwise

  public boolean isAvailable(String title){
    if (this.collection.get(title) == true){
      return true;
    }
    else{
      return false;
    }
  }

  public void addTitle(String title){
    if (this.containsTitle(title) == true){
      throw new RuntimeException(title + " is already in the collection.");
    }
    else {
      this.collection.put(title, true);
    }
  }
  
  public String removeTitle(String title){
    if (this.containsTitle(title) != true){
      throw new RuntimeException(title + " is not in the collection.");
    } else {
      this.collection.remove(title);
      System.out.println("Successfully removed" + title + "from the collection!");
      return title;
    }
  }

  public void printCollection() {
    System.out.println("Library collection:");
    if (this.collection.isEmpty()){
      System.out.println("There's no book in this collection yet.");
    }
    else {
    for (String title : collection.keySet()) {
        Boolean status = collection.get(title);
        String availability = (status == null ? "unknown" : (status ? "available" : "checked out"));
        System.out.println("- " + title + " (" + availability + ")");
    }
  }
}

  public void checkOut(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    }
    else{
    collection.replace(title, false);
    System.out.println("Successfully checked out" + " " + title);
    }
  }

  public void returnBook(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    }
    else {
    collection.replace(title, true);
    }
  }

  public static void main(String[] args) {
    Library Neilson = new Library("Neilson Library", "100 Green Street Northampton, MA 01063", 4);
    System.out.println(Neilson);
    Neilson.printCollection();
    Neilson.addTitle("Gone With The Wind");
    Neilson.addTitle("1984");
    Neilson.addTitle("The Great Gatsby");
    Neilson.addTitle("The Hobbit");
    Neilson.addTitle("The Da Vinci Code");
    Neilson.printCollection();
    try {
      Neilson.checkOut("ABCD");
    } catch (Exception e) {
      System.out.println(e); // Out of fuel
    }
    Neilson.checkOut("The Da Vinci Code");
    Neilson.printCollection();

  }
}

