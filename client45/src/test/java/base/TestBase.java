package base;
import org.junit.Test;


public class TestBase {
	@Test
	public void testBase() {
		MockBase mockBase = new MockBase();
		System.out.println("hello maven");
		mockBase.hello();
	}
}
