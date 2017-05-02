package pe.edu.upeu.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.upeu.example.bean.Carrito;
import pe.edu.upeu.example.frm.FrmCarritoHelper;

public class MainActivity extends AppCompatActivity {

    private Carrito carrito;

    public static ArrayList<Carrito> listPerson = new ArrayList<Carrito>();
    public Long codProducto;
    private ArrayAdapter<Carrito> arrayAdapter;
    ListView listID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listID = (ListView) findViewById(R.id.listID);
        Button btnSave= (Button) findViewById(R.id.btnSave);

        //String[] name={"kenyi","caleb","amilcar","sss","sss"};

        //listPerson.add(new Person(1,"Kenyi ", "Lopez", "AV: peru 785", "Masculino", "Activo"));

        int layout = android.R.layout.simple_list_item_1;

        //ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<Person>(this, layout, listPerson);
        arrayAdapter = new ArrayAdapter<Carrito>(this, layout, listPerson);

        listID.setAdapter(arrayAdapter);


        listID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Carrito carrito = (Carrito) parent.getItemAtPosition(position);
                codProducto=carrito.getCodProducto();
                Toast.makeText(MainActivity.this, carrito.getCodProducto()+" Hola: "+carrito.getDesProducto(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                carrito = FrmCarritoHelper.getPersonOfFrm(spinnerSex,textViewMarried);
                PersonDAO personDao = new PersonDAO(Register.this);
                personDao.savePerson(person);
                personDao.close();

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_insertar) {

            goRegister();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void goRegister(){
        Intent i=new Intent(this, Register.class);
        startActivity(i);
    }
}
