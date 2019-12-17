package chapter_7;

import java.util.Date;
import java.util.LinkedList;

/**
 * Parking Lot
 *
 * Design a parking lot using object-oriented principles.
 *
 */
public class Task_4 {

    public static void main(String[] args) { }

    public static class ParkingLot {
        public int FREE_PARKING_TIME = 2 * 60 * 60 * 1000;
        public int PAID_EXIT_TIME = 15 * 60 * 1000;

        LinkedList<ParkingPlace> free;
        LinkedList<ParkingPlace> busy;

        // what we should do if we haven't free space?
        public ParkingTicket getTicket() {
            if (free.isEmpty()) return null;

            // how we should select places
            ParkingPlace place = free.getLast();

            return new ParkingTicket((place));
        }

        public void paid(ParkingTicket ticket) {
            // paid process, if successful
            ticket.paid();
        }

        public void exit(ParkingTicket ticket) {
            if (!ticket.isPaid() || (new Date().getTime() - ticket.paidAt().getTime() >= PAID_EXIT_TIME) ) {
                // raise error, or show message,
            }

            // open barrier
        }
    }

    public static class ParkingPlace {
        private int number;
    }

    public static class ParkingTicket {
        ParkingPlace place;
        Date issueTime;
        Date paidAt;

        public ParkingTicket(ParkingPlace place) {
            this.place = place;
            issueTime = new Date();
        }

        public Date paidAt() {
            return paidAt;
        }

        public boolean isPaid() {
            return paidAt != null;
        }

        public void paid() {
            paidAt = new Date();
        }
    }
}