import com.leetcode.solution.Solution;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        long start = System.currentTimeMillis();
        System.out.println(s.hard.hasSameDigits("34789"));
        System.out.printf("%.10f ms", (float)(System.currentTimeMillis() - start)/1000);
    }
}
