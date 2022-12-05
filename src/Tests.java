import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Enemy_trooperTest {

    @Test
    @DisplayName("trooper_test")
    void AI_test_1() {
        Hero hr = new Hero(10, 10, 100);
        Enemy_trooper tester = new Enemy_trooper(15, 15, hr);

        tester.AI_action();
        assertAll(() -> assertEquals(75, hr.getHealth()),
                () -> assertEquals(8, tester.getX()),
                () -> assertEquals(8, tester.getY()),
                () -> assertEquals(false, hr.isDead()));
    }
}

class Enemy_cannonTest {

    @Test
    @DisplayName("cannon_test")
    void AI_test_1() {
        Hero hr = new Hero(10, 10, 100);
        Enemy_cannon tester = new Enemy_cannon(30, 30, hr);

        tester.AI_action();
        assertEquals(60, hr.getHealth());
        assertEquals(30, tester.getX());
        assertEquals(30, tester.getY());
        assertEquals(false, hr.isDead());

        tester.AI_action();
        tester.AI_action();

        assertEquals(true, hr.isDead());
    }
}

class Enemy_archerTest {

    @Test
    @DisplayName("move_test")
    void AI_test_1() {
        Hero hr = new Hero(10, 10, 100);
        Enemy_archer tester = new Enemy_archer(40, 40, hr);

        tester.AI_action();
        assertAll(() -> assertEquals(85, hr.getHealth()),
                () -> assertEquals(37, tester.getX()),
                () -> assertEquals(37, tester.getY()),
                () -> assertEquals(false, hr.isDead()));

        tester.AI_action();
        tester.AI_action();

        assertAll(() -> assertEquals(70, hr.getHealth()),
                () -> assertEquals(31, tester.getX()),
                () -> assertEquals(31, tester.getY()),
                () -> assertEquals(false, hr.isDead()));
    }
}

class Enemy_mageTest {

    @Test
    @DisplayName("move_test")
    void AI_test_1() {
        Hero hr = new Hero(10, 10, 100);
        Enemy_mage tester = new Enemy_mage(20, 20, hr);

        tester.AI_action();
        assertAll(() -> assertEquals(100, hr.getHealth()),
                () -> assertNotEquals(20, tester.getX()),
                () -> assertNotEquals(20, tester.getY()));
    }
}