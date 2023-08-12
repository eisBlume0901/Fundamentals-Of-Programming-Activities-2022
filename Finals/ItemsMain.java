package Inventory;
import java.util.*;
import static java.lang.System.*;

public class ItemsMain
{
    static Scanner scan = new Scanner(in);
    static ArrayList<Items> items = new ArrayList<>();
    static int input;
    public static void main(String[] args)
    {
        do
        {
            while (true)
            {
                input = readInt("\nAlways type exit for the features you want to use. " +
                        "\nWhat do you want to do? \n[1] Add \n[2] Search \n[3] Delete " +
                        "\n[4] Remove All \n[5] Display \n", 5);

                if (input == 1) //Add
                {
                    out.println("\nType the items you want to add");
                    add();
                }
                if (input == 2) //Search
                {
                    if (items.size()-1 == 0)
                    {
                        out.println("No items are inside the inventory to search. Please add items first!");
                    }
                    else
                    {
                        out.println("\nType the items you want to search");
                        search();
                    }
                }
                if (input == 3) //Delete
                {
                    if (items.size()-1 == 0)
                    {
                        out.println("No items are inside the inventory to delete. Please add items first!");
                    }
                    else
                    {
                        out.println("\nType the items you want to delete");
                        delete();
                    }
                }
                if (input == 4) //Remove all
                {
                    if (items.size()-1 == 0)
                    {
                        out.println("No items to be removed. Please add items first!");
                    }
                    else
                    {
                        remove();
                    }
                }
                if (input == 5) //Display
                {
                    if (items.size()-1 == 0)
                    {
                        out.println("No items to be displayed. Please add items first!");
                    }
                    else
                    {
                        display();
                    }
                }

                out.println();
                out.println("Use the inventory again? ");
                out.println("Enter yes or no");
                String useAgain = scan.next();
                if (!useAgain.equalsIgnoreCase("Yes"))
                {
                    break;
                }
            }

        }
        while (input < 0 || input > 6);
    }

    public static int readInt(String prompt, int userChoices)
    {
        int input;
        do
        {
            out.print(prompt);
            try
            {
                input = Integer.parseInt(scan.next());
            }
            catch (Exception e)
            {
                input = -1;
                out.println("\nPlease enter integers only!");
            }
        }
        while (input < 1 || input > userChoices);
        return input;
    }

    public static void add()
    {
        while (true)
        {
            String add = scan.nextLine();
            if (add.equals("exit"))
            {
                break;
            }
            Items addItem = new Items(add);
            items.add(addItem);
            int duplicate = 0;
            for (int i = 1; i <= items.size()-1; i++)
            {
                if (items.get(i).equals(items.get(items.size()-1)))
                {
                    duplicate++;
                }

                if (duplicate > 1)
                {
                    out.println(items.get(i) + " is already on the Items.");
                    items.remove(items.get(items.size()-1));
                }
            }
        }
    }

    public static void search()
    {
        while (true)
        {
            String search = scan.nextLine();
            if (search.equals("exit"))
            {
                break;
            }
            for (int i = 1; i <= items.size()-1; i++)
            {
                if (items.get(i).toString().equals(search))
                {
                    out.println(search + " found!");
                    break;
                }
            }
        }
    }

    public static void delete()
    {
        while (true)
        {
            String delete = scan.nextLine();
            if (delete.equals("exit"))
            {
                break;
            }
            for (int i = 1; i <= items.size()-1; i++)
            {
                if (items.get(i).toString().equals(delete))
                {
                    out.println(items.get(i).toString() + " deleted!");
                    items.remove(items.get(i));
                    break;
                }
            }
        }
    }
    public static void remove()
    {
        out.println("\nAll items will be removed!");
        items.removeAll(items);
    }
    public static void sort(ArrayList<Items> items)
    {
        items.sort((Comparator.comparing(Items::getItem)));
    }
    public static void display()
    {
        out.println("---Items---");
        sort(items);
        for (int i = 1; i <= items.size()-1; i++)
        {
            out.println(i + ") " + items.get(i));
        }
    }
}