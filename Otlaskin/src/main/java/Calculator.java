public class Calculator {

    private int value;
    private boolean empty;

    public Calculator() {
        this.value = 0;
        this.empty = true;
    }

    public int getValue() {
        return this.value;
    }

    public void clear() {
        this.value = 0;
        this.empty = true;
    }

    public void init(int val) {
        this.value = val;
    }

    public void addition(int val) {
        value = value + val;
    }

    public void subsctraction(int val) {
        value = value - val;
    }

    public void multiplication(int val) {
        value = value * val;
    }

    public void division(int val) {
        value = value / val;
    }

}
