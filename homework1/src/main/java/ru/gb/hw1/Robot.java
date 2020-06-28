package ru.gb.hw1;

import java.util.Random;

public class Robot implements IRun, IJump, IReset {

    private int maxRun;
    private int maxJump;
    private String name;
    private boolean carryOn;

    private Robot(){}

    public Robot(String name){
        Random random = new Random();
        maxRun = 1000 + random.nextInt(10);
        maxJump = 30 + random.nextInt(2);
        this.name = name;
        carryOn = true;
    }

    public void reset(){
        carryOn = true;
    }

    public boolean isCarryOn(){
        return carryOn;
    }

    public void sayStatus(){
        if(isCarryOn()){
            System.out.println("Robot %s is ");
        }
    }

    public void run(int length){
        if(carryOn) {
            if (maxRun >= length) {
                System.out.printf("Robot %s runs %d meters!", name, length);
            } else {
                System.out.printf("Robot %s failed to run %d meters...", name, length);
                carryOn = false;
            }
            System.out.println();
        }
    }

    public void jump(int height){
        if(carryOn) {
            if (maxJump >= height) {
                System.out.printf("Robot %s jumps %d meters!", name, height);
            } else {
                System.out.printf("Robot %s failed to jump %d meters...", name, height);
                carryOn = false;
            }
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Robot " + name;
    }
}
