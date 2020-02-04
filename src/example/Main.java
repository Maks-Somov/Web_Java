package example;

public class Main {
    public static void main(String args[]){
        Car carOne = new CarImpl();
        Car carTwo = new CarImpl();
        carOne.setSpeed(100);
        carOne.Drive(carOne.getSpeed());
        carTwo.setSpeed(430);
        carTwo.Drive(carTwo.getSpeed());
    }
}
