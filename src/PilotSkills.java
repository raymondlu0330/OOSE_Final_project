//Decorator Strategy
abstract class PilotSkills{
    protected int skillLevel = 0;

    abstract void applySkill();

    public int getSkillLevel(){
        return skillLevel;
    }
}

class BasicPilotSkills extends PilotSkills{
    public BasicPilotSkills(){
        skillLevel = 50;
    }
    @Override
    public void applySkill() {
        System.out.println("\tBasic Pilot Skill. Skill Level : " + skillLevel);
    }

    public String toString(){
        return "BasicPilotSkills";
    }
}


//Decorator
abstract class SkillDecorator extends PilotSkills{
    PilotSkills pilotSkills;

    public SkillDecorator(PilotSkills pilotSkills){
        this.pilotSkills = pilotSkills;
    }

    @Override
    public void applySkill(){
        pilotSkills.applySkill();
    }
}

class HighAltitudeSkill extends SkillDecorator{
    public HighAltitudeSkill(PilotSkills pilotSkills) {
        super(pilotSkills);
        this.skillLevel = pilotSkills.getSkillLevel()+35;
    }

    @Override
    public void applySkill() {
        pilotSkills.applySkill();
        addThisSkill();
    }
    public void addThisSkill(){
        System.out.println("\tHigh altitude skills. Enhanced skill level: " + skillLevel);
    }

    public String toString(){
        return "HighAltitudeSkill";
    }
}

class LowAltitudeSkill extends SkillDecorator{
    public LowAltitudeSkill(PilotSkills pilotSkills) {
        super(pilotSkills);
        this.skillLevel = pilotSkills.getSkillLevel()+25;
    }

    @Override
    public void applySkill() {
        pilotSkills.applySkill();
        addThisSkill();
    }
    public void addThisSkill(){
        System.out.println("\tLow altitude skills. Enhanced skill level: " + skillLevel);
    }

    public String toString(){
        return "LowAltitudeSkill";
    }
}

class NightFlight extends SkillDecorator{
    public NightFlight(PilotSkills pilotSkills) {
        super(pilotSkills);
        this.skillLevel = pilotSkills.getSkillLevel()+30;
    }

    @Override
    public void applySkill() {
        pilotSkills.applySkill();
        addThisSkill();
    }
    public void addThisSkill(){
        System.out.println("\tNight flight skills. Enhanced skill level: " + skillLevel);
    }

    public String toString(){
        return "NightFlight";
    }
}

