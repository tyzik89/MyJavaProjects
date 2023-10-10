package util;

import entites.DwarvesBand;
import org.junit.*;

public class BandUtilTest {
    private DwarvesBand bandUtil;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before BandUtilTest.class");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("After BandUtilTest.class");
    }

    @Before
    public void initTest() {
        bandUtil = BandUtil.createBand();
        System.out.println("Before Test");
    }

    @After
    public void afterTest() {
        bandUtil = null;
        System.out.println("After Test");
    }

    @Test
    public void testCreateBand() {
        System.out.println(bandUtil);
    }

}