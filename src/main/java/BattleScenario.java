public class BattleScenario {

    Mascotmon mon1;
    Mascotmon mon2;
    Mascotmon aMon;
    Mascotmon dMon;
    Stats mon1Stats;
    Stats mon2Stats;
    Environment battleWeather;

    public BattleScenario(Mascotmon pMon1, Mascotmon pMon2) {
        setMon1(pMon1);
        setMon2(pMon2);
    } 

    /**
     * Sets environment of the battlefield, and sets buff/debuff modifiers for all Mascotmons on the
     * field. If the Mascotmon's type is buffed by the environment,they receive a 25% multiplier to
     * their attack and defense stat. If the Mascotmon's type is debuffed by the environment, they
     * receive a reduction of 25% to their attack and defense stat.
     * @param pWeather is the weather enum to use from Environment class
     */
    public void setEnvironment(Environment.Weather pWeather) {
        battleWeather = new Environment(pWeather);
    }

    public void initiateBattle() {

        // initiate stats for mon1 and mon2
        mon1Stats = new Stats(mon1.name);
        mon2Stats = new Stats(mon2.name);
        System.out.println("Woooo: " + mon1Stats.health);

        System.out.println("\nWelcome everyone to the Mascotmon training arena!");
        System.out.println("It is a " + battleWeather.WEATHER.toString().toLowerCase()   + " day here at Frank Kush Field");
        System.out.println("Today, on the attacking team we have " + mon1.name + " " +  mon1.description);
        System.out.println("Their opponent, on the defending team is " + mon2.name + " " +  mon2.description);
        System.out.println(mon2.name + " prepares for the incoming attack");

        Mascotmon winner = fight();
        System.out.println(winner.name + " has won with " + winner.stats.health + " health left");
    }

    /**
     * Sample fight scenario of two rounds.
     * Each Mascotmon uses one random attack per round; this attack multiplier is used to calculate 
     * damage output against opposing mascotmon. 
     */
    public Mascotmon fight() {
        int round = 1;
        double damage1;
        double damage2;

        Attack attack1;
        Attack attack2;

        while (true) {
            //Mon 1's turn:
            System.out.println("\n" + mon1.name + " launches an attack against " + mon2.name + "!");
            attack1 = mon1.attack();

            //Calculate damage:
            damage1 = calculateDamage(attack1, mon1, mon2);
            System.out.println(damage1 + " damage dealt");

            //Adjust mon2's health:
            mon2.stats.health = mon2.stats.health - damage1;
            System.out.println(mon2.name + " has " + mon2.stats.health + " health left");

            //Battle terminating condition:
            if (mon2.stats.health <= 0.0){
                System.out.println(mon2.name + " has fainted in round " + round);
                return mon1;
            }

            //Mon 2's turn:
            System.out.println("\n" + mon2.name  + " launches an attack against " + mon1.name + "!");
            attack2 = mon2.attack();

            //Calculate damage:
            damage2 = calculateDamage(attack2, mon2, mon1);
            System.out.println(damage2 + " damage dealt");

            //Adjust mon1's health:
            mon1.stats.health = mon1.stats.health - damage2;
            System.out.println(mon1.name + " has " + mon1.stats.health + " health left");

            //Battle terminating condition:
            if (mon1.stats.health <= 0.0){
                System.out.println(mon1.name + " has fainted in round " + round);
                return mon2;
            }
            round++;
        } //end while
    }


    public void setMon1(Mascotmon pMon){
        mon1 = pMon;
    }


    public void setMon2(Mascotmon pMon){
        mon2 =  pMon;
    }


     /**
      * This method implements the calculation of damage for one specific attack.
      * One monster attacks with the given damage, the dealt damage is then calculated through
      *        (pAttackDamage * pAttacker.weatherBonus * pAttacker.typeBonus) - (pDefender.stats.defense * pDefender.weatherBonus * pDefender.typeBonus)
      * 
      * If the initial pAttackDamage is 0, then the damage dealt is 0. 
      * 
      * If the totalDamage calculated is negative, the totalDamage dealt should be 1. 
      * 
      * Any positive value is the total damage dealt.
      * 
      * Weather bonus: see the Environment which you can assume is correct. You need to check though if the weather bonus is applied 
      * correctly, since maybe the method does not use the environment correctly. 
      * or debuffed based on the weather. EG. fire monsters have a stat advantage of +25% in sunny weather
      * while they have a stat disadvantage of -25% in the rain.
      * If the attack chosen, matches the monsters type, the attacker will get an extra 20% on its attack.
      * Type bonus: Certain monsters have an attack bonus against others:
      *     Fire against Water: Water gains 25% while Fire looses 25%
      *     Fire against Ground: Fire gains 25% while Ground looses 25%
      *     Ground against Water: Ground gains 25% while Water looses 25%
      *     Normal mon: never gain any type bonus and are weaker during droughts.
      * These bonuses do not stack up, they are just applied for every attack. 
      * @param pAttack is the attack value given to the method where that attack value is based on the 
      *                 monsters damage value
      * @param pAttacker the attacking monster
      * @param pDefender the defending monster (the defending monster will never get damage)
      * to calculate damage output.
      * @return total damage output
      */
    public double calculateDamage(Attack pAttack, Mascotmon pAttacker, Mascotmon pDefender) {
    	
    	/**
    	String aName = pAttacker.name.toString();
    	String dName = pDefender.name.toString();
    	if (aName == "ALBERT") { // Attacker type is WATER
    		if (dName == "SPARKY") {  // Defender type is FIRE
    			//CASE WATER offense VS FIRE defense
    			
    		} else if (dName == "RALPHIE") {  // Defender type is GROUND
    			//CASE WATER offense VS GROUND defense

    			
    		} else  {  // Defender type is NORMAL
    			//CASE WATER offense VS NORMAL defense

    			
    		}
    			
    		
    	} else if (aName == "SPARKY") { // Attacker type is FIRE
    		if (dName == "ALBERT") {  // Defender type is WATER
    			//CASE FIRE offense VS WATER defense
    			
    		} else if (dName == "RALPHIE") {  // Defender type is GROUND
    			//CASE FIRE offense VS GROUND defense

    			
    		} else  {  // Defender type is NORMAL
    			//CASE FIRE offense VS NORMAL defense

    			
    		}
    		
    		
    		
    	} else if (aName == "RALPHIE") {// Attacker type is GROUND
    		if (dName == "ALBERT") {  // Defender type is WATER
    			//CASE GROUND offense VS WATER defense
    			
    		} else if (dName == "SPARKY") {  // Defender type is FIRE
    			//CASE GROUND offense VS FIRE defense

    			
    		} else  {  // Defender type is NORMAL
    			//CASE GROUND offense VS NORMAL defense

    			
    		}
    		
    	} else { // Attacker type is NORMAL
    		if (dName == "ALBERT") {  // Defender type is WATER
    			//CASE NORMAL offense VS XXX defense
    			
    		} else if (dName == "RALPHIE") {  // Defender type is GROUND
    			//CASE NORMAL offense VS XXX defense

    			
    		} else if (dName == "SPARKY") {  // Defender type is FIRE
    			//CASE NORMAL offense VS FIRE defense

    			
    		}
    	}
 */
    	aMon = pAttacker;
    	dMon = pDefender;
    	double damageDealt = pAttack.damage;
    	
    	if (aMon.type.equals("Fire")) {									//FIRE ATTACKING
    		if (dMon.type.equals("Water")) {
    			damageDealt = damageDealt * 0.75;
    		}    		
    		if (dMon.type.equals("Ground")) {
    			damageDealt = damageDealt * 1.25;
    		}
    		if (battleWeather.WEATHER.toString().equals("rainy")) {
    			damageDealt = damageDealt * 0.75;
    		}
    		if (battleWeather.WEATHER.toString().equals("sunny")) {
    			damageDealt = damageDealt * 1.25;
    		}
    	}
    	if (aMon.type.equals("Water")) {								//WATER ATTACKING
    		if (dMon.type.equals("Fire")) {
    			damageDealt = damageDealt * 1.25;
    		}    		
    		if (dMon.type.equals("Ground")) {
    			damageDealt = damageDealt * 0.75;
    		}
    		if (battleWeather.WEATHER.toString().equals("rainy")) {
    			damageDealt = damageDealt * 1.25;
    		}
    		if (battleWeather.WEATHER.toString().equals("sunny")) {
    			damageDealt = damageDealt * 0.75;
    		}
    	}
    	if (aMon.type.equals("Ground")) {									//GROUND ATTACKING
    		if (dMon.type.equals("Fire")) {
    			damageDealt = damageDealt * 0.75;
    		}    		
    		if (dMon.type.equals("Water")) {							
    			damageDealt = damageDealt * 1.25;
    		}
    		if (battleWeather.WEATHER.toString().equals("drought")) {	
    			damageDealt = damageDealt * 1.25;
    		}
    	}
    	if (aMon.type.equals("Normal")) { 									//NORMAL ATTACKING
    		if (battleWeather.WEATHER.toString().equals("drought")) {
    			damageDealt = damageDealt * 0.25;
    		}
    	}
    	
    	
    	
    	
    	
    	
    	
    	/**
    	
    	if ( (aMon.type.equals("Fire") && dMon.type.equals("Water")) || (aMon.type.equals("Water") && dMon.type.equals("Fire"))) { 		//WATER VS FIRE
    		if (aMon.type.equals("Fire")){
    			damageDealt = damageDealt * 0.75;
    		}
    		if (aMon.type.equals("Water")){
    			damageDealt = damageDealt * 1.25;
    		}
    		
    		
    		
            if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }

            
            
            
    		
    	} else if ( (aMon.type.equals("Water") && dMon.type.equals("Ground")) || (aMon.type.equals("Ground") && dMon.type.equals("Water"))) { 		//WATER VS GROUND
    		if (aMon.type.equals("Ground")){
    			damageDealt = damageDealt * 1;
    		}
    		if (aMon.type.equals("Water")){
    			damageDealt = damageDealt * 1;
    		}
    		
    		
            if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }

            
            
            
            
    	} else if ( (aMon.type.equals("Water") && dMon.type.equals("Normal")) || (aMon.type.equals("Normal") && dMon.type.equals("Water"))) { 		//WATER VS NORMAL
    		if (aMon.type.equals("Normal")){
    			damageDealt = damageDealt * 1;
    		}
    		if (aMon.type.equals("Water")){
    			damageDealt = damageDealt * 1;
    		}
    		
    		
    		
    		
    		if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }

    		
    		
    		
    		
    		
    		
    		
    	} else if ( (aMon.type.equals("Fire") && dMon.type.equals("Ground")) || (aMon.type.equals("Ground") && dMon.type.equals("Fire"))) { 		//FIRE VS GROUND
    		if (aMon.type.equals("Ground")){
    			damageDealt = damageDealt * 0.75;
    		}
    		if (aMon.type.equals("Fire")){
    			damageDealt = damageDealt * 1.25;
    		}

    		
    		
    		
            if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }
            

    	} else if ( (aMon.type.equals("Fire") && dMon.type.equals("Normal")) || (aMon.type.equals("Normal") && dMon.type.equals("Fire"))) { 		//FIRE VS NORMAL
    		if (aMon.type.equals("Normal")){
    			damageDealt = damageDealt * 1;
    		}
    		if (aMon.type.equals("Fire")){
    			damageDealt = damageDealt * 1;
    		}
    		
    		
    		if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }

    		
    		
    		
    		
    	} else if ( (aMon.type.equals("Ground") && dMon.type.equals("Normal")) || (aMon.type.equals("Normal") && dMon.type.equals("Ground"))) { 		//GROUND VS NORMAL
    		if (aMon.type.equals("Normal")){
    			damageDealt = damageDealt * 1;
    		}
    		if (aMon.type.equals("Ground")){
    			damageDealt = damageDealt * 1;
    		}
    		
    		if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }

    		
    		
    		
    	} else if (aMon.type == dMon.type ) { 		//SAME TYPE
          
    		
    		if (battleWeather.WEATHER.toString().equals("sunny")){ // sunny weather
            } else if (battleWeather.WEATHER.toString().equals("rainy")){ // rainy weather
            } else if (battleWeather.WEATHER.toString().equals("drought")){ // drought weather
            } else {		// neutral
            }

    	} 




		damageDealt = damageDealt * 1;

*/
    	damageDealt = Math.round(damageDealt*0.2);
    	int dmg = (int)damageDealt;
    	

    	return dmg;
    }

}