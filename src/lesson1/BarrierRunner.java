package lesson1;

import lesson1.barriers.Barrier;
import lesson1.barriers.Racetrack;
import lesson1.barriers.Wall;

import java.sql.SQLOutput;

public interface BarrierRunner {
    String getName();
    int runOnRacetrack();
    int jumpOverWall();
     static void runtrace(Barrier[] trace, BarrierRunner runner){
         boolean win=true;
        for (int i=0;i<trace.length;i++){

                if (Racetrack.class.isInstance(trace[i])){
                    if (trace[i].doRun(runner)){
                        System.out.println(runner.getName() + " пробежал препятствие "+ trace[i].getLenght()+ " м");
                    } else {
                        System.out.println(runner.getName() + " не пробежал препятствие" + trace[i].getLenght()+ " м");
                        win=false;
                        break;
                    }
                }

                if (Wall.class.isInstance(trace[i])){
                    if (trace[i].doJump(runner)){
                        System.out.println(runner.getName() + " перепрыгнул препятствие "+ trace[i].getHeight()+ " см");
                    } else {
                        System.out.println(runner.getName() + " не перепрыгнул препятствие "+ trace[i].getHeight()+ " см");
                        win=false;
                        break;
                    }

                }


        }
        if (win)
         System.out.println(runner.getName() + " преодолел трассу");
        else {
            System.out.println(runner.getName() + " не преодолел трассу");
        }
         System.out.println("-----------------------------------------");
    }
}
