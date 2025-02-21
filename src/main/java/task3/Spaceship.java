package task3;

public class Spaceship implements ShipController {
    private String name;
    private Engine engine;
    private ControlPanel controlPanel;

    public Spaceship(String name) {
        this.name = name;
        this.engine = new Engine();
        this.controlPanel = new ControlPanel();
    }

    public void move(String direction) {
        engine.activateThrusters(direction);
    }

    @Override
    public void performManeuver(String maneuver) {
        controlPanel.executeManeuver(maneuver);
    }

    @Override
    public void handleControlLevers(String action) {
        controlPanel.handleLevers(action);
    }

    public String getLastMoveDirection() {
        return engine.getLastDirection();
    }

    public String getLastManeuver() {
        return controlPanel.getLastManeuver();
    }

    public String getLastLeverAction() {
        return controlPanel.getLastLeverAction();
    }
}