import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class HippodromeTest {

    /*Проверить, что при передаче в конструктор null, будет выброшено IllegalArgumentException;*/
    @Test
    void checkThatHorseConstructorThrowsExceptionWhenConstructorParameterIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }

    /*Проверить, что при передаче в конструктор null, выброшенное исключение
    будет содержать сообщение "Horses cannot be null.";*/
    @Test
    void checkConstructorExceptionMessage() {
        Throwable expectedException = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", expectedException.getMessage());
    }

    /*Проверить, что при передаче в конструктор пустого списка, будет выброшено IllegalArgumentException*/
    @Test
    void checkThatHorseConstructorThrowsExceptionWhenConstructorParameterIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    /*Проверить, что при передаче в конструктор пустого списка,
    выброшенное исключение будет содержать сообщение "Horses cannot be empty.";*/
    @Test
    void checkConstructorExceptionMessageWhenTheListParameterIsBlank() {
        Throwable expectedException = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", expectedException.getMessage());
    }

    /*метод getHorses
        Проверить, что метод возвращает список, который содержит те же объекты и в той же последовательности,
        что и список который был передан в конструктор.
        При создании объекта Hippodrome передай в конструктор список из 30 разных лошадей;*/
    @Test
    void checkThatGetHorsesMethodReturnsTheCorrectListBack() {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            horses.add(new Horse("Horse" + i, 0.5, 0.7));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    /*метод move
    Проверить, что метод вызывает метод move у всех лошадей.
    При создании объекта Hippodrome передай в конструктор список из 50 моков лошадей и воспользуйся методом verify.*/

    @Test
    void checkThatMoveMethodIsAppliedForEachHorseInTheList() {
        ArrayList<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            horses.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(horses);

        hippodrome.move();

        for (Horse horse : horses) {
            verify(horse).move();
        }
    }

    /*метод getWinner
    Проверить, что метод возвращает лошадь с самым большим значением distance.*/
    @Test
    void checkThatGetWinnerMethodReturnsTheHorseWithTheBiggestDistanceParameter() {
        List<Horse> horses = new ArrayList<>();
        Horse horse1 = new Horse("Horse1", 0.5, 0.7);
        Horse horse2 = new Horse("Horse2", 0.5, 0.8);
        Horse horse3 = new Horse("Horse3", 0.5, 0.6);
        Horse horse4 = new Horse("Horse4", 0.5, 0.5);
        Horse horse5 = new Horse("Horse5", 0.5, 0.9);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        horses.add(horse4);
        horses.add(horse5);

        Hippodrome hippodrome = new Hippodrome(horses);

        assertSame(horse5, hippodrome.getWinner());
    }
}