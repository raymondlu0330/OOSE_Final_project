import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Mission Component section
abstract class MissionComponent{
    protected boolean isMaverickInvolved;
    protected int difficulty;
    protected List<Trainee> trainees = new ArrayList<>();

    public void setMaverickInvolved(boolean isMaverickInvolved){
        this.isMaverickInvolved = isMaverickInvolved;
    }

    public abstract void start();
    public abstract void complete();
//    public int getDifficulty(){
//        return difficulty;
//    }
    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
    }
//    public List<Trainee> getTrainees() {
//        return trainees;
//    }
}

class SingleMission extends MissionComponent{
    private final String missionId;


    public SingleMission(String missionId, int difficulty){
        this.difficulty = difficulty;
        this.missionId = missionId;
    }

    public void start(){
        System.out.println("#" + missionId + " Started.\n\t *Maverick 是否加入: " + isMaverickInvolved);
        if(!trainees.isEmpty()){
            for (Trainee trainee : trainees) {
                System.out.println("Trainee " + trainee.getName() + " is participating.");
            }
        }else{
            System.out.println("No any Trainee.");
        }
    }

    public void complete(){
        Random rand = new Random();
        int totalskill = 0, totalstrategy = 0;
        int successChance = rand.nextInt(100) + (isMaverickInvolved?20:0);
        if(trainees.isEmpty()){
            successChance = 0;
        }else{
            for(Trainee trainee : trainees){
                totalskill += trainee.getSkillLevel();
                totalstrategy += trainee.getStrategyLevel();
            }
            successChance += totalskill+totalstrategy;
        }
        if(successChance > difficulty){
            System.out.println("# " + missionId + ":\n DIFFICULTY:　" + difficulty + "/500\n SUCCESS CHANCE: " +
                    successChance + "( skillLevel: " + totalskill  + " total strategy:" + totalstrategy +").\n----------------------> Mission completed successfully");
        }else if(successChance == difficulty){
            System.out.println("# " + missionId + ":\n DIFFICULTY:　" + difficulty + "/500\n SUCCESS CHANCE: " +
                    successChance +"( skillLevel: " + totalskill  + " total strategy:" + totalstrategy +").\n----------------------> Even Match");
        }else{
            System.out.println("# " + missionId + ":\n DIFFICULTY:　" + difficulty + "/500\n SUCCESS CHANCE: " +
                    successChance +"( skillLevel: " + totalskill  + " total strategy:" + totalstrategy +").\n----------------------> Mission failed.");
        }
    }

    public String toString(){
        return "#" + missionId;
    }
}

class MissionGroup extends MissionComponent{
    ArrayList<MissionComponent> missions;

    public MissionGroup(){
        missions = new ArrayList<>();
    }

    public void addMission(MissionComponent mission){
        missions.add(mission);
    }
    public void removeMission(MissionComponent mission){
        missions.remove(mission);
    }

    public void start(){
        for(MissionComponent mission : missions){
            mission.start();
        }
    }
    public void complete(){
        for(MissionComponent mission : missions){
            mission.complete();
        }
    }
    public String toString(){
        return missions.toString();
    }
}


