package activities;

public class Activity8 {
    public static void main(String[] args)
    {
        try
        {
            Activity8.exceptionTest("method with non null string");
            Activity8.exceptionTest(null);

        }
        catch(Exception e)
        {
            System.out.println("Error message: "+e.getMessage());
        }
    }

    public static void exceptionTest(String msg) throws CustomException
    {
        if(msg==null) {
            throw new CustomException("String value is null");
        }
        else {
            System.out.println(msg);
        }

    }
}
