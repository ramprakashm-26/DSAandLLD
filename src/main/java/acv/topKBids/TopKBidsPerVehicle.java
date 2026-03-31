package acv.topKBids;

import java.util.*;

public class TopKBidsPerVehicle {

    private final Map<String, PriorityQueue<VehicleBid>> map;
    private final int K;

    public TopKBidsPerVehicle(int k) {
        this.map = new HashMap<>();
        this.K = k;
    }

    public void placeBid(VehicleBid bid) {
        if (bid == null || bid.amount() <= 0) return;

        PriorityQueue<VehicleBid> heap = map.computeIfAbsent(
                bid.vehicleId(),
                v -> new PriorityQueue<>((a, b) -> {
                    int cmp = Double.compare(a.amount(), b.amount());
                    if (cmp != 0) return cmp;

                    return Long.compare(b.timeStamp(), a.timeStamp());
                })
        );

        if (heap.size() < K) {
            heap.offer(bid);
        } else {
            VehicleBid worst = heap.peek();
            if (isBetter(bid, worst)) {
                heap.poll();
                heap.offer(bid);
            }
        }
    }

    public List<VehicleBid> getTopK(String vehicleId) {
        PriorityQueue<VehicleBid> heap = map.get(vehicleId);
        if (heap == null || heap.isEmpty()) {
            return Collections.emptyList();
        }

        List<VehicleBid> result = new ArrayList<>(heap);
        result.sort((a, b) -> {
            int cmp = Double.compare(b.amount(), a.amount());
            if (cmp != 0) return cmp;

            return Long.compare(a.timeStamp(), b.timeStamp());
        });

        return result;
    }

    private boolean isBetter(VehicleBid a, VehicleBid b) {
        if (a.amount() > b.amount()) return true;
        return a.amount() == b.amount() && a.timeStamp() < b.timeStamp();
    }

    public static void main(String[] args) {
        TopKBidsPerVehicle service = new TopKBidsPerVehicle(3);

        service.placeBid(new VehicleBid("u1", "v1", 100, 5));
        service.placeBid(new VehicleBid("u2", "v1", 100, 3));
        service.placeBid(new VehicleBid("u3", "v1", 150, 2));
        service.placeBid(new VehicleBid("u4", "v1", 200, 1));
        service.placeBid(new VehicleBid("u5", "v1", 50, 6));

        System.out.println("Top K: " + service.getTopK("v1"));
    }
}
