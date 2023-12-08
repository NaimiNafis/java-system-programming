package jx08;

public class CalcCtrl {
    private CalcModel mdl;

    CalcCtrl() {
        mdl = new CalcModel();
    }

    public double calc(String operation, double num1, double num2) {
        switch (operation) {
            case "+":
                return mdl.plus(num1, num2);
            case "-":
                return mdl.minus(num1, num2);
            case "*":
                return mdl.multi(num1, num2);
            case "/":
                return mdl.divide(num1, num2);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}



