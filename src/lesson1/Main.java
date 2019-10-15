package lesson1;

import lesson1.barriers.Barrier;
import lesson1.barriers.Racetrack;
import lesson1.barriers.Wall;

public class Main {

    public static void main(String[] args) {
 BarrierRunner participants[]=new BarrierRunner[3];
 Barrier barriers[]=new Barrier[5];
        participants[0]=new Human("Bob",1000,100);
        participants[1]=new Cat("Барсик",1000,320);
        participants[2]=new Robot("IRobot",5000,10000);

barriers[0]=new Wall(80);
barriers[1]=new Racetrack(50);
barriers[2]=new Racetrack(300);
barriers[3]=new Wall(300);
barriers[4]=new Racetrack(3000);


        for (BarrierRunner runner:participants) {
BarrierRunner.runtrace(barriers,runner);
        }
    }
}
