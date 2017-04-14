package graphEndpoint; /**
 * Created by Daniel on 12.04.2017.
 */

import org.junit.Assert;
import org.junit.Test;

public class SampleTest {

    @Test
    public void findTheError()
    {
        // Assert.assertEquals("BAR",System.getProperty("FOO"));
        Assert.assertEquals("Test",(new MainApp()).customerInfo());
    }
}
