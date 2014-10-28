package solution;

/*
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class ReverseInteger {
    public int reverse(int x) {

        StringBuilder sb = new StringBuilder();

        if (x < 0) {
            sb.append("-");
        }

        x = Math.abs(x);

        //����ȡ�����ķ���
        while (x > 0) {
            int i = x % 10;
            sb.append(i);
            x = x/10;
        }
        
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
