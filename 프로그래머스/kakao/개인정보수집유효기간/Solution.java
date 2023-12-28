package kakao.개인정보수집유효기간;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    @Test
    public void test() {

        Assertions.assertEquals(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}), List.of(1,3));
    }

    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new LinkedList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

        LocalDate now = LocalDate.parse(today, formatter);

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            termsMap.put(s[0], Integer.parseInt(s[1]));
        }

        int index = 1;

        for (String privacie : privacies) {

            String[] split = privacie.split(" ");

            int limitMonth = termsMap.get(split[1]);
            LocalDate date = LocalDate.parse(split[0], formatter);

            if (!now.minusMonths(limitMonth).isBefore(date)) {
                answer.add(index);
            }

            index++;
        }

        return answer;
    }
}
