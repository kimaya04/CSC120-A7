/* This is a stub for the Library class */
import java.util.ArrayList;
import java.util.Hashtable;

public class Library extends Building implements LibraryRequirements {

  private Hashtable<String, Boolean> collection;


    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    public void addTitle(String title) {
      if (title != null) {
        if (!this.containsTitle(title)) {
          collection.put(title, true);
          System.out.println("Added " + title + " to the collection.");
        } else {
          System.out.println(title + " is already in the collection.");
        }
      }
    }

    public String removeTitle(String title) {
      if (title != null) {
        if (this.containsTitle(title)) {
          collection.remove(title);
          return title;
        }
      }
      System.out.println("Title is either null or not in the collection.");
      return null;
    }

    public void checkOut(String title) {
      if (this.containsTitle(title)) {
        collection.replace(title, false);
        System.out.println("Checked out " + title + ".");
      } else {
        System.out.println("Title is either null or not in the collection.");
      }
    }

    public void returnBook(String title) {
      if (this.containsTitle(title)) {
        collection.replace(title, true);
        System.out.println("Returned " + title + ".");
      } else {
        System.out.println("Title is either null or not in the collection.");
      }
    }

    // returns true if the title appears as a key in the Libary's collection, false otherwise
    public boolean containsTitle(String title) {
      if (title != null) {
        return collection.containsKey(title);
      }
      return false;
    } 

    // returns true if the title is currently available, false otherwise
    public boolean isAvailable(String title) {
      if (title != null) {
        if (collection.containsKey(title)) {
          return collection.get(title);
        }
      }
      return false;
    }

    // prints out the entire collection in an easy-to-read way (including checkout status)
    public void printCollection() {
      System.out.println("Library Collection:");
      String status = "";
      for (String title : collection.keySet()) {
        if (collection.get(title)) {
          status = "Available";
        }
        else {
          status = "Checked Out";
        }
        System.out.println("- " + title + ": " + status);
      }
    }
  
    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "7 Neilson Drive, Northampton MA 01063", 4);
      ArrayList<String> titles = new ArrayList<String>();
      titles.add("The Great Gatsby");
      titles.add("To Kill a Mockingbird");
      titles.add("1984");
      titles.add("Pride and Prejudice"); 
      titles.add("The Catcher in the Rye");
      for (String title : titles) {
        neilson.addTitle(title);
      }
      neilson.printCollection();
    }
  
  }