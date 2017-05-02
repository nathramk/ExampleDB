package pe.edu.upeu.example.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.example.bean.Carrito;
import pe.edu.upeu.example.util.Commons;

/**
 * Created by Alumnos on 02/05/2017.
 */

public class CarritoDAO extends SQLiteOpenHelper {


    private  static final int VERSION=1;

    public CarritoDAO(Context context) {
        super(context, Commons.DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String ddl="CREATE TABLE Carrito (" +
                " codProducto INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " desProducto TEXT," +
                " cantidad INTEGER," +
                " precio INTEGER," +
                " total INTEGER," +
                ");";
        db.execSQL(ddl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String ddl = "DROP TABLE IF EXISTS Person";
        db.execSQL(ddl);
        this.onCreate(db);

    }

    public void savePerson(Carrito carrito){
        ContentValues values=new ContentValues();
        values.put("desProduct",carrito.getDesProducto());
        values.put("cantidadReal",carrito.getCantidad());
        values.put("precio", carrito.getPrecio());
        values.put("total", carrito.getTotal());

        getWritableDatabase().insert("Carrito", null,values);
    }


    public List<Carrito> findCarritoAll(){
        ArrayList<Carrito> listCursor = new ArrayList<Carrito>();
        String columns[]={"codProducto","desProducto","cantidad","precio","total"};
        String where = null;
        Cursor cursor = getReadableDatabase().query("",columns,where,null,null,null,null);

        Carrito carrito = null;
        while(cursor.moveToNext()){
            carrito = new Carrito();
            carrito=new Carrito();
            carrito.setCodProducto(cursor.getLong(0));
            carrito.setDesProducto(cursor.getString(1));
            carrito.setCantidad(cursor.getInt(2));
            carrito.setPrecio(cursor.getInt(3));
            carrito.setTotal(cursor.getInt(4));

            listCursor.add(carrito);
        }

        return null;
    }


}
