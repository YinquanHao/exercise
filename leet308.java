public class NumMatrix {
    int[][] matrix ;
    int[][] colSum ;

    public NumMatrix(int[][] matrix) {
         if(   matrix           == null
       || matrix.length    == 0
       || matrix[0].length == 0   ){
        return;   
     }
        this.matrix = matrix;
        colSum = new int[matrix.length+1][matrix[0].length];
        for(int i=1;i<matrix.length+1;i++){
            for(int j=0;j<matrix[0].length;j++){
                colSum[i][j] = matrix[i-1][j]+colSum[i-1][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int prevVal = matrix[row][col];
        int dif = val - prevVal;
        for(int i=row+1;i<colSum.length;i++){
            colSum[i][col]+=dif;
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for(int i=col1;i<=col2;i++){
            res+=colSum[row2+1][i] - colSum[row1][i];
        }
        return res;
    }
}