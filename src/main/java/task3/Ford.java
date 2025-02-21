package task3;

public class Ford extends Character {
    private boolean hasReleasedControlLevers;

    public Ford(String name) {
        super(name);
        this.hasReleasedControlLevers = false;
    }

    @Override
    public void interactWithControlPanel(Spaceship spaceship, String action) {
        this.isInteractingWithControlPanel = true;
        System.out.println(name + " взаимодействует с пультом управления.");
        spaceship.handleControlLevers(action);
    }

    public void performAction(Spaceship spaceship, String action) {
        if (action.contains("отпустил")) {
            this.hasReleasedControlLevers = true;
        }
        System.out.println(name + " выполняет действие: " + action);
        spaceship.performManeuver(action);
    }

    public boolean hasReleasedControlLevers() {
        return hasReleasedControlLevers;
    }
}