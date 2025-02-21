package task3;

public class ControlPanel {
    private String lastManeuver;
    private String lastLeverAction;

    public void executeManeuver(String maneuver) {
        this.lastManeuver = maneuver;
        System.out.println("Выполняется маневр: " + maneuver);
    }

    public void handleLevers(String action) {
        this.lastLeverAction = action;
        System.out.println("Рукоятки управления: " + action);
    }

    public String getLastManeuver() {
        return lastManeuver;
    }

    public String getLastLeverAction() {
        return lastLeverAction;
    }
}