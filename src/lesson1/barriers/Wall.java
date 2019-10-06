package lesson1.barriers;

import lesson1.BarrierRunner;

public class Wall implements Barrier {
    private int height;

    public Wall(int height) {
        this.height = height;
    }
    public boolean doJump(BarrierRunner barrierRunner){
        int jampHeight = barrierRunner.jumpOverWall();
        return jampHeight>=height;
    }

    @Override
    public boolean doRun(BarrierRunner barrierRunner) {
        return false;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getLenght() {
        return 0;
    }
}
