package ru.gb.hw1;

public class Wall extends Barrier {
    public Wall(int height){
        super(height);
    }

    public void action(IJump jump){
        jump.jump(getLength());
    }

    @Override
    public String toString() {
        return "Wall height " + getLength();
    }
}
