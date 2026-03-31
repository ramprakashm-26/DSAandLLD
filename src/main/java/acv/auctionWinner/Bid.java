package acv.auctionWinner;

import java.math.BigDecimal;

public record Bid(
        String userId,
        BigDecimal amount,
        long timestamp) {}
