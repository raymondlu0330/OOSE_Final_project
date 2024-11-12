import java.util.ArrayList;
import java.util.List;

class Trainee {
    private String name;
    private PilotSkills skills;
    protected List<TrainingStrategy> strategies = new ArrayList<TrainingStrategy>();


    public Trainee(String name) {
        this.name = name;
        this.skills = new BasicPilotSkills();
    }

    public String getName() {
        return name;
    }

    public void setSkills(PilotSkills skills) {
        this.skills = skills;
    }

    public void showSkill(){
        System.out.println(name + " has: ");
        skills.applySkill();
    }

    public int getSkillLevel(){
        return skills.getSkillLevel();
    }
    public int getStrategyLevel(){
        int level = 0;
        for (TrainingStrategy strategy : strategies) {
            level += strategy.getStrategyLevel();
        }
        return level;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "name='" + name + '\'' +
                ", skills=" + skills +
                ",\n strategies=" + strategies +
                '}';
    }
}

