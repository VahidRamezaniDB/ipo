public class Main {
    public static void main(String[] args) {
        CaseGenerator caseGenerator = new CaseGenerator(new Solution());
        int index = 10;
        String inputFileName = "input" + index + ".txt";
        String outputFileName = "output" + index + ".txt";
        int minSize = 90, maxSize = 100, minvalue = 90_000, maxValue = 100_000;
        caseGenerator.generate(inputFileName, outputFileName, minSize, maxSize, minvalue, maxValue);
    }
}
