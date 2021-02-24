package com.learn.jwtdemo.DsAlgo;



public class ReverseString
{
    public static void main(String []args){
        String input = "Hello World";
//        System.out.println(input +" : "+
//                reverseString(input.toCharArray(),
//                        0,
//                        input.length()-1
//                ));
        System.out.println(input +" : "+
                reverseRecursively(input));
    }

    public static String reverseRecursively(String str){
        //hello
        if (str.length() <= 1) {
            return str;
        }
        System.out.println("str.substring(1) : "+str.substring(1)+" ,  str.charAt(0) : "+str.charAt(0));
        String afterRev = reverseRecursively(str.substring(1)) + str.charAt(0);
        System.out.println("afterRev : "+afterRev);
        return afterRev;

    }

    public static String toString(char[] a)
    {
        String string = new String(a);
        return string;
    }

    private static char[] swap(char[] input, int leftIndex, int rightIndex){
        System.out.println("inside swap");
        char temp = input[leftIndex];
        input[leftIndex] = input[rightIndex];
        input[rightIndex] = temp;
        System.out.println("swapped input : "+toString(input));
        return input;
    }

    public static String reverseString(char[] input, int leftIndex, int rightIndex){
        System.out.println("inside reverse");
        if(leftIndex >= rightIndex){
            System.out.println("returned : "+toString(input));
            return toString(input);
        }
        input = swap(input, leftIndex, rightIndex);
        System.out.println("after swap : "+toString(input));
        return reverseString(input, leftIndex+1, rightIndex-1);
    }
}
