//Factory Method
abstract class FlightSimulatorFactory{
    public abstract FlightSimulator createSimulator();
}

class HighAltitudeSimulatorFactory extends FlightSimulatorFactory{

    @Override
    public FlightSimulator createSimulator() {
        return new HighAltitudeSimulator();
    }
}
class LowAltitudeSimulatorFactory extends FlightSimulatorFactory{

    @Override
    public FlightSimulator createSimulator() {
        return new LowAltitudeSimulator();
    }
}
class NightFlightSimulatorFactory extends FlightSimulatorFactory{
    @Override
    public FlightSimulator createSimulator() {
        return new NightFlightSimulator();
    }
}

abstract class FlightSimulator{
    public abstract void simulate();
}

class HighAltitudeSimulator extends FlightSimulator{
    @Override
    public void simulate() {
        System.out.println("Simulating High-Altitude flight");
    }
}
class LowAltitudeSimulator extends FlightSimulator{
    @Override
    public void simulate() {
        System.out.println("Simulating Low-Altitude flight");
    }
}
class NightFlightSimulator extends FlightSimulator{
    @Override
    public void simulate() {
        System.out.println("Simulating Night flight");
    }
}
