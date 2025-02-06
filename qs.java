import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

interface IBookable {
    void book();
    void cancel();
}
interface IChargeable {
    double calculatePrice(int days);
}
abstract class Room implements IBookable, IChargeable{
    private int roomNumber;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    @Override
    public void book() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " has been booked.");
        } else
            System.out.println("Room " + roomNumber + " is already booked.");
    }
    @Override
    public void cancel() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Room " + roomNumber + " booking has been canceled.");
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }
    @Override
    public abstract double calculatePrice(int days);

    public String displayDetails() {
        return "Room Number: " + roomNumber + ", Price per Night: $" +
                pricePerNight + ", Available: " + isAvailable;
    }

    protected double getPricePerNight() {
        return pricePerNight;
    }
}
class SingleRoom extends Room {
    public SingleRoom(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public double calculatePrice(int days) {
        return getPricePerNight() * days;
    }
}

class Suite extends Room {
    public Suite(int roomNumber, double pricePerNight) {
        super(roomNumber, pricePerNight);
    }

    @Override
    public double calculatePrice(int days) {
        double luxuryTax = 50.0;
        return (getPricePerNight() + luxuryTax) * days;
    }
}
class PricePerNightComparator implements Comparator<Room> {
    @Override
    public int compare(Room r1, Room r2) {
        return Double.compare(r1.getPricePerNight(), r2.getPricePerNight());
    }
}
public class qs {
    public static void main(String[] args) {
        SingleRoom room1 = new SingleRoom(101, 120.0);
        SingleRoom room2 = new SingleRoom(102, 100.0);
        SingleRoom room3 = new SingleRoom(103, 150.0);

        LinkedList<SingleRoom> singleRooms = new LinkedList<>();
        singleRooms.add(room1);
        singleRooms.add(room2);
        singleRooms.add(room3);

        Collections.sort(singleRooms, new PricePerNightComparator());
        System.out.println("Rooms sorted by price per night:");
        for (SingleRoom room : singleRooms) {
            System.out.println(room.displayDetails());
        }
    }
}