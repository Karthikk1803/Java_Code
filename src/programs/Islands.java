package programs;

public class Islands {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIsland(grid));
    }

    public static int numIsland(char[][] grid){
        int n = grid.length, m = grid[0].length;

        int c=0;
        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!vis[i][j] && grid[i][j] == '1'){
                    vis[i][j] = true; c++;
                    dfs(i, j, vis, grid);
                }
            }
        }
        return c;
    }

    private static void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(i<0 || j<0 || i > n-1 || j > m-1) return;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int x=0; x<4; x++){
            int nr = i+dr[x];
            int nc = j+dc[x];
            if(nc >= 0 && nc < m && nr >= 0 && nr < n && !vis[nr][nc] && grid[nr][nc] == '1'){
                vis[nr][nc] = true;
                dfs(nr, nc, vis, grid);
            }
        }
    }
}
