package CONTROLLER;

public class InputController {
    public static boolean isDigitAnd8Digits(String data) {
        return data.matches("\\d{8}");
    }
    public static boolean isZeroFirst(String data) {
        return data.charAt(0) != '0';
    }
    public static String getCowColor(String data) {
        return data;
    }
    public static boolean isCowBlue(String data) {
        return !data.equals("BLUE");
    }
}
