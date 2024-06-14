import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class CaseGenerator {
    private final Solution solution;

    public CaseGenerator(Solution solution) {
        this.solution = solution;
    }

    public void generate(String inputFileName, String outputFileName) {
        generateInputFile(inputFileName);
    }

    private void generateInputFile(String inputFileName) {
        Random random = new Random(System.currentTimeMillis());
        int size = random.nextInt(4, 10);
        int k, w;
        k = random.nextInt(size / 4, size);
        int[] profits, capital;
        profits = new int[size];
        capital = new int[size];
        for (int i = 0; i < size; i++) {
            capital[i] = random.nextInt(10);
            profits[i] = random.nextInt(10);
        }
        w = random.nextInt(10);
        int result = solution.findMaximizedCapital(k, w, profits, capital);
        System.out.println("size = " + size);
        System.out.println("k = " + k);
        System.out.println("w = " + w);
        System.out.println("profits: " + Arrays.stream(profits).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("capital: " + Arrays.stream(capital).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("result: " + result);
    }
}
