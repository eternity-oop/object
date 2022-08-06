package org.eternity.game.step02;

public class Monster {
	private Breed breed;
	
	public Monster(Breed breed) {
		this.breed = breed;
	}
	
	public String getAttack() {
		return breed.getAttack();
	}
}

