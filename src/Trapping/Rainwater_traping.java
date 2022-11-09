package Trapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rainwater_traping {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
https://leetcode.com/problems/trapping-rain-water/
*/
    public static void main(String[] args) {
        //int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height={4,2,0,3,2,5};

        List<Integer> right_max_value= right_max(height);

        List<Integer> left_max_value=left_max(height);

        int trapped_water=accumulated_water(height,left_max_value,right_max_value);

        System.out.println("The amount of trapped water: "+trapped_water);

    }

    private static int accumulated_water(int[] height, List<Integer> left_max_value,
                                         List<Integer> right_max_value) {
      int trapped_water=0;

        for (int i = 0; i < height.length; i++) {
            int trapped=Math.min(left_max_value.get(i),right_max_value.get(i))-height[i];
            trapped_water+=trapped;

        }

        return trapped_water;
    }

    private static List<Integer> left_max(int[] height) {
        List<Integer> left_maxes=new ArrayList<>();

        for (int i = 0; i < height.length; i++) {
            int left_max=0;
            for (int j = i; j >=0; j--) {
               left_max=Math.max(left_max,height[j]);
            }
            left_maxes.add(left_max);
        }

        return left_maxes;
    }

    private static List<Integer> right_max(int[] height) {
        List<Integer> right_maxes=new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            int right_max=0;
            for (int j = i; j <height.length ; j++) {
               right_max=Math.max(right_max,height[j]);

            }
            right_maxes.add(right_max);
        }

        return right_maxes;
    }
}
