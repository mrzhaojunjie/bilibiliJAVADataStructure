package 栈;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中缀表达式转后缀
public class MidToBack {
    public static int operation(String operator) {
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        return 0;
    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            //如果是一个数字  就加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); // 消除括号
            } else {
                //当item的优先级小于等于栈顶运算符的优先级
                while (s1.size() != 0 && operation(s1.peek()) >= operation(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //将s1剩余运算符加入到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;

    }

    public static List<String> toInfixExpression(String s) {
        //定义一个list用来存放中缀表达式的内容
        List<String> ls = new ArrayList<>();
        int i = 0;//用于遍历s
        String str;//用来对对位数的拼接
        char c;
        do {
            //若c为非数字
            if (!Character.isDigit(c = s.charAt(i))) {
                ls.add("" + c);
                i++;
            } else { // 如果是一个数字，需要考虑多位数
                str = "";
                while (i < s.length() && Character.isDigit(c = s.charAt(i))) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpression(expression);
        System.out.println("中缀表达式为" + infixExpressionList);
        System.out.println("后缀表达式（逆波兰表达式）为" + parseSuffixExpressionList(infixExpressionList));
    }
}

