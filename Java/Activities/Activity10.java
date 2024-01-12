package activities;
import java.util.HashSet;

public class Activity10 {
        public static void main(String[] args) {
            HashSet<String> hs = new HashSet<String>();
            // Adding element to HashSet
            hs.add("abc");
            hs.add("def");
            hs.add("ghi");
            hs.add("jkl");
            hs.add("mno");


            /* Print objects in HashSet */
            System.out.println("Original HashSet: " + hs);

            /*P rint size of HashSet */
            System.out.println("Size of HashSet: " + hs.size());

            /*Remove element from Hashset*/
            System.out.println("Removed element from HashSet: " + hs.remove("jkl"));

            /*Remove element that is not present in the Hashset*/
            if(hs.remove("xyz")) {
                System.out.println("xyz removed from the Hashset");
            } else {
                System.out.println("xyz is not present in the Hashset");
            }

            /*Search for element*/
            System.out.println("Check if ghi is present: " + hs.contains("ghi"));

            /*Print updated HashSet*/
            System.out.println("Updated HashSet: " + hs);
        }
    }

