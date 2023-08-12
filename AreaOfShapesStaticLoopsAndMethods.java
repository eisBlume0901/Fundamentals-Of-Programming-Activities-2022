import java.util.Scanner;
import static java.lang.System.*;

public class AreaOfShapesStaticLoopsAndMethods
{
    static Scanner input = new Scanner(in);
    static String shape;

    static double area;
    public static void main(String[] args)
    {
        do
        {
            while(true)
            {
                out.println("Choose rectangle, square, triangle, or circle.");
                out.println("Enter shape: ");
                shape = input.next();
                if (shape.equalsIgnoreCase("rectangle")) {
                    rectangle();
                    out.println("\nThe area of the rectangle is " + area);
                }
                if (shape.equalsIgnoreCase("square")) {
                    square();
                    out.println("\nThe area of the square is " + area);
                }
                if (shape.equalsIgnoreCase("triangle")) {
                    triangle();
                    out.println("\nThe area of triangle is " + area);
                }
                if (shape.equalsIgnoreCase("circle")) {
                    circle();
                    out.println("\nThe area of circle is " + area);
                }
                out.println("Try again? Yes or No? ");
                String tryAgain = input.next();
                if (!tryAgain.equalsIgnoreCase("Yes"))
                {
                    break;
                }
            }

        } while (!shape.equalsIgnoreCase("rectangle") &&
                !shape.equalsIgnoreCase("square") &&
                !shape.equalsIgnoreCase("triangle") &&
                !shape.equalsIgnoreCase("circle"));

    }
    public static void rectangle() {
        out.println("Enter the length: ");
        while (!input.hasNextDouble())
        {
            out.println("Only numbers are allowed. Please try again!");
            input.next();
        }
        double length = input.nextDouble();

        out.println("Enter the width: ");
        while (!input.hasNextDouble())
        {
            out.println("Only numbers are allowed. Please try again!");
            input.next();
        }
        double width = input.nextDouble();

        area = length*width;
    }
    public static void square()
    {
        out.println("\nEnter the side value: ");
        while (!input.hasNextDouble())
        {
            out.println("Only numbers are allowed. Please try again!");
            input.next();
        }
        double side = input.nextDouble();

        area = Math.pow(side, 2);
    }
    public static void triangle()
    {
        out.println("\nEnter the base: ");
        while (!input.hasNextDouble())
        {
            out.println("Only numbers are allowed. Please try again!");
            input.next();
        }
        double base = input.nextDouble();

        out.println("\nEnter the height: ");
        while (!input.hasNextDouble())
        {
            out.println("Only numbers are allowed. Please try again!");
            input.next();
        }
        double height = input.nextDouble();

        area = 0.5*base*height;
    }
    public static void circle()
    {
        out.println("\nEnter the radius: ");
        while (!input.hasNextDouble())
        {
            out.println("Only numbers are allowed. Please try again!");
            input.next();
        }
        double radius = input.nextDouble();

        area = Math.PI*Math.pow(radius,2);
    }
}
