package lesson1;

public class Cat implements BarrierRunner {
    private String name;
    private int runLenght;
    private int jumpHeight;

    public Cat(String name, int runLenght, int jumpHeight) {
        this.name = name;
        this.runLenght = runLenght;
        this.jumpHeight = jumpHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int runOnRacetrack() {
        return runLenght;
    }

    @Override
    public int jumpOverWall() {
        return jumpHeight;
    }
}
