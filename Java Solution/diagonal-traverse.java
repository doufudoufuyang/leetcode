class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0){
            return new int[0];
        }
        int[] result = new int[mat.length * mat[0].length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < result.length){
            result[index] = mat[i][j];
            if ((i + j) % 2 == 0){
                if (j == mat[0].length - 1){
                    i++;
                } else if (i == 0){
                    j++;
                } else {
                    i--;
                    j++;
                }
            } else {
                if (i == mat.length - 1){
                    j++;
                } else if (j == 0){
                    i++;
                } else {
                    i++;
                    j--;
                }
            }
            index++;
        }
        return result;
    }
}