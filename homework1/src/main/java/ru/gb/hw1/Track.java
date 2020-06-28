package ru.gb.hw1;

import java.awt.peer.SystemTrayPeer;
import java.util.Random;

public class Track {
    private Barrier[] barriers;

    public Track(int length){
        Random random = new Random();
        barriers = new Barrier[length];
        for(int i = 0; i < barriers.length;i++){
            if(random.nextBoolean()){
                barriers[i] = new Treadmill(1 + random.nextInt(1999));
            }else{
                barriers[i] = new Wall(1 + random.nextInt(19));
            }
        }
    }

    public void race(Object[] participants){
        for(Barrier b: barriers){
            System.out.println(b.toString());
            for(Object o:participants){
                if(o instanceof IRun && b instanceof Treadmill){
                    ((Treadmill) b).action((IRun)o);
                }
                if(o instanceof IJump && b instanceof Wall){
                    ((Wall) b).action((IJump) o);
                }
            }
        }
        System.out.println("Race finished!");
        for(Object o:participants){
            if(o instanceof IReset){
                if(((IReset)o).isCarryOn()){
                    System.out.println(o.toString() + " finished!");
                }else{
                    System.out.println(o.toString() + " failed the race");
                }
                ((IReset)o).reset();
            }
        }
        System.out.println();
    }

}
