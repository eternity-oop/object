package org.eternity.game;

public interface Collidable extends Displayable {
    boolean collideWith(Collidable other);
}
