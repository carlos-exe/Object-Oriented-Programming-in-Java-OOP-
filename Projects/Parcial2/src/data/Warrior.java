// Carlos Andrés Ordóñez Cerón

package data;

public class Warrior extends Character{
	public Warrior(String characterID, int level, int gold) {
		super(characterID,level,gold);
	}
	
	@Override
	public String weaponsToUse(int level, int gold) {
		if(level>3 & gold>50) {
			return "spears";
		} else if(level<=5 & gold>30) {
			return "daggers";
		} else {
			return "crossbows";
		}
	}
}
