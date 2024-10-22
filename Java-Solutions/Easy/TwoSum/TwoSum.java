import java.util.HashMap;

public class TwoSum 
{
    public int[] twoSum(int[] num, int target)
    {
        int[] ans = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length; i++)
        {
            if(map.containsKey(target - num[i]))
            {
                ans[i] = i;
                ans[0] = map.get(target - num[i]);
                return ans;
            }
            map.put(num[i], i);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        twoSum(5,3);
    }
}
