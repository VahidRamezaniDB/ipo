package quera;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProjects = scanner.nextInt();
        int[] profits = new int[numberOfProjects];
        for (int i = 0; i<numberOfProjects; i++) {
            profits[i] = scanner.nextInt();
        }
        int[] capitals = new int[numberOfProjects];
        for (int i = 0; i<numberOfProjects; i++) {
            capitals[i] = scanner.nextInt();
        }
        int maximumCapacity = scanner.nextInt();
        int initialCapital = scanner.nextInt();

//        System.out.println(numberOfProjects);
//        System.out.println(maximumCapacity);
//        System.out.println(initialCapital);
//        System.out.println(Arrays.stream(profits).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
//        System.out.println(Arrays.stream(capitals).boxed().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(findMaximizedCapital(maximumCapacity, initialCapital, profits, capitals));
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        PriorityQueue<Integer> maximizeCapital = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            while (i < n && projects[i][0] <= w) {
                maximizeCapital.offer(projects[i][1]);
                i++;
            }
            if (maximizeCapital.isEmpty()) {
                break;
            }
            w += maximizeCapital.poll();
        }
        return w;
    }
}
