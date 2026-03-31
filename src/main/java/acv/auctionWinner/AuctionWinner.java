package acv.auctionWinner;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicReference;

public class AuctionWinner {
    public static void main(String[] args) {
        AuctionWinner auctionWinner = new AuctionWinner();
        auctionWinner.placeBid(new Bid("id", BigDecimal.TEN, 11));
        auctionWinner.placeBid(new Bid("id", BigDecimal.TEN, 10));
        auctionWinner.placeBid(new Bid("id", BigDecimal.valueOf(100.0), 10));
        System.out.println(auctionWinner.getCurrentWinner());
    }

    private final AtomicReference<Bid> currentWinner = new AtomicReference<>();

    public void placeBid(Bid newBid) {
        if (newBid == null || newBid.amount().doubleValue() <= 0) return;

        while (true) {
            Bid current = currentWinner.get();

            if (current == null) {
                if (currentWinner.compareAndSet(null, newBid)) {
                    return;
                }
                continue;
            }

            if (newBid.amount().compareTo(current.amount()) > 0) {
                if (currentWinner.compareAndSet(current, newBid)) {
                    return;
                }
                continue;
            }

            if (newBid.amount().equals(current.amount()) &&
                    newBid.timestamp() < current.timestamp()) {

                if (currentWinner.compareAndSet(current, newBid)) {
                    return;
                }
                continue;
            }
            return;
        }
    }

    public Bid getCurrentWinner() {
        return currentWinner.get();
    }
}
