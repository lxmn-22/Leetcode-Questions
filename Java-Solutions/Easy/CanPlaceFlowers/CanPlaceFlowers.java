/*
You have a long flowerbed in which some of the plots are planted, and some are not. 
However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty,
and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
*/
class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (canPlaceCheck(i, flowerbed)) {
                flowerbed[i] = 1;
                n--;
            } 
        }
        return n == 0;
    }
    
    private static boolean canPlaceCheck(int i, int[] flowerbed) {
        return flowerbed[i] == 0 && (
            (i == 0 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) || 
            (i == flowerbed.length - 1 && (i - 1 == -1 || flowerbed[i - 1] == 0)) || 
            (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
        );
    }
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int n = 1;
        System.out.println("Can place flowers: "+canPlaceFlowers(flowerbed, n));
    }
}