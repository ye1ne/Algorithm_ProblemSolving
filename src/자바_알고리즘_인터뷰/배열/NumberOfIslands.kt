package 자바_알고리즘_인터뷰.배열

class NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val xSize = grid[0].size
        val ySize = grid.size
        fun dfs(i: Int, j: Int) {
            if (i >= ySize || j >= xSize || i < 0 || j < 0 || grid[i][j] == '0') {
                return
            }

            grid[i][j] = '0';
            dfs(i, j + 1) //동
            dfs(i, j - 1) //서
            dfs(i + 1, j) //남
            dfs(i - 1, j) //북
        }

        var count = 0
        for (i in grid.indices) {
            for (j in grid[0].indices) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j)
                }
            }
        }

        return count

    }


}