import java.util.Scanner;

/**
 * An application class which reads lines of input from stdin
 * and handles it based on the choices given in the table below.
 *
 * @author xsol05
 */
public class QueueApp<E> {

    /**
     * Main method for testing.
     *
     * @param args Command line inputs not used
     */
    public static void main(String[] args) {

        TwoStackQueue<String> queue = new TwoStackQueue<>();

        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            Scanner wordScan = new Scanner(scan.nextLine());
            String arg = wordScan.next();
            switch (arg) {
                case "a":
                    while (wordScan.hasNext()) {
                        queue.add(wordScan.next());
                    }
                    break;
                case "c":
                    queue.clear();
                    break;
                case "d":
                    System.out.println(queue.debug());
                    break;
                case "g":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.get());
                    }
                    break;
                case "p":
                    System.out.println(queue.toString());
                    break;
                case "r":
                    if (!queue.isEmpty()) {
                        System.out.println(queue.remove());
                    }
                    break;
                case "s":
                    System.out.println(queue.size());
                    break;
            }
        }
    }
}
