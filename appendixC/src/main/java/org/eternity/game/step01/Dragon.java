package org.eternity.game.step01;

public class Dragon extends Monster {
	public Dragon() {
		super(230);
	}

	@Override
	public String getAttack() {
		return "용은 불을 내뿜는다";
	}
}
