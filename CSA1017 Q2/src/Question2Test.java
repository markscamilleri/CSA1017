import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

/**
 * Created by mark on 08/05/16.
 */
public class Question2Test {

    @org.junit.Before
    public void setUp() throws Exception {

        String expressions = "";

        System.out.println(expressions);

        System.setIn(new ByteArrayInputStream(expressions.getBytes(StandardCharsets.UTF_8)));
        System.setErr(new PrintStream("Question2.log"));
        System.setOut(new PrintStream("Question2.out"));
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testMain() throws Exception {

    }
}