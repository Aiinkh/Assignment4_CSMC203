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
public class ManagementCompany {
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    private String name;
    private String taxID;
    private double mgmFee;
    private Property[] properties;
    private Plot plot;

    public ManagementCompany() {
        this("", "", 0.0);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFee = mgmFee;
        this.properties = new Property[MAX_PROPERTY];
        this.plot = new Plot(x, y, width, depth);
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.getName(), otherCompany.getTaxID(), otherCompany.getMgmFeePer(), 
             otherCompany.getPlot().getX(), otherCompany.getPlot().getY(), 
             otherCompany.getPlot().getWidth(), otherCompany.getPlot().getDepth());

        Property[] otherProps = otherCompany.getProperties();
        for (int i = 0; i < otherProps.length; i++) {
            if (otherProps[i] != null) {
                this.properties[i] = new Property(otherProps[i]);
            }
        }
    }

    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (property == null) {
            return -2;
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] == null) {
                properties[i] = property;
                return i;
            }
        }

        return -1;
    }

    public void removeLastProperty() {
        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i] != null) {
                properties[i] = null;
                break;
            }
        }
    }

    public Property getHighestRentPropperty() {
        double maxRent = Double.MIN_VALUE;
        Property maxProp = null;

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null && properties[i].getRentAmount() > maxRent) {
                maxRent = properties[i].getRentAmount();
                maxProp = properties[i];
            }
        }

        return maxProp;
    }

    public double getMgmFeePer() {
        return mgmFee;
    }

    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
    	return properties;
    }
    public String getTaxID() {
        return taxID;
    }

    public double getTotalRent() {
        double totalRent = 0.0;

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                totalRent += properties[i].getRentAmount();
            }
        }

        return totalRent;
    }

    public String maxRentPropToString() {
        Property maxProp = getHighestRentPropperty();

        if (maxProp == null) {
            return "No properties found";
        }

        return maxProp.toString();
    }

    public String toString() {
        String output = "List of the properties for " + name + ", taxID: " + taxID + "\n";
        output += "__________________________________________________\n";

        for (int i = 0; i < properties.length; i++) {
            if (properties[i] != null) {
                output += properties[i].toString() + "\n";
                output += "__________________________________________________\n";
            }
        }

        output += "Total management Fee: " + String.format("%.2f", getTotalRent() * (mgmFee / 100)) + "\n";

        return output;
    }
   }
    
