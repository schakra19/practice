//Print ascii values of all alphabets lower and upper case
public class PrintAsci {

        public static void main(String[] args){
                char a = '\0';
                for(char c='a'; c<='z';c++){
                        int value = c - a;
                        System.out.println(c + " == "+ value);
                }
                for(char c='A'; c<='Z'; c++){
                        int value = c -a;
                        System.out.println(c + " == " + value);
                }
        }
}
