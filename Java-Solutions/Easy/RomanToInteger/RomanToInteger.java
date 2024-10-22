import java.util.*;
class RomanToInteger
{
    public static int romanToInteger(String s)
    {
        String[] strings = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) 
        {
            map.put(strings[i], value[i]);
        } 
        int index = 0;
        int num = 0;

        while (index < s.length()) 
        {
            if (index + 1 < s.length() && map.containsKey(s.substring(index, index + 2))) 
            {
                num = num + map.get(s.substring(index, index + 2));
                index = index + 2;
            } 
            else 
            {
                num =num + map.get(s.substring(index, index + 1));
                index++;
            }
        }
        return num;
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of string(s): ");
        String s = input.next();
        romanToInteger(s);
    }
}