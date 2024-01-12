package activities;
import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Black");
        map.put(2, "White");
        map.put(3, "Blue");
        map.put(4, "Pink");
        map.put(5, "Orange");

        /* Print Hash MAp */
        System.out.println("The Original map: " + map);

        /* Remove one color from Map */
        map.remove(5);

        /* Map after removing color */
        System.out.println("After removing color " + map);

        // Check if one of the color exists
        if(map.containsValue("Burgundy")) {
            System.out.println("Burgundy exists in the Map");
        } else {
            System.out.println("Burgundy does not exist in the Map");
        }

        /* Print the size of the Map */
        System.out.println("Final size of the Map: " + map.size());
    }
}