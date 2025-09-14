// This solution uses a prev pointers based approach to store all the tail values 
// If at all a * or / encountered, we revert the last operation using the sign and make the respective operation and store it back to respect the BODMAS rule
class Solution {
    public int calculate(String s) {
        int num = 0;
        char sign = '+';
        int tail = 1;
        int calValue = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c>='0' && c<='9') {
                num = num*10+(c-'0');
            }  if((!Character.isDigit(c)&&c!=' ') || i==s.length()-1) {
                if(sign=='*') {
                    calValue-=tail;
                    calValue=calValue+(tail*num);
                    tail = tail*num;
                } else if(sign=='/') {
                    calValue-=tail;
                    calValue=calValue+(tail/num);
                    tail = tail/num;
                } else if(sign=='+') {
                    calValue+=num;
                    tail = num;
                } else if(sign=='-') {
                    calValue-=num;
                    tail = -num;
                }
                num = 0;
                sign = c;
            }
        }
        
        return calValue;
    }
}
