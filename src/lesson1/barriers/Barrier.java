package lesson1.barriers;

import lesson1.BarrierRunner;

public interface Barrier {
    boolean doJump(BarrierRunner barrierRunner);
    boolean doRun(BarrierRunner barrierRunner);
    int getHeight();
    int getLenght();
}
