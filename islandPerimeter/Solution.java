class Solution {
    public static int islandPerimeter(int[][] grid) {

        // 海域东西长度，列数
        int m = grid[0].length;
        // 海域南北长度，行数
        int n = grid.length;

        // 周长
        int p = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    // 深度搜索DFS
                    p = p + getPerimeter(grid, i, j);
                }

            }
        return p;
    }

    private static int getPerimeter(int[][] grid, int i, int j) {
        // 按照四个方向搜索，如果是海域，周长加1
        int[][] offset = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        int count = 0;
        int x, y;
        for (int[] ks : offset) {
            x = i + ks[0];
            y = j + ks[1];
            if (x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] gird = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        int p = islandPerimeter(gird);
        System.out.println(p);

        int[][] gird2 = {{0,1}};
        System.out.println(islandPerimeter(gird2));
        
    }

}