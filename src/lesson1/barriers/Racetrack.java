package lesson1.barriers;

import lesson1.BarrierRunner;

public class Racetrack implements Barrier {
    private int lenght;

    public Racetrack(int lenght) {
        this.lenght = lenght;
    }

    public int getLenght() {
        return lenght;
    }

    @Override
    public boolean passBarrierBy(BarrierRunner barrierRunner) {
        int runLenght = barrierRunner.runOnRacetrack();
        if (runLenght >= lenght)
            System.out.println(barrierRunner.getName() + " пробежал препятствие " + this.getLenght() + " м");
        else
            System.out.println(barrierRunner.getName() + " не пробежал препятствие" + this.getLenght() + " м");
        return runLenght >= lenght;
    }
}
