package lesson2;

public class HomeWork2 {
    public static void main(String[] args) {
        try {
            int result = sumArray(correctArray);
            System.out.println("Сумма чисел: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Некорректный размер массива");
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Некорректные данные в массиве");
            e.printStackTrace();
        }
    }

    private static String correctArray[][] = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"},
    };
    private static String incorrctArray[][] = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12", "55"},
            {"13", "14", "15", "16"},
    };
    private static String incorrctArrayData[][] = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "Words", "12"},
            {"13", "14", "15", "16"},
    };

    private static int sumArray(String[][] array) {
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] row : array) {
            if (row.length != 4) {
                throw new MyArraySizeException();
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            String[] row = array[i];
            for (int j = 0; j < row.length; j++) {
                String value = row[j];
                try {
                    sum = sum + Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(value, i, j);
                }
            }
        }

        return sum;
    }
}
