/* This is a stub for the House class */
import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private int nResidents;

  public House(String name, String address, int nFloors, boolean DiningRoom) {
    super(name, address, nFloors);
    System.out.println("You have built a house: 🏠");
    residents = new ArrayList<Student>();
    hasDiningRoom = DiningRoom;
  }

  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  public int nResidents() {
    return nResidents;
  }

  public void moveIn(Student s) {
    residents.add(s);
    nResidents++;
    System.out.println(s.getName() + " has moved in.");
  }

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