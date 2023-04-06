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
public class Plot {
    // instance variables
    private int x;
    private int y;
    private int width;
    private int depth;

    // constructors
    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
    }

    // instance methods
    public boolean encompasses(Plot plot) {
        return plot.getX() >= this.x &&
               plot.getY() >= this.y &&
               plot.getX() + plot.getWidth() <= this.x + this.width &&
               plot.getY() + plot.getDepth() <= this.y + this.depth;
    }

    public boolean overlaps(Plot plot) {
        return plot.getX() < this.x + this.width &&
               plot.getX() + plot.getWidth() > this.x &&
               plot.getY() < this.y + this.depth &&
               plot.getY() + plot.getDepth() > this.y;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }

    // getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
