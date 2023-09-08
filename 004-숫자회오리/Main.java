import java.util.Arrays;

public class Main {

    private static final int[] TESTCASES = { 4, 5, 10 };

    private static final int[][][] TESTCASES_RESULT = {
        {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
        },
        {
            {1, 2, 3, 4, 5},
            {16, 17, 18, 19, 6},
            {15, 24, 25, 20, 7},
            {14, 23, 22, 21, 8},
            {13, 12, 11, 10, 9}
        },
        {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {36, 37, 38, 39, 40, 41, 42, 43, 44, 11},
            {35, 64, 65, 66, 67, 68, 69, 70, 45, 12},
            {34, 63, 84, 85, 86, 87, 88, 71, 46, 13},
            {33, 62, 83, 96, 97, 98, 89, 72, 47, 14},
            {32, 61, 82, 95, 100, 99, 90, 73, 48, 15},
            {31, 60, 81, 94, 93, 92, 91, 74, 49, 16},
            {30, 59, 80, 79, 78, 77, 76, 75, 50, 17},
            {29, 58, 57, 56, 55, 54, 53, 52, 51, 18},
            {28, 27, 26, 25, 24, 23, 22, 21, 20, 19}
        }
    };
    
    private static double correct = 0;
    
    public static void main(String[] args) {
        for (int i = 0; i < TESTCASES.length; i++) 
            System.out.println("Test Case " + (i + 1) + " = " + test(TESTCASES[i], TESTCASES_RESULT[i]));

        System.out.println("정답률 = " + (int) (correct / TESTCASES.length * 100) + "%");
    }

    private static boolean test(int input, int[][] result) {
        if (Arrays.deepEquals(solution(input), result)) {
            correct++;
            return true;
        }
        return false;
    }

  private static int[][] solution(int input) {
        int[][] result = new int[input][input];

        int row = 0;
        int col = 0;
        int num = 1;
        int maxRow = input-1;
        int maxCol = input-1;
        int minRow = 0;
        int minCol = 0;

        while (num <= input * input) {
            // 오른쪽
            for (; col <= maxCol && result[row][col] == 0; col++) {
                result[row][col] = num;
                num++;
            }
            col--;
            row++;
            minRow++;
    
            // 아래
            for (; row <= maxRow && result[row][col] == 0; row++) {
                result[row][col] = num;
                num++;
            }
            row--;
            col--;
            maxCol--;
    
            // 왼쪽
            for (; col >= minCol && result[row][col] == 0; col--) {
                result[row][col] = num;
                num++;
            }
            col++;
            row--;
            maxRow--;
    
            // 위쪽
            for (; row >= minRow && result[row][col] == 0; row--) {
                result[row][col] = num;
                num++;
            }
            row++;
            col++;
            minCol++;
        }
        return result;

    }

    
}