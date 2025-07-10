package model;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketInventory {
    private final Semaphore seats;
    private final AtomicInteger booked = new AtomicInteger();

    public TicketInventory(int initialStock){
        this.seats = new Semaphore(initialStock, true);
    }

    public boolean bookOne(){
        if(seats.tryAcquire()){
            booked.incrementAndGet();
            return true;
        }
        return false;
    }

    public int getAvailable(){
        return seats.availablePermits();
    }

    public int getBooking(){
        return booked.get();
    }
}
