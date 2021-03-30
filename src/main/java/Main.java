public class Main {
    public static void main(String[] args) {

        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.RALPHIE);
        
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); //Create First battle scenario with two mons
        fight1.setEnvironment(Environment.WEATHER.sunny);  //Set the weather
        fight1.initiateBattle(); //Initiate battle
       
        System.out.println("This is the end of the training simulation");
/**
        BattleScenario fight2 = new BattleScenario(attacker2, defender2); 
        fight2.setEnvironment(Environment.Weather.rainy);
        fight2.initiateBattle();
        System.out.println("This is the end of the training simulation");
        */
    }
}
