package example;

import java.util.Scanner;

public class CarImpl implements Car {
    private int speed;

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void Drive(int speed){
        out("Едет со скоростью: "+speed);
    }
    private void out(String str){
        System.out.println(str);
    }

}