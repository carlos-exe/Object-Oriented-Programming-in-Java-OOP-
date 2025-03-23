// Carlos Andrés Ordóñez Cerón

package data;

public class Support extends Character{
	public Support(String characterID, int level, int gold) {
		super(characterID,level,gold);
	}
	
	@Override
	public String weaponsToUse(int level, int gold) {
		if(this.level>11 & this.gold>110) {
			return "coats";
		} else if(this.level<=5 & this.gold>70) {
			return "catapults";
		} else {
			return "shields";
		}
	}
}
