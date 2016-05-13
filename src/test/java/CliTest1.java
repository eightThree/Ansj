/**
 * Created by zhanghong on 2015/1/23.
 */
public class CliTest1 {
    public static void main(String[] args) {
        int firstArg,secondArg;
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
                secondArg = Integer.parseInt(args[1]);
                System.out.println(firstArg+secondArg);
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer");
                System.exit(1);
            }
        }
    }
}
