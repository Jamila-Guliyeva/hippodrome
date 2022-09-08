import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class MainMethodTest {
/*Проверить, что метод выполняется не дольше 22 секунд. Для этого воспользуйся аннотацией Timeout.
*/
    @Test
    @Disabled
    @Timeout(value = 22)
        void checkMainMethodTimeout() throws Exception {
        Main.main(null);
    }

}
