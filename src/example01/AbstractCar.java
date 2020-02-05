package example01;

public abstract class AbstractCar implements Car {
    protected int speed=100;

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void getCharacteristic(){
        out(this.getClass().getSimpleName()+" едет со скоростью: "+speed+" and Volume = "+getVolumeEngine());
    }
    private void out(String str){
        System.out.println(str);
    }


}