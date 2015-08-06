package it.eracle.ogamebot;


import it.eracle.ogamebot.it.eracle.ogamebot.buildings.MetalMineConstruction;
import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class OgameConnectionTest
{
    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void test_constructor_empty_usernamepassword() throws Exception {
        String serverUrl="http://en.ogame.gameforge.com/";
        String username="";
        String password="";
        String universe="";
        OgameConnection connection = new OgameConnection(serverUrl,universe, username, password);
        //Assert.assertNotNull(connection);


        connection.close();
    }

    @Test(expected = org.openqa.selenium.NoSuchElementException.class)
    public void testconstructor_wrongurl() throws Exception {
        String serverUrl="";
        String username="";
        String password="";
        String universe="";

        OgameConnection connection;

        connection = new OgameConnection(serverUrl,universe, username, password);

        //Assert.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testconstructor_login_correct(){
        String username="cocorito";
        String password="cocorito";
        String url="en.ogame.gameforge.com";
        String universe="Ganimed";

        OgameConnection connection = new OgameConnection(url,universe, username, password);

        Assert.assertTrue("Not Positive Value of metal", connection.getMetal() > 0);
        Assert.assertTrue("Not Positive Value of crystal", connection.getCrystal() > 0);
        Assert.assertTrue("Not Positive or zero Value of deuterium", connection.getDeuterium() >= 0);
        Assert.assertTrue("Not Positive or zero Value of energy", connection.getEnergy() >= 0);

        connection.close();
    }

    @Test
    public void testBuildMetalMine(){
        String username="cocorito";
        String password="cocorito";
        String url="en.ogame.gameforge.com";
        String universe="Ganimed";

        OgameConnection connection = new OgameConnection(url,universe, username, password);

        MetalMineConstruction mm = connection.getMetalMineConstruction();
        Assert.assertNotNull(mm);

        Assert.assertTrue(mm.getMetal_required() > 0);

        Assert.assertTrue(mm.getCrystal_required()>0);

        Assert.assertTrue(mm.getDeuterium_required()>0);

        Assert.assertTrue(mm.getEnergy_needed()>0);

        Assert.assertTrue(mm.getProduction_duration()>0);


        Assert.assertTrue("Cannot build a mine",connection.canBuildMetalMine());
        //connection.buildMine();

       // connection.login(
    }


}
