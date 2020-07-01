package ru.gb.hw1;

public class Treadmill extends Barrier{
    public Treadmill(int length){
        super(length);
    }

    public void action(IRun run){
        run.run(getLength());
    }

    @Override
    public String toString() {
        return "Treadmill length " + getLength();
    }
}
