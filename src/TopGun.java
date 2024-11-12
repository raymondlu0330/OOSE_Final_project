import java.util.List;
import java.util.Random;

public class TopGun {
    public static void main(String[] args) {
        System.out.println("\n[Top Gun Story Begin...]\n");

        //Singleton Pattern : Maverick
        Maverick maverick = Maverick.getInstance();
        System.out.println("-----------------------------------------------------");
        maverick.leadMission();
        System.out.println("-----------------------------------------------------");

        Trainee goose = new Trainee("Goose Jr.");
        Trainee phonix = new Trainee("Phoenix");
        Trainee rocket = new Trainee("Rocket");


        maverick.addTrainee(goose);
        maverick.addTrainee(phonix);
        maverick.addTrainee(rocket);
        System.out.println(" ");

        PilotSkills basic = new BasicPilotSkills();
        System.out.println("-----------------------------------------------------");
        maverick.trainTrainees(basic);
        System.out.println("-----------------------------------------------------");
        maverick.trainTrainee(goose, new HighAltitudeSkill(new LowAltitudeSkill(basic)));
        System.out.println(" ");
        maverick.trainTrainee(phonix, new LowAltitudeSkill(new NightFlight(basic)));
        System.out.println(" ");
        maverick.trainTrainee(rocket, new NightFlight(new HighAltitudeSkill(basic)));

        System.out.println("-----------------------------------------------------");
        //Strategy Pattern Training Strategy
        maverick.setTrainingStrategy(new HighAltitudeInterception());

        maverick.removeTrainee(rocket);
        System.out.println(" ");
        maverick.setTrainingStrategy(new LowAltitudePenetration());

        maverick.addTrainee(rocket);
        maverick.removeTrainee(goose);
        System.out.println(" ");
        maverick.setTrainingStrategy(new NightCombat());

        maverick.addTrainee(goose);

        System.out.println("Current Status:");
        System.out.println(goose);
        System.out.println(phonix);
        System.out.println(rocket);
        System.out.println("-----------------------------------------------------");


        //Observer Pattern : Flight Mission
        MissionControl missionControl = new MissionControl();
        FlightMission mission = new FlightMission();
        mission.addObserver(missionControl);
        mission.startMission();
        System.out.println(" ");


        Random rand = new Random();
        //Composite Pattern : Mission Component
        MissionComponent mission1986 = new SingleMission("INDIAN_OCEAN", 195);
        mission1986.setMaverickInvolved(true);
        mission1986.addTrainee(goose);

        MissionComponent mission2022 = new SingleMission("DARK_STAR", 275);
        mission2022.setMaverickInvolved(true);
        mission2022.addTrainee(goose);
        mission2022.addTrainee(phonix);

        MissionComponent missioin2077 = new SingleMission("CYBER_WORLD", 375);
        missioin2077.setMaverickInvolved(false);
        missioin2077.addTrainee(goose);
        missioin2077.addTrainee(phonix);
        missioin2077.addTrainee(rocket);


        MissionGroup missionGroup = new MissionGroup();
        missionGroup.addMission(mission1986);
        missionGroup.addMission(mission2022);
        missionGroup.addMission(missioin2077);
        System.out.println("Missions: " + missionGroup);

        missionGroup.start();
        System.out.println(" ");

        missionGroup.complete();
        System.out.println("-----------------------------------------------------");
        mission.completeMission();
    }
}











