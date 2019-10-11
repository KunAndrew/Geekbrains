package lesson1.barriers;

import lesson1.BarrierRunner;

public class Wall implements Barrier {
    private int height;

    public Wall(int height) {
        this.height = height;
    }


    @Override
    public boolean passBarrierBy(BarrierRunner barrierRunner) {
        int jampHeight = barrierRunner.jumpOverWall();
        if (jampHeight >= height)
            System.out.println(barrierRunner.getName() + " перепрыгнул препятствие " + this.getHeight() + " см");
        else
            System.out.println(barrierRunner.getName() + " не перепрыгнул препятствие " + this.getHeight() + " см");
        return jampHeight >= height;
    }


    public int getHeight() {
        return height;
    }
}
