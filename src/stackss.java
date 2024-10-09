import java.util.Stack;

public class stackss {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            // Opening brackets
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }
            // Closing brackets
            else {
                if(s.isEmpty()){  // If there's no matching opening bracket
                    return false;
                }
                // Check if the top of the stack matches the current closing bracket
                if( (s.peek() == '(' && ch == ')') ||
                        (s.peek() == '{' && ch == '}') ||
                        (s.peek() == '[' && ch == ']')) {
                    s.pop();  // Pop the matching opening bracket
                } else {
                    return false;  // Mismatched bracket
                }
            }
        }

        // After the loop, if the stack is empty, all brackets are matched
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "({})[]";  //true
        System.out.println(isValid(str));
    }
}
