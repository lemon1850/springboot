package com.example.demo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Collections;
import java.util.Stack;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-04-03
 * @Version 1.0
 */
public class SolutionA {

    static Stack<Character> stack = new Stack<>();
    public static  boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for(char c: chars){
            if('{'==c ||'('==c ||'['==c){
                stack.push(c);
            }else if('}'==c){
                if(stack.empty() || !(stack.pop()=='{')){
                    return false;
                }
            }else if(']'==c){
                if(stack.empty() || !(stack.pop()=='[')){
                    return false;
                }
            }else if(')'==c){
                if(stack.empty() || ! (stack.pop()=='(')){
                    return false;
                }
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }

    }
    public int dominantIndex(int[] nums) {

        int firstBigIndex = 0;
        int secondBigIndex=0;
        int firstBig = 0;
        int secondBig = 0;
        int tmp;
        //1. 跟第二个数比，比他大就替换第二大
        //2. 跟第一大的书比，比他大就互换
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > secondBig) {
                secondBig = nums[i];
                secondBigIndex = i;
            }
            if(secondBig>firstBig){
                tmp = firstBig;
                firstBig = secondBig;
                secondBig = tmp;
                tmp = firstBigIndex;
                firstBigIndex = secondBigIndex;
                secondBigIndex = tmp;
            }


        }
        if (firstBig >= secondBig * 2) {
            return firstBigIndex;
        } else {
            return -1;
        }
    }

    public int[] findDiagonalOrder(int[][] matrix) {

        int j;
        int k;

        if(matrix.length==0){
            return new int[0];
        }
        int[] result = new int[matrix.length*matrix[0].length];
        //先搞第一行
        int at=0;
        for (int i=0 ; i < matrix[0].length ; i++) {

            for( j=0,k=i; j<matrix.length&&k>=0 ; j++,k--){
                result[at++]=matrix[j][k] ;
            }

        }
        return result;


    }
    public void reverseString(char[] s) {

        char tmp;
        for(int i = 0, j = s.length-1; i < j; i++, j--){
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        System.out.println(JSON.toJSONString(s, true));

    }

    public int findMaxConsecutiveOnes(int[] nums) {


        int max=0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if(nums[i]==1){
                count++;
                max = max > count ? max: count;
            }else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(isValid("(]"));
        SolutionA a = new SolutionA();
//        int[][] b = new int[][]{{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
//        System.out.println(a.dominantIndex(new int[]{0,0,0,1}));
//        System.out.println(JSON.toJSONString(a.findDiagonalOrder(b), true));
        int[] b = new int[0];
        a.reverseString(new char[]{'h','e','l','l','o'});
    }
}
