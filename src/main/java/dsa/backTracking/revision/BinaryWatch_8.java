package org.dsa.backTracking.revision;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch_8 {
    public static void main(String[] args) {
        int turnedOn = 9;
        System.out.println(getTime(turnedOn));
    }

    private static List<String> getTime(int turnedOn) {
        List<String> result = new ArrayList<>();
        int[] hours = {1, 2, 4, 8};
        int[] minutes = {1, 2, 4, 8, 16, 32};
        backtrack(turnedOn, hours, minutes, 0, 0, 0, result);
        return result;
    }

    private static void backtrack(int turnedOn, int[] hours, int[] minutes, int hourSum, int minuteSum,
                                  int index, List<String> result) {
        if (turnedOn == 0 && hourSum <= 11 && minuteSum <= 59) {
            result.add(String.format("%d:%02d", hourSum, minuteSum));
            return;
        }
        if (turnedOn < 0) {
            return;
        }
        for (int i = index; i < 10; i++) {
            if (i < 4) {
                backtrack(turnedOn - 1, hours, minutes, hourSum + hours[i], minuteSum,
                        i + 1, result);
            } else {
                backtrack(turnedOn - 1, hours, minutes, hourSum, minuteSum + minutes[i - 4],
                        i + 1, result);
            }
        }
    }
}
