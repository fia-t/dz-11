import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManTest {
    @Test
    public void testRegisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Man man = new Man("John", "Doe", 40);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNull(man.getPartner());
        softAssert.assertEquals("John", man.getFirstName(), "Correct First Name");
        softAssert.assertEquals("Doe", man.getLastName(), "Correct Last Name");
        softAssert.assertEquals(40, man.getAge(), "Correct age");
    }

    @Test
    public void testManRegisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        Assert.assertTrue(man.registerPartnership(woman), "Register Partnership");
    }

    @Test
    public void testSetPartner() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        Assert.assertNotNull(man.setPartner(woman));

    }
    @Test
    public void testGetPartner() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        man.setPartner(woman);
        Assert.assertNotNull(man.getPartner());

    }

    @Test
    public void testIsNotRetired() throws InterruptedException{
        Thread.sleep(3000);
        Man man = new Man("John", "Doe", 64);
        Assert.assertFalse(man.isRetired());
    }

    @Test
    public void testIsRetired() throws InterruptedException{
        Thread.sleep(3000);
        Man man = new Man("John", "Doe", 65);
        Assert.assertTrue(man.isRetired());
    }

    @Test
    public void testDeregisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 60);
        Man man = new Man("John", "Doe", 40);
        man.setPartner(woman);
        Assert.assertNull(man.deregisterPartnership(true));
    }

    @Test
    public void testNotDeregisterPartnership() throws InterruptedException{
        Thread.sleep(3000);
        Woman woman = new Woman("Jane", "Smith", 35);
        Man man = new Man("John", "Doe", 40);
        man.setPartner(woman);
        Assert.assertEquals(man.deregisterPartnership(false), "Smith");
    }


}
