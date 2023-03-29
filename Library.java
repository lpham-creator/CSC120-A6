import java.util.Hashtable;
/**
* Constructs a new Library object with no books in its collection.
*/
public class Library extends Building {

  /**
   * The collection of books in the Library, stored as a Hashtable with book titles as keys and availability status as values.
   */
  private Hashtable<String, Boolean> collection;

  /**
   * Constructs a Library object with the specified name, address, and number of floors.
   *
   * @param name the name of the Library
   * @param address the address of the Library
   * @param nFloors the number of floors in the Library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📚");
    this.collection = new Hashtable<String, Boolean>();
  }

  /**
   * Returns true if the given title appears as a key in the Library's collection, false otherwise.
   *
   * @param title the title of the book to search for
   * @return true if the title appears in the collection, false otherwise
   */
  public boolean containsTitle(String title){
    if (this.collection.containsKey(title)){
      return true;
    } else{
      return false;
    }

  } // returns true if the title appears as a key in the Libary's collection, false otherwise

  /**
   * Returns true if the book with the given title is available in the Library, false otherwise.
   *
   * @param title the title of the book to check availability for
   * @return true if the book is available, false otherwise
   */
  public boolean isAvailable(String title){
    if (this.collection.get(title) == true){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * Adds a book's title to the library's collection.
   * 
   * @param title the title of the book to be added
   * @throws RuntimeException if the book is already in the collection
   */
  public void addTitle(String title){
    if (this.containsTitle(title) == true){
      throw new RuntimeException(title + " is already in the collection.");
    }
    else {
      this.collection.put(title, true);
    }
  }
  
  /**
   * Removes a book from the library's collection.
   * 
   * @param title the title of the book to be removed
   * @return the title of the removed book
   * @throws RuntimeException if the book is not in the collection
   */
  public String removeTitle(String title){
    if (this.containsTitle(title) != true){
      throw new RuntimeException(title + " is not in the collection.");
    } else {
      this.collection.remove(title);
      System.out.println("Successfully removed" + title + "from the collection!");
      return title;
    }
  }

  /**
   * Prints the Library's collection of books and their availability status.
   */
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

  /**
   * Checks out the book with the given title from the Library.
   * 
   * @param title the title of the book to be checked out
   * @throws RuntimeException if the book is not in the collection
   */
  public void checkOut(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    }
    else{
    collection.replace(title, false);
    System.out.println("Successfully checked out" + " " + title);
    }
  }

  /**
   * Returns the book with the given title to the Library.
   * 
   * @param title the title of the book to be returned
   * @throws RuntimeException if the book is not in the collection
   */
  public void returnBook(String title) {
    if (this.containsTitle(title) != true) {
      throw new RuntimeException(title + " is not in the collection.");
    }
    else {
    collection.replace(title, true);
    }
  }

  /**
   * Main method for testing the Library class.
   */
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
      Neilson.checkOut("Dracula");
    } catch (Exception e) {
      System.out.println(e); // Out of fuel
    }
    Neilson.checkOut("The Da Vinci Code");
    Neilson.printCollection();

  }
}

