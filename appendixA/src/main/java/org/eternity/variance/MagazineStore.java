package org.eternity.variance;

public class MagazineStore extends BookStall {
    @Override
    public Magazine sell(IndependentPublisher independentPublisher) {
        return new Magazine(independentPublisher);
    }
}
