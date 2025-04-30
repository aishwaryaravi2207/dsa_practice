import java.util.Stack;

public class Stacks {
    public static void main(String[] args){
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }
    public static int maxDepth(String s) {
        Stack<String> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            String temp = String.valueOf(s.charAt(i));
            if(temp.equals("(")){
                count++;
                stack.push(temp);
            }
            else if(temp.equals(")")){
                stack.pop();
                prev = Math.max(prev,count);
                count--;
            }
        }
        return prev;
    }
}
