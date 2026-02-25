import java.util.Arrays;

/*
 * Problem: Sort Integers by The Number of 1 Bits
 * You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation
* and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 */

class Solution {
    
    public int[] sortByBits(int[] arr) {
        
        // Note for me : Remember to Convert to Wrapped Class before using Comparator 
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(nums, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            
            if (bitCountA != bitCountB) {
                return bitCountA - bitCountB;
            }
            else {
                return a - b;
            } 
        });

        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

public class sortIntegerByNoOf1Bits {

    public static void main(String[] args) {
        
        Solution sol = new Solution();
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
                
        int result[] = sol.sortByBits(arr);
        System.out.println("Output array: " + Arrays.toString(result));
        
    }
}
