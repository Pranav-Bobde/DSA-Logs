//Link: https://leetcode.com/problems/guess-number-higher-or-lower/

//Time & Space Complexity: O(logN) O(1)

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long s= 0, e = n;
        while(s<=e){
            long mid = s + (e-s)/2;
            if(guess((int)mid) == 0){
                return (int)mid;
            }else if(guess((int)mid) == -1){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return -1;
    }
}
