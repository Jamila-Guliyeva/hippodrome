import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class HorseMethods {
    /*Проверить, что метод getName возвращает строку, которая была передана первым параметром в конструктор;*/
    @Test
    void checkGetNameMethodReturnsFirstParameter() {
        Horse horse = new Horse("Horse", 0.5, 0.7);
        assertEquals("Horse", horse.getName());
    }

    @Test
    /*Проверить, что метод getSpeed() возвращает число, которое было передано вторым параметром в конструктор;*/
    void checkGetSpeedMethodReturnsSecondParameter() {
        Horse horse = new Horse("Horse", 0.5, 0.7);
        assertEquals(0.5, horse.getSpeed());
    }

    /*метод getDistance
    Проверить, что метод возвращает число, которое было передано третьим параметром в конструктор;
    Проверить, что метод возвращает ноль, если объект был создан с помощью конструктора с двумя параметрами;*/

    @Test
    void checkGetDistanceMethodReturnsThirdParameter() {
        Horse horse = new Horse("Horse", 0.5, 0.7);
        assertEquals(0.7, horse.getDistance());
    }

    @Test
    void checkGetDistanceMethodReturnsZeroIfThirdParameterIsMissing() {
        Horse horse = new Horse("Horse", 0.5);
        assertEquals(0, horse.getDistance());
    }


    /*метод move
    Проверить, что метод вызывает внутри метод getRandomDouble с параметрами 0.2 и 0.9.
    Для этого нужно использовать MockedStatic и его метод verify;
    Проверить, что метод присваивает дистанции значение высчитанное по формуле: distance + speed * getRandomDouble(0.2, 0.9).
    Для этого нужно замокать getRandomDouble, чтобы он возвращал определенные значения,
    которые нужно задать параметризовав тест.*/
    @Test
    void moveMethodInvokesGetRandomStaticMethod() {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            new Horse("Horse", 0.5, 0.7).move();
            mockedStatic.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }
    }
}
