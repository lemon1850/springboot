package com.example.demo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-04
 * @Version 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

}

public class MiddleOrderTravel {


        public void inorderTraversal() {

             int[][] a =  {{1,2},{3,4}};
             for(int i=0; i<a.length; i++){
                 System.out.println(a[i]);
             }

        }

    public static void main(String[] args) {
        MiddleOrderTravel a = new MiddleOrderTravel();
        a.inorderTraversal();


        System.out.println(JSON.toJSONString(a.plusOne(new int[]{9}),true));
    }

    public int[] plusOne(int[] digits) {

            int up = 1;
            int sum;
            for(int i = digits.length-1; i>=0; i--){

                sum = up + digits[i];
                if(sum == 10){
                    up = 1;
                    digits[i] = 0;
                }else {
                    digits[i] = sum;
                    up = 0;
                }
            }
            if(up==1){
                int[] result =  new int[digits.length+1];
                System.arraycopy(digits, 0, result, 1, digits.length);
                result[0] = 1;
                return result;

            }
            return digits;
    }



}
