import br.com.alura.testesunitario.spyPartialMock.SampleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class SpyPartilMockTest {
    @Spy
    private SampleService sampleServiceSpy;

    @Test
    public void toBeSpiedMethodTest() {
        // Modify behavior of one method using spy
        doReturn("Spied version of toBeSpiedMethod").when(sampleServiceSpy).toBeSpiedMethod();
        String result = sampleServiceSpy.toBeSpiedMethod();
        assertEquals("Spied version of toBeSpiedMethod", result);
    }

    @Test
    public void actualMethodTest() {
        String result = sampleServiceSpy.actualMethod();
        assertEquals("Real implementation of actualMethod", result);
    }
}
