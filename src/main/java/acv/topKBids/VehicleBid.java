package acv.topKBids;

public record VehicleBid(
        String userId,
        String vehicleId,
        double amount,
        long timeStamp
) {
}
