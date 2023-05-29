import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTest {

    @Test
    public void testWomanWithoutPartner() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNull(woman.getPartner());
        softAssert.assertEquals("Jane", woman.getFirstName(), "Correct First Name");
        softAssert.assertEquals("Smith", woman.getLastName(), "Correct Last Name");
        softAssert.assertEquals(35, woman.getAge(), "Correct age");

    }
    @Test
    public void testWomanRegisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        Assert.assertTrue(woman.registerPartnership(man), "Register Partnership");
    }

    @Test
    public void testSetPartner() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        Assert.assertNotNull(woman.setPartner(man));

    }
    @Test
    public void testGetPartner() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        woman.setPartner(man);
        Assert.assertNotNull(woman.getPartner());

    }

    @Test
    public void testIsNotRetired() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 59);
        Assert.assertFalse(woman.isRetired());
    }

    @Test
    public void testIsRetired() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 60);
        Assert.assertTrue(woman.isRetired());
    }

    @Test
    public void testSetPreviousLastName() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Doe", 60);
        Assert.assertEquals(woman.setPreviousLastName("Smith"), "Smith");
    }

    @Test
    public void testDeregisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 60);
        Man man = new Man("John", "Doe", 40);
        woman.setPartner(man);
        Assert.assertNull(woman.deregisterPartnership(true));
    }

    @Test
    public void testNotDeregisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        woman.setPartner(man);
        Assert.assertEquals(woman.deregisterPartnership(false), "Doe");
    }

}
