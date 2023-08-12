package Inventory;

public class Items
{
    //Encapsulate instance variables
    private String item;

    //Constructor
    public Items(String item)
    {
        this.item = item;
    }

    //Getter
    public String getItem()
    {
        return this.item;
    }


    @Override
    public String toString()
    {
        return this.item;
    }

    @Override
    public boolean equals(Object compared)
    {
        if (this == compared)
        {
            return true;
        }

        if (!(compared instanceof Items))
        {
            return false;
        }

        Items comparedItem = (Items) compared;

        if (this.item.equals(comparedItem.item))
        {
            return true;
        }
        return false;
    }

}