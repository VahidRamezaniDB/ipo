public class Main {
    public static void main(String[] args) {
        CaseGenerator caseGenerator = new CaseGenerator(new Solution());
        caseGenerator.generate("input1.txt", "output1.txt", 1, 10, 0, 100);
    }
}
