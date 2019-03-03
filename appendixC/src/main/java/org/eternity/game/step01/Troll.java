package org.eternity.game.step01;

public class Troll extends Monster {
	public Troll() {
		super(48);
	}

	@Override
	public String getAttack() {
		return "트롤은 곤봉으로 때린다";
	}
}
