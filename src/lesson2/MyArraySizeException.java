package lesson2;

public class MyArraySizeException extends IllegalArgumentException {
    public MyArraySizeException() {
        super("Неверное число аргументов");
    }
}
