package service;

import model.TicketInventory;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketService {
    private final TicketInventory inventory;
    private final AtomicInteger booked = new AtomicInteger();

    public TicketService(int initialStock) {
        this.inventory = new TicketInventory(initialStock);
    }

    public boolean bookTicket(){
        return inventory.bookOne();
    }


    public int remaining(){
        return inventory.getAvailable();
    }

    public int booked(){
        return booked.get();
    }
}
