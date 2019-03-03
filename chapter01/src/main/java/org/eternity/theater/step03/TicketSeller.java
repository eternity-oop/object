package org.eternity.theater.step03;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // 아래 코드는 책에서 설명한 것처럼 트레이드오프 후에 원래의 step02의 구현으로 복구해야 합니다.
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
