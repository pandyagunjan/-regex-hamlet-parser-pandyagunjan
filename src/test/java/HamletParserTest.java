import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private String horatioText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
        this.horatioText = hamletParser.getHoratioData();
    }

    @Test
    public void testChangeHamletToLeon() {
       // hamletParser.getHamletData();
        Assert.assertTrue(hamletText.contains("Leon"));
        Assert.assertFalse(hamletText.contains("[Hh][Aa][Mm][Ll][Ee][Tt]"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        hamletParser.getHoratioData();
        Assert.assertTrue(horatioText.contains("Tariq"));
        Assert.assertFalse(horatioText.contains("[Hh][Oo][Rr][Aa][Tt][Ii][Oo]"));
    }

    @Test
    public void testFindHoratio() {
        int actual = hamletParser.horatioNumbers();
        int expected = 158;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHamlet() {
        int actual = hamletParser.hamletNumbers();
        int expected = 472;

        Assert.assertEquals(actual, expected);
    }
}