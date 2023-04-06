/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Programming three classes that will be used in plotting property by different given informations.
 * Alongside the thre classes three JUnit Test classes will also be written in order to test the code.
 * Due: 04/05/2023
 * Platform/compiler: Windows/Eclipse IDE
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Aiin Khalilzadeh
*/
public class Property {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Default constructor
    public Property() {
        this("", "", 0.0, "");
    }

    // Constructor with required fields
    public Property(String propertyName, String city, double rentAmount, String owner) {
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    // Constructor with all fields
    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    // Copy constructor
    public Property(Property otherProperty) {
        this(otherProperty.getPropertyName(), otherProperty.getCity(), otherProperty.getRentAmount(),
                otherProperty.getOwner(), otherProperty.getPlot().getX(), otherProperty.getPlot().getY(),
                otherProperty.getPlot().getWidth(), otherProperty.getPlot().getDepth());
    }

    // Getter methods
    public String getCity() {
        return city;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    // toString method
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
