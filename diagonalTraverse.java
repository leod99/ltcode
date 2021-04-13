//lintcode 1205
//https://www.lintcode.com/problem/1205/

public class Solution {
    /**
     * @param matrix: a 2D array
     * @return: return a list of integers
     */
    int[] dx = {1, -1};
    int[] dy = {-1, 1};
    public int[] findDiagonalOrder(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int turn = 1;
        int i=0, j=0;
        int[] res = new int[n*m];
        int k=0;
        while(i<n &&j<m){
            res[k++] = matrix[i][j];
            if(i==0){
                if(j==m-1){
                    i++;
                }else{
                    j++;
                }
                //turn ^=1;
            }else if(j==0){
                if(i==n-1){
                    j++;
                }else{
                    i++;
                }
                //turn ^=1;
            }else if(i==n-1){
                j++;
                //turn ^=1;
            }else if(j==m-1){
                i++;
                //turn^=1;
            }
            turn^=1;
            while(i>=0&&j>=0&&i<=n-1&&j<=m-1){
                res[k++] = matrix[i][j];
                i+=dx[turn];
                j+=dy[turn];
            }
            i-=dx[turn];
            j-=dy[turn];
            k--; // important
        }
        return res;
    }
}
