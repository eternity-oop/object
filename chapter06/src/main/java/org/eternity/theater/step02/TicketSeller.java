package org.eternity.theater.step02;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void setTicket(Audience audience) {
        ticketOffice.plusAmount(audience.setTicket(ticketOffice.getTicket()));
    }
}
