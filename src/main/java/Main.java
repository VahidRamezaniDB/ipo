public class Main {
    public static void main(String[] args) {
        int w = 0;
        int k = 2;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        Solution solution = new Solution();
        System.out.println(solution.findMaximizedCapital(k,w,profits,capital));
    }
}
