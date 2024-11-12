import java.util.ArrayList;
import java.util.List;

//Strategy Pattern : Training Strategy
abstract class TrainingStrategy{
    protected int strategyLevel = 0;
    public abstract int getStrategyLevel();
    public void train(){}
}

class HighAltitudeInterception extends TrainingStrategy {
    @Override
    public void train() {
        this.strategyLevel+= 5;
        System.out.println("Training for - High Altitude interception.");
    }
    public String toString(){
        return "High Altitude interception";
    }

    @Override
    public int getStrategyLevel() {
        return strategyLevel;
    }
}

class LowAltitudePenetration extends TrainingStrategy{

    @Override
    public void train() {
        this.strategyLevel+= 3;
        System.out.println("Training for - Low altitude penetration.");
    }
    public String toString(){
        return "Low Altitude Penetration";
    }
    public int getStrategyLevel() {
        return strategyLevel;
    }

}

class NightCombat extends TrainingStrategy{

    @Override
    public void train() {
        this.strategyLevel+= 4;
        System.out.println("Training for - Night combat.");
    }
    public String toString(){
        return "Night Combat";
    }
    public int getStrategyLevel() {
        return strategyLevel;
    }
}

class Instructor{
    private TrainingStrategy strategy;

    public void setTrainingStrategy(TrainingStrategy trainingStrategy, List<Trainee> trainees){
        System.out.println("###Maverick is training the trainees' flight strategy...");
        System.out.println("-----------------------------------------------------");
        this.strategy = trainingStrategy;
        for(Trainee trainee : trainees){
            trainee.strategies.add(strategy);
        }
        executeTraining();
    }
    public void executeTraining(){
        strategy.train();
    }
}

