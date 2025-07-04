import com.leetcode.solution.Solution;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");

        BigDecimal result = a.add(b);

        System.out.printf("%.20f\n", 0.1 + 0.2);
        System.out.printf("%.20f", result);
    }
}
