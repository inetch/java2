package ru.gb.hw1;

public class MainClass {
    public static void main(String[] args) {
        Object[] participants = new Object[5];

        participants[0] = new Robot("Destroyer");
        participants[1] = new Human("Arni");
        participants[2] = new Cat("Hello-Kitti");
        participants[3] = new Human("Роман Петрович");
        participants[4] = new Robot("Garbage");

        Track track = new Track(4);
        track.race(participants);

        track = new Track(3);
        track.race(participants);
    }
}
