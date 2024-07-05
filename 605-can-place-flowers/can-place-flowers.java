class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int space3 = 0;
        int size = flowerbed.length, i = 0;
        if(size == 1 && flowerbed[0] == 0) return true;
        if(size == 2 && flowerbed[0] == 0 && flowerbed[1] == 0 && n == 1) return true;
        if (flowerbed[0] == 0 && flowerbed[1] == 0 && size > 2) {
            space3++;
            i = 1;
        }
        while (size - 3 > i && size > 4) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
                space3++;
                i = i + 2;
                continue;
            }
            i++;
        }
        if (flowerbed[size - 1] == 0 && flowerbed[size - 2] == 0 && size > 2) {
            space3++;
            // i = 2;
        }
        if (space3 >= n)
            return true;
        return false;
    }
}