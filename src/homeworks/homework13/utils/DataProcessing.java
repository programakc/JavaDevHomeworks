package homeworks.homework13.utils;

public class DataProcessing {

    public static Integer parseCount(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Невалидное значение");
        }
    }

    public static Integer validateCount(String str) {
        try {
            return parseCount(str);
        } catch (RuntimeException e) {
            throw e;
        }
    }
}