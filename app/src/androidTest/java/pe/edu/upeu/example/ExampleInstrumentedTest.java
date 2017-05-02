package pe.edu.upeu.example;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import pe.edu.upeu.example.bean.Carrito;
import pe.edu.upeu.example.dao.CarritoDAO;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("pe.edu.upeu.example", appContext.getPackageName());

        CarritoDAO dao=new CarritoDAO(appContext);

        Carrito carrito = new Carrito();
        carrito.setDesProducto("sadasd");
        carrito.setCantidad(1);
        carrito.setTotal(2);

        dao.savePerson(carrito);

        List<Carrito> list=dao.findCarritoAll();
        Log.i("xD::::::",list.size()+"");
        dao.close();

    }
}
