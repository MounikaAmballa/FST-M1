package activities;

interface BicycleParts
{
    public int gears=0;
    public int speed=0;
}

interface BicycleOperations
{
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}
public class Activity7 {

    public static void main(String[] args)
    {
        MountainBike mb=new MountainBike(3,0,30);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);

    }

}
