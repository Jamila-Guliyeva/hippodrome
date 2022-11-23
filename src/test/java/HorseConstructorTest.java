import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

 class HorseConstructorTest {
   /* Проверить, что при передаче в конструктор первым параметром null,
    будет выброшено IllegalArgumentException. Для этого нужно воспользоваться методом assertThrows;*/

    @Test
    void checkExceptionIsThrownIfFirstParameterIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0.5, 0.7));
    }

    /*Проверить, что при передаче в конструктор первым параметром null,
     выброшенное исключение будет содержать сообщение "Name cannot be null.".
     Для этого нужно получить сообщение из перехваченного исключения и воспользоваться методом assertEquals*/
    @Test
    void checkExceptionMessageIfFirstParameterIsNull() {
        Throwable expectedException = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 0.5, 0.7));
        assertEquals("Name cannot be null.", expectedException.getMessage());
    }


    /*Проверить, что при передаче в конструктор первым параметром пустой строки
    или строки содержащей только пробельные символы (пробел, табуляция и т.д.), будет выброшено IllegalArgumentException.
    Чтобы выполнить проверку с разными вариантами пробельных символов, нужно сделать тест параметризованным;*/

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  " })
     void CheckExceptionTypeIfParameterIsEmptyString(String name) {
        assertThrows(IllegalArgumentException.class, () -> new Horse(name, 0.5, 0.7));
    }
    /* Проверить, что при передаче в конструктор первым параметром пустой строки
    или строки содержащей только пробельные символы (пробел, табуляция и т.д.),
    выброшенное исключение будет содержать сообщение "Name cannot be blank.";*/
     @ParameterizedTest
     @ValueSource(strings = {"", " ", "  " })
     void CheckExceptionMethodIfParameterIsEmptyString(String name) {
         Throwable expectedException = assertThrows(IllegalArgumentException.class, () -> new Horse(name, 0.5, 0.7));
         assertEquals("Name cannot be blank.", expectedException.getMessage());
     }

     /*Проверить, что при передаче в конструктор вторым параметром отрицательного числа,
     будет выброшено IllegalArgumentException*/
     @Test
     void checkExceptionTypeIfSecondParameterIsNegative() {
         assertThrows(IllegalArgumentException.class, () -> new Horse("name", -0.5, 0.7));
     }

     /*Проверить, что при передаче в конструктор вторым параметром отрицательного числа,
      выброшенное исключение будет содержать сообщение "Speed cannot be negative.";*/

     @Test
     void checkExceptionMessageIfSecondParameterIsNegative() {
         Throwable expectedException = assertThrows(IllegalArgumentException.class, () -> new Horse("name", -0.5, 0.7));
         assertEquals("Speed cannot be negative.", expectedException.getMessage());
     }

     /*Проверить, что при передаче в конструктор третьим параметром отрицательного числа,
     будет выброшено IllegalArgumentException*/
     @Test
     void checkExceptionTypeIfThirdParameterIsNegative() {
         assertThrows(IllegalArgumentException.class, () -> new Horse("name", 0.5, -0.7));
     }
    /*Проверить, что при передаче в конструктор третьим параметром отрицательного числа,
    выброшенное исключение будет содержать сообщение "Distance cannot be negative.";*/
     @Test
     void checkExceptionMessageIfThirdParameterIsNegative() {
         Throwable expectedException = assertThrows(IllegalArgumentException.class, () -> new Horse("name", 0.5, -0.7));
         assertEquals("Distance cannot be negative.", expectedException.getMessage());
     }
 }