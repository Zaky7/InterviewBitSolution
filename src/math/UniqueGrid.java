package math;

public class UniqueGrid {
   
    public int uniquePaths(int A, int B) {
        int ans = 0;

        long startTime = System.nanoTime();
        ans = uniquePathDp(A, B);
        computeTime(startTime, " DP ");

        startTime = System.nanoTime();
        ans = uniquePathsRecursive(0, 0, A - 1, B - 1, 0);
        computeTime(startTime, " Recursive ");

        return ans;
    }

    public void computeTime(long startTime, String msg) {
        System.out.println();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Time in Mili Seconds: " + msg + (duration) / 1000000);
    }

    public int uniquePathDp(int A, int B) {
        int mat[][] = new int[A + 1][B + 1];

        // Filled the Last Row with Zero
        for (int j = 0; j <= B; j++)
            mat[A][j] = 0;

        // Filled the Last Column with Zero
        for (int i = 0; i <= A; i++)
            mat[i][B] = 0;

        for (int i = A - 1; i >= 0; i--) {
            for (int j = B - 1; j >= 0; j--) {
                if ((i == A - 1) && (j == B - 1)) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i + 1][j] + mat[i][j + 1];
                }
            }
        }

        printMat(mat, A, B);

        return mat[0][0];
    }

    public void printMat(int[][] mat, int A, int B) {
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int uniquePathsRecursive(int X, int Y, int A, int B, int paths) {
        if (X > A || Y > B) {
            return 0;
        }

        if (X == A && Y == B) {
            ++paths;
            return paths;
        }

        return uniquePathsRecursive(X + 1, Y, A, B, paths) + uniquePathsRecursive(X, Y + 1, A, B, paths);
    }

    public static void main(String[] args) {
        UniqueGrid ug = new UniqueGrid();
        int A = 44;
        int B = 44;

        int ans = ug.uniquePaths(A, B);
        System.out.println(ans);
    }
}
