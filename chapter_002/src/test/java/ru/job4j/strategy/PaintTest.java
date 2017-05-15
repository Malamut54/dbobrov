package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Dmitriy Bobrov (mailto:bobrov.dmitriy@gmail.com)
 * @version $id$
 * @since 0.1
 */
public class PaintTest {
    /**
     * Test. Draw triangle.
     */
    @Test
    public void drawTriangle() {
        Triangle triangle = new Triangle();
        Paint paint = new Paint();
        String expected = "# \n##\n###";
        paint.draw(triangle);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        paint.draw(triangle);
        assertThat(outContent.toString(), is(expected));
    }
    /**
     * Test. Draw square.
     */
    @Test
    public void drawSquare() {
        Square square = new Square();
        Paint paint = new Paint();
        String expected = "###\n###\n###";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        paint.draw(square);
        assertThat(outContent.toString(), is(expected));
    }
}
