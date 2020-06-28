package ru.gb.hw1;

public abstract class Barrier {
    private int length;

    public Barrier(){
        length = 0;
    }

    public Barrier(int length){
        this.length = length;
    }

    public int getLength(){
        return length;
    }
}
