package dsa.backTracking.practice;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        int noOfLedsTurnedOn = 2;
        int[] hours = {1, 2, 4, 8};
        int[] minutes = {1, 2, 4, 8, 16, 32};
        List<String> result = new ArrayList<>();
        backtracking(noOfLedsTurnedOn, 0, 0, 0, hours, minutes, result);
        System.out.println(result);
        result = new ArrayList<>();
        backtrackingWithBitOperator(noOfLedsTurnedOn, 0, 0, 0, result);
        System.out.println(result);
    }

    private static void backtracking(int ledsLeft, int index, int hourSum, int minuteSum, int[] hours,
                                     int[] minutes, List<String> result) {
        if (ledsLeft == 0) {
            if (hourSum <= 11 && minuteSum <= 59) {
                String time = hourSum + ":" + (minuteSum < 10 ? "0" + minuteSum : minuteSum);
                result.add(time);
            }
            return;
        }
        for (int i = index; i < hours.length + minutes.length; i++) {
            if (i < 4) {
                backtracking(ledsLeft - 1, i + 1, hourSum + hours[i], minuteSum, hours,
                        minutes, result);
            } else {
                backtracking(ledsLeft - 1, i + 1, hourSum, minuteSum + minutes[i - 4],
                        hours, minutes, result);
            }
        }
    }

    //OR

    private static void backtrackingWithBitOperator(int ledsLeft, int index, int hour, int minute,
                                                    List<String> result) {

        if (ledsLeft == 0) {
            if (hour > 11 && minute > 59) {
                return;
            }
            result.add(String.format("%d:%02d", hour, minute));
            return;
        }
        for (int i = index; i < 10; i++) {
            if (i < 4) {
                backtrackingWithBitOperator(ledsLeft - 1, i + 1, hour + (1 << i),
                        minute, result);
            } else {
                backtrackingWithBitOperator(ledsLeft - 1, i + 1, hour, minute + (1 << (i - 4)),
                        result);
            }
        }
    }
}
