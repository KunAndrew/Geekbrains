package lesson1.barriers;

import lesson1.BarrierRunner;

public class Racetrack implements Barrier {
    private int lenght;

    public Racetrack(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public int getLenght() {
        return lenght;
    }

    @Override
    public boolean doJump(BarrierRunner barrierRunner) {
        return false;
    }

    public boolean doRun(BarrierRunner barrierRunner){
        int runLenght = barrierRunner.runOnRacetrack();
        return runLenght>=lenght;
    }

    @Override
    public int getHeight() {
        return 0;
    }


}
