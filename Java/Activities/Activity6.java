package activities;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane=new Plane(10);
        plane.onboard("mounika");
        plane.onboard("kushi");
        plane.onboard("naidu");
        plane.onboard("sudha");
        plane.onboard("harish");
        System.out.println("Take-off time is:"+plane.takeOff());
        System.out.println("Passengers list:"+plane.getPassesngers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Landed time:"+plane.getLastTimeLanded());
    }
}
