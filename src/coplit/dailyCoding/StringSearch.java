package coplit.dailyCoding;

import java.util.List;

public class StringSearch {
    public static int getMaximumRemovals(List<Integer> order, String source, String target) {
        // Write your code here

        char[] chars = source.toCharArray();
        char[] targetChars = target.toCharArray();
        for (int i=0; i<order.size(); i++) {
            chars[order.get(i)-1] = '-';
            int now = 0;
            for (char ch : chars) {
                if (targetChars[now] == ch) now++;
                if (now == targetChars.length) break;
            }
            if (now != targetChars.length) return i;
    }
        return -1;
}

}
