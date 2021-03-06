package guru.qa.docs;

import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("This is the before all method!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This is the after all method!");
    }

    @BeforeEach
    void openYandex() {
        System.out.println("        open(\"ya.ru\")");
    }

    @AfterEach
    void takeScreen() {
        System.out.println("        takeScreen();");
    }

    @Test
    void firstTest() {
        System.out.println("                     first test()");
        Assertions.assertTrue(true);
    }

    @Test
    void secondTest() {
        System.out.println("                    second test()");
        Assertions.assertTrue(true);
    }
}
