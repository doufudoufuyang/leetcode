class Solution {
    public int minArea(char[][] image, int x, int y){
        if (image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }

        int minX = rowBinarySearch(image, 0, x, '1');
        int allWhiteRow = rowBinarySearch(image, x, image.length - 1, '0');
        int maxX = allWhiteRow == -1 ? image.length - 1 : allWhiteRow - 1;

        int mixY = colBinarySearch(image, 0, y, '1');
        int allWhiteCol = colBinarySearch(image, y, image[0].length - 1, '0');
        int maxY = allWhiteCol == -1 ? image[0].length - 1 : allWhiteCol - 1;
        return (maxX - minX + 1) * (maxY - mixY + 1);
    }

    private int rowBinarySearch(char[][] image, int top, int bottom, char target){
        while (top < bottom){
            int mid = top + (bottom - top) / 2;
            if (rowContainsBlack(image, mid) == target){
                bottom = mid;
            } else {
                top  = mid + 1;
            }
        }
        return rowContainsBlack(image, top) == target ? top : -1;
    }

    private char rowContainsBlack(char[][] image, int row){
        for (char c : image[row]){
            if (c == '1'){
                return '1';
            }
        }
        return '0';
    }

    private int colBinarySearch(char[][] image, int left, int right, char target){
        while (left < right){
            int mid = left + (right - left) / 2;
            if (colContainsBlack(image, mid) == target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return colContainsBlack(image, left) == target ? left : -1;
    }

    private char colContainsBlack(char[][] image, int col){
        for (int i = 0; i < image.length; i++){
            if (image[i][col] == '1'){
                return '1';
            }
        }
        return '0';
    }
}