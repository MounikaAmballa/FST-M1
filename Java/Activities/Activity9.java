package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args)
    {
        ArrayList<String> myList=new ArrayList<String>();
        myList.add("mounika");
        myList.add("swathi");
        myList.add("sanvi");
        myList.add("kushi");
        myList.add("pandu");

        /*Print names */

        for(int i=0;i< myList.size();i++)
        {
            System.out.println(myList.get(i));
        }

        /*print 3rd name in the list */
        System.out.println("3rd name in the list is: "+myList.get(2));

        /* Check if name exists in the list */
        System.out.println("Check if this name exists " + myList.contains("Paavaki"));

        /* Size of Aray List */
        System.out.println("Size of the list is: "+myList.size());

        /* Remove a name from the list */
        myList.remove("pandu");

        /*Final size */
        System.out.println("final list after removal is: "+myList.size());

    }
}
