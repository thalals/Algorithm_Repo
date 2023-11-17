package 해쉬.level2_전화번호_목록;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution(new String[]{"119", "97674223", "1195524421"}), false);
        Assertions.assertEquals(solution(new String[]{"123","456","789"}), true);
        Assertions.assertEquals(solution(new String[]{"12","123","1235","567","88"}), false);
    }

    public boolean solution(String[] phone_book) {

        String[] sortedPhoneBook = Arrays.stream(phone_book)
            .sorted(Comparator.comparing(String::length)).toArray(String[]::new);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], i);
        }

        for (int i = 0; i < sortedPhoneBook.length; i++)
            for (int j = 0; j < sortedPhoneBook[i].length(); j++)
                if (map.containsKey(sortedPhoneBook[i].substring(0, j)))
                    return false;

        return true;
    }
}
