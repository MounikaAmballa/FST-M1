package activities;

public class Activity2 {
    public static void main(String[] args)
    {
        int numarray[]=new int[]{10,77,10,54,-11,10};
        int value=0;
        int finalsum=30;
        for(int i=0;i< numarray.length;i++)
        {
         //  int j=0;
           if((numarray[i]/10)==1) {
               value = value + numarray[i];

           }
        }
        if(value==finalsum)
        {
           System.out.println("Final Sum is correct");
        }
        else {
            System.out.println("Final sum is incorrect");
        }
    }
}
