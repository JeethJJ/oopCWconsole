import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTesting {

    @Test
    void intTest(){
        int v;

        v= Validator.intValidator("Enter 7");
        InputStream sysInBackup = System.in; // backup System.in to restore it later
        ByteArrayInputStream in = new ByteArrayInputStream("12".getBytes());
        System.setIn(in);

        assertEquals(7,v);

        System.setIn(sysInBackup);
    }
}
