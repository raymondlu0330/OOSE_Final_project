import java.util.ArrayList;
import java.util.List;

//Singleton Pattern
class Maverick{
    //宣告一個靜態的物件參考；
    private static Maverick instance;
    private List<Trainee> trainees;
    private Instructor instructor;

    //將原有的建構子宣告為私有的；
    private Maverick(){
        trainees = new ArrayList<Trainee>();
        instructor = new Instructor();
    }

    //建立另外一個生成物件的方法，通常稱為 instance(),
    // 它判斷是否物件已經生成了，若已生成則不再生成，若未生成則生成一個。
    public static Maverick getInstance(){
        if(instance == null){
            instance = new Maverick();
        }
        return instance;
    }

    public void leadMission(){
        System.out.println("###Maverick is leading the head coach");
    }

    public void addTrainee(Trainee trainee) {
        trainees.add(trainee);
        System.out.println("Maverick added trainee: " + trainee.getName());
    }
    public void removeTrainee(Trainee trainee) {
        trainees.remove(trainee);
        System.out.println("Maverick removed trainee: " + trainee.getName());
    }

    public void trainTrainees(PilotSkills newSkills) {
        System.out.println("###Maverick is training the trainees' flight skill...\n");
        for (Trainee trainee : trainees) {
            trainee.setSkills(newSkills);
            trainee.showSkill();
            System.out.println();
        }
    }

    public void trainTrainee(Trainee trainee, PilotSkills newSkills) {
        System.out.println("###Training " + trainee.getName() + " with "+ newSkills);
        trainee.setSkills(newSkills);
        trainee.showSkill();
    }

    public void setTrainingStrategy(TrainingStrategy strategy){
        instructor.setTrainingStrategy(strategy, trainees);
    }
}
