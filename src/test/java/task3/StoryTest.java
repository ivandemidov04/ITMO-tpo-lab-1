package task3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StoryTest {
    private static Spaceship spaceship;
    private static Ford ford;

    @BeforeAll
    static void setUp() {
        spaceship = new Spaceship("Корабль Форда");
        ford = new Ford("Форд");
    }

    @AfterAll
    static void tearDown() {
        spaceship = null;
        ford = null;
    }

    @Test
    void testFordInteractsWithControlPanel() {
        ford.interactWithControlPanel(spaceship, "схватился за рукоятки");
        Assertions.assertNotNull(spaceship, "Корабль не должен быть null");
        Assertions.assertTrue(ford.isInteractingWithControlPanel(), "Форд должен взаимодействовать с пультом управления");
    }

    @Test
    void testSpaceshipMovesInAllDirections() {
        spaceship.move("во всех направлениях");
        Assertions.assertNotNull(spaceship, "Корабль не должен быть null");
        Assertions.assertEquals("во всех направлениях", spaceship.getLastMoveDirection(), "Корабль должен двигаться во всех направлениях");
    }

    @Test
    void testSpaceshipPerformsManeuver() {
        spaceship.performManeuver("разворот на 180 градусов");
        Assertions.assertNotNull(spaceship, "Корабль не должен быть null");
        Assertions.assertEquals("разворот на 180 градусов", spaceship.getLastManeuver(), "Корабль должен выполнить маневр");
    }

    @Test
    void testFordReleasesControlLevers() {
        ford.performAction(spaceship, "отпустил половину рукояток");
        Assertions.assertNotNull(spaceship, "Корабль не должен быть null");
        Assertions.assertTrue(ford.hasReleasedControlLevers(), "Форд должен отпустить половину рукояток");
    }

    @Test
    void testSpaceshipMovesTowardsMissiles() {
        spaceship.move("навстречу ракетам");
        Assertions.assertNotNull(spaceship, "Корабль не должен быть null");
        Assertions.assertEquals("навстречу ракетам", spaceship.getLastMoveDirection(), "Корабль должен двигаться навстречу ракетам");
    }
}