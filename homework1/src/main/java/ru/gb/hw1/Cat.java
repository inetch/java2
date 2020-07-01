package ru.gb.hw1;

import java.util.Random;

public class Cat implements IRun, IJump, IReset {

    private int maxRun;
    private int maxJump;
    private String name;
    private boolean carryOn;

    private Cat(){}

    public Cat(String name){
        Random random = new Random();
        maxRun = 10 + random.nextInt(10);
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
                System.out.printf("Cat %s runs %d meters!", name, length);
            } else {
                System.out.printf("Cat %s failed to run %d meters...", name, length);
                carryOn = false;
            }
            System.out.println();
        }
    }

    public void jump(int height){
        if(carryOn) {
            if (maxJump >= height) {
                System.out.printf("Cat %s jumps %d meters!", name, height);
            } else {
                System.out.printf("Cat %s failed to jump %d meters...", name, height);
                carryOn = false;
            }
            System.out.println();
        }
    }

    @Override
    public String toString(){
        return "Cat " + name;
    }
}
