package example;

public class RaceCar extends AbstractCar {
    RaceCar(){
        speed = 200;
    }

    @Override
    public double getVolumeEngine() {
        return 3.5;
    }
}
