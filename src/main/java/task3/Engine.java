package task3;

public class Engine {
    private String lastDirection;

    public void activateThrusters(String direction) {
        this.lastDirection = direction;
        System.out.println("Двигатели активированы, корабль движется в направлении: " + direction);
    }

    public String getLastDirection() {
        return lastDirection;
    }
}