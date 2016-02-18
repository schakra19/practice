import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
   	String message = "Blah";
	MessageUtil mUtil = new MessageUtil("Hello World");

	@Test
	public void testAdd() {
		assertEquals(message, mUtil.printMessage());
   	}
}
