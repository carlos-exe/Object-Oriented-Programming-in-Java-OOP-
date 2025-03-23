// Carlos Andrés Ordóñez Cerón

package data;

public class Wizard extends Character{
	public Wizard(String characterID, int level, int gold) {
		super(characterID,level,gold);
	}
	
	@Override
	public String weaponsToUse(int level, int gold) {
		if(level>5 & gold>30) {
			return "axes";
		} else if(this.level<=5 & this.gold>20) {
			return "swords";
		} else {
			return "sticks";
		}
	}
}
