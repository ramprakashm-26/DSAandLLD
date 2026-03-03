package org.dsa.monotonicStack;

import java.util.Stack;

public class StockSpanner {
    Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.pop().span;
        }
        stack.push(new Pair(price, span));
        return span;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        for (int price : prices) {
            int span = stockSpanner.next(price);
            System.out.println("Stock price %s with span %s".formatted(price, span));
        }
    }

    static class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }
}
