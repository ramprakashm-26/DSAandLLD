package hapagLloyd.problems;

import java.util.*;

public class SyntaxBracketCheck {
    public static void main(String[] args) {
        List<String> corrupted = List.of(
                "[()]",
                "(]",
                "{()}",
                "[(])");
        System.out.println("Illegal bracket scores: " + syntaxErrorScore(corrupted));

        List<String> incompletes = List.of(
                "[(",
                "{[",
                "(]",
                "<"
        );
        System.out.println("Incomplete fix median score: " + fixIncompleteBracketScore(incompletes));
    }

    private static int syntaxErrorScore(List<String> lines) {
        int score = 0;
        Map<Character, Integer> scores = Map.of(
                ')', 3,
                ']', 57,
                '}', 1197,
                '>', 25137
        );
        for (String str : lines) {
            Deque<Character> stack = new ArrayDeque<>();
            Character illegal = null;
            for (char ch : str.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        illegal = ch;
                        break;
                    }
                    char previous = stack.pop();
                    if (!((previous == '(' && ch == ')') || (previous == '{' && ch == '}')
                            || (previous == '[' && ch == ']') || (previous == '<' && ch == '>'))) {
                        illegal = ch;
                        break;
                    }
                }
            }
            if (illegal != null) {
                score += scores.get(illegal);
            }
        }
        return score;
    }

    //score = score * 5 + value
    private static long fixIncompleteBracketScore(List<String> lines) {
        Map<Character, Integer> scores = Map.of(
                ')', 1,
                ']', 2,
                '}', 3,
                '>', 4
        );
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (String str : lines) {
            long score = 0;
            Deque<Character> stack = new ArrayDeque<>();
            boolean isCorrupted = false;
            for (char ch : str.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[' || ch == '<') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        isCorrupted = true;
                        break;
                    }
                    char previous = stack.pop();
                    if (!((previous == '(' && ch == ')') || (previous == '{' && ch == '}')
                            || (previous == '[' && ch == ']') || (previous == '<' && ch == '>'))) {
                        isCorrupted = true;
                        break;
                    }
                }
            }
            if (!isCorrupted || stack.isEmpty()) {
                continue;
            }
            while (!stack.isEmpty()) {
                char previous = stack.pop();
                score = switch (previous) {
                    case '(' -> score * 5 + scores.get(')');
                    case '[' -> score * 5 + scores.get(']');
                    case '{' -> score * 5 + scores.get('}');
                    case '<' -> score * 5 + scores.get('>');
                    default -> 0;
                };
            }
            minHeap.offer(score);
        }
        int median = minHeap.size() / 2;
        int idx = 0;
        while (!minHeap.isEmpty() && idx < median) {
            minHeap.poll();
            idx++;
        }
        return minHeap.poll();
    }
}
