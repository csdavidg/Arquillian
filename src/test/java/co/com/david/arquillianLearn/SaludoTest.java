package co.com.david.arquillianLearn;

import co.com.david.arqullianLearn.Saludo;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class SaludoTest {

    @Deployment
    public static Archive<?> createFileTest() {
        /*
        Archive<?> arquivoTest = ShrinkWrap.create(WebArchive.class, "applicationTest.war")
                .addPackage(PersonDao.class.getPackage())
                .addClass(Person.class).addAsResource("META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
         */

        Archive<?> arquivoTest = ShrinkWrap.create(WebArchive.class, "applicationTest.war")
                .addPackage(Saludo.class.getPackage())
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return arquivoTest;
    }


    @EJB
    Saludo saludo;

    @Test
    public void testSaludo() {
        Assert.assertEquals("HOLA", saludo.saludar());
    }


}