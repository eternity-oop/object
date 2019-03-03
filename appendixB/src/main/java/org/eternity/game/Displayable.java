package org.eternity.game;

public interface Displayable extends GameObject {
    Point getPosition();
    void update(Graphics graphics);
}
