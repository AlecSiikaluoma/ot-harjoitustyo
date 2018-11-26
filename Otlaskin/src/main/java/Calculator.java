public class Calculator {

    private int value;

    public Calculator() {
        this.value = 0;
    }

    public int getValue() {
        return this.value;
    }

    public void addition(int value1, int value2) {
        value = value1 + value2;
    }

    public void subsctraction(int value1, int value2) {
        value = value1 - value2;
    }

    public void multiplication(int value1, int value2) {
        value = value1 + value2;
    }

    public void division(int value1, int value2) {
        value = value1 / value2;
    }

}
