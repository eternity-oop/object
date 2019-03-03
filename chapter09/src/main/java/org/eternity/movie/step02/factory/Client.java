package org.eternity.movie.step02.factory;

import org.eternity.money.Money;
import org.eternity.movie.step01.Movie;

public class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee() {
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }
}
