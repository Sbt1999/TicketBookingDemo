package demo;

import service.TicketService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TicketBookingDemo {
    public static void main(String[] args) throws InterruptedException{
        TicketService ticketService = new TicketService(10);

        ExecutorService pool = Executors.newFixedThreadPool(10);


        for(int i = 0; i < 15; i++){
            pool.execute(() -> {
                boolean ok = ticketService.bookTicket();
                System.out.println(ok ? "Booked" : "Sold-out ");
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.printf("Final → available=%d, booked=%d%n",
                ticketService.remaining(), ticketService.booked());
    }
}
