package ru.gb.hw1;

import java.util.Random;

public class Human implements IRun, IJump, IReset {

    private int maxRun;
    private int maxJump;
    private String name;
    private boolean carryOn;

    private Human(){}

    public Human(String name){
        Random random = new Random();
        maxRun = 100 + random.nextInt(50);
        maxJump = 2 + random.nextInt(2);
        this.name = name;
        carryOn = true;
    }

    public void reset(){
        carryOn = true;
    }
    public boolean isCarryOn(){
        return carryOn;
    }

    public void run(int length){
        if(carryOn) {
            if (maxRun >= length) {
                System.out.printf("Human %s runs %d meters!", name, length);
            } else {
                System.out.printf("Human %s failed to run %d meters...", name, length);
                carryOn = false;
            }
            System.out.println();
        }
    }

    public void jump(int height){
        if(carryOn) {
            if (maxJump >= height) {
                System.out.printf("Human %s jumps %d meters!", name, height);
            } else {
                System.out.printf("Human %s failed to jump %d meters...", name, height);
                carryOn = false;
            }
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Human " + name;
    }
}
