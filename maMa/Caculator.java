import java.util.Scanner;
import java.util.Stack;


class Caculator {
    public static void main(String[] args) {
        System.out.println(calculate2("(1+(4+5+2)-3)+(6+8)"));

    }

    static int calculate(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num
            if (isdigit(c)) {
                num = 10 * num + (c - '0');
            }
            //
            if (c == '(') {
                num = calculate(s.substring(i + 1));
            }
            // 如果不是数字，就是遇到了下⼀个符号，
            // 之前的数字和符号就要存进栈中
            if (!isdigit(c) && c != ' ' || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    case '*':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.peek();
                        stk.pop();
                        stk.push(pre / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }

            if (c == ')') {
                break;
            }
        }
        // 将栈中所有结果求和就是答案
        int res = 0;
        while (!stk.empty()) {
            res += stk.peek();
            stk.pop();
        }
        return res;
    }

    private static boolean isdigit(char c) {
        return ('0' <= c && c <= '9');
    }

    /**
     * 
     * 
     */

    public static int calculate2(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        // For the on-going result
        int sign = 1;
        // 1 means positive, -1 means negative
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // Forming operand, since it could be more than one digit
                operand = 10 * operand + (int) (ch - '0');
            } else if (ch == '+') {
                // Evaluate the expression to the left,
                // with result, sign, operand
                result += sign * operand;
                // Save the recently encountered '+' sign
                sign = 1;
                // Reset operand
                operand = 0;
            } else if (ch == '-') {
                result += sign * operand;
                sign = -1;
                operand = 0;
                
            } else if (ch == '(') {
                // Push the result and sign on to the stack, for later
                // We push the result first, then sign 
                stack.push(result); 
                stack.push(sign);
                // Reset operand and result, as if new evaluation begins for the new
                // sub-expression
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                // Evaluate the expression to the left
                // with result, sign and operand
                result += sign * operand;
                // ')' marks end of expression within a set of parenthesis
                // Its result is multiplied with sign on top of stack
                // as stack.pop() is the sign before the parenthesis
                result *= stack.pop();
                // Then add to the next operand on the top.
                // as stack.pop() is the result calculated before this parenthesis
                // (operand on stack) + (sign on stack * (result from parenthesis))
                result += stack.pop();
                // Reset the operand
                operand = 0;
            }
        }
        return result + (sign * operand);
    }

    /**
     * 
     * @return
     */
    public static String getRPN(String str) {
        return "";
    }

    public static int findTheMost() {
        Scanner in = new Scanner(System.in);
        String src = in.nextLine();
        int[] lowCaseTable = new int[27];
        int[] upCaseTable = new int [27]; 
        char ch;
        for (int i = 0; i < src.length(); i++) {
            ch = src.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                lowCaseTable[(ch - 'a') + 1]++;

            } else if ('A' <= ch && ch <= 'Z') {
                upCaseTable[(ch - 'A') + 1]++;
            }
        }
        // 搜索算法

        

        
        in.close();
        return 0;
    }

    public static boolean isLetter(char ch) {
        return  ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z');
    }
}