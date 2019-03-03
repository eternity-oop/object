package org.eternity.variance;

public class Orderer {
    private Book book;

    public void order(BookStall bookStall) {
        this.book = bookStall.sell(new IndependentPublisher());
    }

    public static void main(String [] args) {
        new Orderer().order(new BookStall());
        new Orderer().order(new MagazineStore());
    }
}
