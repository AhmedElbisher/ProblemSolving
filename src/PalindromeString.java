/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */

public class PalindromeString {
    public  boolean  isNumber1(String x) {
        try {
            Integer.parseInt(x);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public int isPalindrome(String A) {
        int start = 0;
        int end = A.length()-1;
        while(start <= end) {
            while( start<=end && (!(Character.isAlphabetic(A.charAt(start))||
                    isNumber1(A.substring(start,start+1)) ))){start++;}
            if(start > end) break;
            for(;end >= start ; end--) {
                if(Character.isAlphabetic(A.charAt(end))||isNumber1(A.substring(end,end+1))) break;
            }
            if(start > end) break;

            if(Character.toLowerCase(A.charAt(start)) != Character.toLowerCase(A.charAt(end))) return 0;
            start ++;
            end --;
        }

        return 1;
    }
}
