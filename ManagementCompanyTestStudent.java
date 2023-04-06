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
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {

    private ManagementCompany mgmtCo;

    @Before
    public void setUp() throws Exception {
        mgmtCo = new ManagementCompany("Test Co", "1234", 10.0);
    }

    @Test
    public void testAddProperty() {
        // Add a property that is within the management company's plot
        int result = mgmtCo.addProperty("Test Property", "Test City", 1000.0, "Test Owner", 0, 0, 5, 5);
        assertEquals(0, result);

        // Add a property that is outside the management company's plot
        result = mgmtCo.addProperty("Test Property 2", "Test City 2", 2000.0, "Test Owner 2", 20, 20, 5, 5);
        assertEquals(-3, result);

        // Add more properties than the maximum allowed
        mgmtCo.addProperty("Test Property 3", "Test City 3", 3000.0, "Test Owner 3", 1, 1, 5, 5);
        mgmtCo.addProperty("Test Property 4", "Test City 4", 4000.0, "Test Owner 4", 2, 2, 5, 5);
        mgmtCo.addProperty("Test Property 5", "Test City 5", 5000.0, "Test Owner 5", 3, 3, 5, 5);
        mgmtCo.addProperty("Test Property 6", "Test City 6", 6000.0, "Test Owner 6", 4, 4, 5, 5);
        result = mgmtCo.addProperty("Test Property 7", "Test City 7", 7000.0, "Test Owner 7", 5, 5, 5, 5);
        assertEquals(-1, result);
    }

    @Test
    public void testRemoveLastProperty() {
        // Add a property to remove later
        mgmtCo.addProperty("Test Property", "Test City", 1000.0, "Test Owner", 0, 0, 5, 5);

        // Remove the property
        mgmtCo.removeLastProperty();
        Property[] props = mgmtCo.getProperties();
        assertNull(props[0]);
    }

    @Test
    public void testGetHighestRentProperty() {
        // Add multiple properties, with different rent amounts
        mgmtCo.addProperty("Low Rent", "Test City", 1000.0, "Test Owner", 0, 0, 5, 5);
        mgmtCo.addProperty("Medium Rent", "Test City", 2000.0, "Test Owner", 0, 0, 5, 5);
        mgmtCo.addProperty("High Rent", "Test City", 3000.0, "Test Owner", 0, 0, 5, 5);

        // Check that getHighestRentPropperty returns the property with the highest rent
        Property maxRentProp = mgmtCo.getHighestRentPropperty();
        assertEquals("High Rent", maxRentProp.getPropertyName());
    }

    @Test
    public void testGetTotalRent() {
        // Add multiple properties, with different rent amounts
        mgmtCo.addProperty("Low Rent", "Test City", 1000.0, "Test Owner", 0, 0, 5, 5);
        mgmtCo.addProperty("Medium Rent", "Test City", 2000.0, "Test Owner", 0, 0, 5, 5);
        mgmtCo.addProperty("High Rent", "Test City", 3000.0, "Test Owner", 0, 0, 5, 5);
        // Check that getTotalRent returns the sum of all property rents
        double totalRent = mgmtCo.getTotalRent();
        assertEquals(6000.0, totalRent, 0.001);
    }
}

