/**
 * StringSpeed - COMPLETED (stretch task)
 * Question: does building a String with += cost more time than StringBuilder?
 * Run it, record both times, and explain the difference in one sentence.
 *
 * Explanation: += is much slower because Strings are immutable, so every +=
 * creates a brand-new String and copies all the old characters into it, while
 * StringBuilder changes one object in place and just adds to the end.
 */
public class StringSpeed {

    public static void main(String[] args) {
        int n = 20000;

        // 1. Build a long String with += (given)
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "t";
        }
        long plusTime = System.nanoTime() - start;

        // 2. Build the same text with a StringBuilder.
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("t");
        }
        String t = sb.toString();
        long builderTime = System.nanoTime() - start;

        System.out.println("Same text? " + s.equals(t));
        System.out.println("+= time (ms): " + plusTime / 1_000_000.0);
        System.out.println("StringBuilder time (ms): " + builderTime / 1_000_000.0);
    }
}
