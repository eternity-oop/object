package org.eternity.variance;

public class BookStall {
    public Book sell(IndependentPublisher independentPublisher) {
        return new Book(independentPublisher);
    }
}
