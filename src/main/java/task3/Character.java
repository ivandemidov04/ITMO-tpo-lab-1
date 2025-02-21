package task3;

public abstract class Character {
    protected String name;
    protected boolean isInteractingWithControlPanel;

    public Character(String name) {
        this.name = name;
        this.isInteractingWithControlPanel = false;
    }

    public abstract void interactWithControlPanel(Spaceship spaceship, String action);

    public boolean isInteractingWithControlPanel() {
        return isInteractingWithControlPanel;
    }
}