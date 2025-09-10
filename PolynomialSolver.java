import java.math.BigInteger;

public class PolynomialSolver {

    public static void solveTestCase1() {
        System.out.println("--- Test Case 1 ---");

       =
        long[] yValues = {
            4L,                                  // "4" in base 10
            Long.parseLong("111", 2),            // "111" in base 2
            12L                                  // "12" in base 10
        };

        // 2. Define the pre-calculated Lagrange coefficients L_j(0).
        long[] lagrangeCoefficients = {3, -3, 1};

        // 3. Calculate and print the constant term P(0).
        long constantTerm = 0;
        for (int i = 0; i < 3; i++) {
            constantTerm += yValues[i] * lagrangeCoefficients[i];
        }
        System.out.println("Constant Term: " + constantTerm);
    }

    public static void solveTestCase2() {
        System.out.println("\n--- Test Case 2 ---");

        // 1. Define the y-values and their corresponding bases.
        String[] yValuesStr = {
            "13444211440455345511", "aed7015a346d635", "6aeeb69631c227c",
            "e1b5e05623d881f", "316034514573652620673",
            "2122212201122002221120200210011020220200",
            "20120221122211000100210021102001201112121"
        };
        int[] bases = {6, 15, 15, 16, 8, 3, 3};

        // 2. Define the pre-calculated Lagrange coefficients L_j(0) for k=7.
        BigInteger[] lagrangeCoefficients = {
            new BigInteger("7"), new BigInteger("-21"), new BigInteger("35"),
            new BigInteger("-35"), new BigInteger("21"), new BigInteger("-7"),
            new BigInteger("1")
        };

        // Decode y-values to BigInteger.
        BigInteger[] yValues = new BigInteger[7];
        for (int i = 0; i < 7; i++) {
            yValues[i] = new BigInteger(yValuesStr[i], bases[i]);
        }

        // 3. Calculate and print the constant term P(0).
        BigInteger constantTerm = BigInteger.ZERO;
        for (int i = 0; i < 7; i++) {
            BigInteger term = yValues[i].multiply(lagrangeCoefficients[i]);
            constantTerm = constantTerm.add(term);
        }
        System.out.println("Constant Term: " + constantTerm);
    }

    public static void main(String[] args) {
        solveTestCase1();
        solveTestCase2();
    }
}
