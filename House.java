/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  // Attributes
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private int nResidents;

  /* Constructor */
  public House(String name, String address, int nFloors, boolean DiningRoom) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = DiningRoom;
  }

  /**
   * Checks if the house has a dining room.
   * @return true if the house has a dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Returns the number of residents in the house.
   * @return the number of residents
   */
  public int nResidents() {
    return nResidents;
  }

  /**
   * Adds a student to the list of residents.
   * @param s the student to be added
   */
  public void moveIn(Student s) {
    residents.add(s);
    nResidents++;
    System.out.println(s.getName() + " has moved in.");
  }

  /**
   * Removes a student from the list of residents.
   * @param s the student to be removed
   * @return the removed student, or null if the student was not a resident
   */
  public Student moveOut(Student s) {
    if (residents.contains(s)) {
      residents.remove(s);
      nResidents--;
      System.out.println(s.getName() + " has moved out.");
      return s;
    } else {
      System.out.println(s.getName() + " is not a resident.");
      return null;
    }
  }

  /**
   * Checks if a student is a resident of the house.
   * @param s the student to check
   * @return true if the student is a resident, false otherwise
   */
  public boolean isResident(Student s) {
    if (residents.contains(s)) {
      return true;
    } else {
      return false;
    }
  }
  public static void main(String[] args) {
    House park = new House("Park House", "134 Elm Street, Northampton MA 01063", 4, false);
    Student kim = new Student("Kimaya", "991445115", 2027);
    park.moveIn(kim);
    if (park.isResident(kim)) {
      System.out.println(kim.getName() + " is a resident of " + park.getName());
    } else {
      System.out.println(kim.getName() + " is not a resident of " + park.getName());
    }
    System.out.println(park);
    System.out.println("Number of residents: " + park.nResidents());
    park.moveOut(kim);
  }

}