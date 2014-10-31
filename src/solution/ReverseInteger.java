package solution;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {

        int reverse = 0;
        boolean neg = false;
        int min,multiMin;

        if (x < 0) {
            neg = true;
            min = Integer.MIN_VALUE;
        } else {
            min = -1 * Integer.MAX_VALUE;
        }
        
        multiMin = min/10;

        x = Math.abs(x);

        //采用取余数方法
        while (x > 0) {
            if (reverse < multiMin) {
                return 0;
            } 

            reverse *= 10;
            
            if (reverse + x%10 < min) {
                return 0;
            }
            
            reverse = reverse - x % 10;

            x = x/10;
        }
        
        if (neg) {
            return reverse;
        } else {
            return -1 * reverse;
        }
    }
}
