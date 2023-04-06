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
import org.junit.Test;
import static org.junit.Assert.*;

public class PropertyTestStudent {

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount(), 0.001);
        assertEquals("", p.getOwner());
        assertEquals(0, p.getPlot().getX());
        assertEquals(0, p.getPlot().getY());
        assertEquals(1, p.getPlot().getWidth());
        assertEquals(1, p.getPlot().getDepth());
    }

    @Test
    public void testConstructorWithRequiredFields() {
        Property p = new Property("Belmar", "Silver Spring", 1200.0, "John Smith");
        assertEquals("Belmar", p.getPropertyName());
        assertEquals("Silver Spring", p.getCity());
        assertEquals(1200.0, p.getRentAmount(), 0.001);
        assertEquals("John Smith", p.getOwner());
        assertEquals(0, p.getPlot().getX());
        assertEquals(0, p.getPlot().getY());
        assertEquals(1, p.getPlot().getWidth());
        assertEquals(1, p.getPlot().getDepth());
    }

    @Test
    public void testConstructorWithAllFields() {
        Property p = new Property("Belmar", "Silver Spring", 1200.0, "John Smith", 0, 0, 2, 2);
        assertEquals("Belmar", p.getPropertyName());
        assertEquals("Silver Spring", p.getCity());
        assertEquals(1200.0, p.getRentAmount(), 0.001);
        assertEquals("John Smith", p.getOwner());
        assertEquals(0, p.getPlot().getX());
        assertEquals(0, p.getPlot().getY());
        assertEquals(2, p.getPlot().getWidth());
        assertEquals(2, p.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Property p1 = new Property("Belmar", "Silver Spring", 1200.0, "John Smith", 0, 0, 2, 2);
        Property p2 = new Property(p1);
        assertEquals("Belmar", p2.getPropertyName());
        assertEquals("Silver Spring", p2.getCity());
        assertEquals(1200.0, p2.getRentAmount(), 0.001);
        assertEquals("John Smith", p2.getOwner());
        assertEquals(0, p2.getPlot().getX());
        assertEquals(0, p2.getPlot().getY());
        assertEquals(2, p2.getPlot().getWidth());
        assertEquals(2, p2.getPlot().getDepth());
    }
}
