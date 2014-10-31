package solution;

//Implement atoi to convert a string to an integer.
public class StringToIntegerAtoi {

    public int atoi(String str) {
        int len = str.length();
        boolean pos = false;
        boolean neg = false;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == ' ' && pos == false && sb.toString().isEmpty()) {
                continue;
            } else if ((ch == '+' || ch == '-') && false == pos) {

                if (ch == '-') {
                    neg = true;
                }

                pos = true;
            } else if ((int) ch <= 57 && (int) ch >= 48) {
                sb.append(ch);
            } else {
                break;
            }
        }

        String parsedInt = sb.toString();

        if (parsedInt.isEmpty()) {
            return 0;
        }

        int intLen = parsedInt.length();
        int intVal = 0;

        int min,multMin;
        if (neg) {
            min = Integer.MIN_VALUE;
            multMin = Integer.MIN_VALUE/10;
        } else {
            min = -1 * Integer.MAX_VALUE;
            multMin = -1 * Integer.MAX_VALUE/10;
        }

        for (int j = 0; j < intLen; j++) {
            //overflow检测
            if (intVal < multMin) {
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            intVal = intVal * 10;

            //overflow检测
            if (intVal < min + Character.digit(parsedInt.charAt(j),10)) {
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            intVal = intVal - Character.digit(parsedInt.charAt(j),10);
            
        }

        if (neg) {
            return intVal;
        } else {
            return -1 * intVal;
        }
    }
}
