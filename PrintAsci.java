//Print ascii values of all alphabets lower and upper case
public class PrintAsci {

        public static void main(String[] args){
                char null_char = '\0';
                for(char c='a'; c<='z';c++){
                        int value = c - null_char;
                        System.out.println(c + " == "+ value);
                }
                for(char c='A'; c<='Z'; c++){
                        int value = c -null_char;
                        System.out.println(c + " == " + value);
                }
        }
}
