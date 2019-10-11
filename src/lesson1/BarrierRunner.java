package lesson1;

import lesson1.barriers.Barrier;
import lesson1.barriers.Racetrack;
import lesson1.barriers.Wall;

import java.sql.SQLOutput;

public interface BarrierRunner {
    int runOnRacetrack();

    int jumpOverWall();

    String getName();

    static void runtrace(Barrier[] trace, BarrierRunner runner) {
        boolean win = true;
        for (int i = 0; i < trace.length; i++) {
            if (trace[i].passBarrierBy(runner)) {
            } else {
                win = false;
                break;
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
