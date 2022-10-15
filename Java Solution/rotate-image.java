class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int length = matrix.length;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < i; j++){
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length / 2; j++){
                swap(matrix, i, j, i, length - j - 1);
            }
        }
        return;
    }

    private void swap(int[][] matrix, int row1, int col1, int row2, int col2){
        int tmp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tmp;
    }
}