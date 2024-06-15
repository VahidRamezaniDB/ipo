import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class CaseGenerator {
    private final Solution solution;

    public CaseGenerator(Solution solution) {
        this.solution = solution;
    }

    public void generate(String inputFileName, String outputFileName, int minSize, int maxSize, int minValue, int maxValue) {
        int result = generateInputFileAndSolve(inputFileName, minSize,maxSize,minValue,maxValue);
        generateOutputFile(outputFileName, result);
    }

    private int generateInputFileAndSolve(String inputFileName, int minSize, int maxSize, int minValue, int maxValue) {
        Random random = new Random(System.currentTimeMillis());
        int size = random.nextInt(minSize, maxSize);
        int k, w;
        k = random.nextInt(1, size);
        w = random.nextInt(minValue, maxValue);
        int[] profits, capital;
        profits = new int[size];
        capital = new int[size];
        for (int i = 0; i < size; i++) {
            capital[i] = random.nextInt(minValue, maxValue);
            profits[i] = random.nextInt(minValue, maxValue);
        }
        int result = solution.findMaximizedCapital(k, w, profits, capital);
        System.out.println("size = " + size);
        System.out.println("k = " + k);
        System.out.println("w = " + w);
        System.out.println("capital: " + Arrays.stream(capital).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("profits: " + Arrays.stream(profits).boxed().map(String::valueOf).collect(Collectors.joining(", ")));
        System.out.println("result: " + result);
        try(FileOutputStream fileOutputStream = new FileOutputStream(inputFileName)) {
            fileOutputStream.write((k + "\n").getBytes());
            fileOutputStream.write((w + "\n").getBytes());
            fileOutputStream.write(
                    Arrays.stream(capital).boxed().map(String::valueOf).collect(Collectors.joining(" ")).getBytes()
            );
            fileOutputStream.write("\n".getBytes());
            fileOutputStream.write(
                    Arrays.stream(profits).boxed().map(String::valueOf).collect(Collectors.joining(" ")).getBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

     private void generateOutputFile(String outputFileName, int value) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(outputFileName)) {
            fileOutputStream.write(String.valueOf(value).getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     }
}
