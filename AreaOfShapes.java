import java.util.Scanner;

public class AreaOfShapes
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter what area would you like me to calculate?: ");
        String shape = input.next();

        switch (shape) {
            case "rectangle" -> {
                System.out.println("Enter the length: ");
                double length = input.nextDouble();
                System.out.println("Enter the width: ");
                double width = input.nextDouble();
                double area_rectangle = length * width;
                System.out.println("The area of rectangle is " + area_rectangle);
            }
            case "square" -> {
                System.out.println("Enter the side value: ");
                double side = input.nextDouble();
                double area_square = Math.pow(side, 2);
                System.out.println("The area of square is " + area_square);
            }
            case "triangle" -> {
                System.out.println("Enter the base: ");
                double base = input.nextDouble();
                System.out.println("Enter the height: ");
                double height = input.nextDouble();
                double area_triangle = 0.5 * base * height;
                System.out.println("The area of rectangle is " + area_triangle);
            }
            case "circle" -> {
                System.out.println("Enter the radius: ");
                double radius = input.nextDouble();
                double area_circle = Math.PI * Math.pow(radius, 2);
                System.out.println("The area of circle is " + area_circle);
            }
            default -> System.out.println("Shape cannot be calculated since it is not stored in the database.");
        }
    }
}
