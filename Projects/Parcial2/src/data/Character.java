// Carlos Andrés Ordóñez Cerón

package data;

public abstract class Character {
	protected String characterID;
	protected int level;
	protected int gold;
	protected String weaponsGroup;
	
	public Character(String characterID, int level, int gold) {
		this.characterID = characterID;
		this.level = level;
		this.gold = gold;
		if(this.gold == 0 || this.level == 0) {
			this.weaponsGroup = "nothing";
		} else {
			this.weaponsGroup = weaponsToUse(level,gold);
		}
	}
	
	@Override
	public String toString() {
		return characterID + ", " +  weaponsGroup;
	}
	
	public int getGold() {
		return gold;
	}
	
	public abstract String weaponsToUse(int level, int gold);
}
