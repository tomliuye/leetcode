package solution;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

public class ZigZagConvention {

    public String solution(String s, int nRows) {

        //�Ϸ����ж�
        if (nRows <= 1) {
            return s;
        }

        int len = s.length();

        //ǰ���ж�
        if (len <= nRows) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        //�����ó�ÿ��zigzag�Ĳ���
        int step = 2 * nRows - 2;

        for (int i = 0; i < nRows; i++) {
            int j = i;
            while (j < len) {
                //���岨��ֻ��һ��ռλ
                if (i == 0 || i == nRows - 1) {
                    sb.append(s.charAt(j));
                    j += step;
                    continue;
                } else {
                    if (j == i) {
                        //�����
                        sb.append(s.charAt(j));
                    } else {
                        //��������⣬��2��Ԫ��
                        sb.append(s.charAt(j - 2*i));
                        sb.append(s.charAt(j));
                    }
                }

                j += step;

                //δ��ɵ�zigzag����
                if (j >= len && j - 2*i < len) {
                    sb.append(s.charAt(j - 2*i));
                }
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        ZigZagConvention zigzag = new ZigZagConvention();

        System.out.println(zigzag.solution("ABCDE", 4));
    }
}