package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {
        EditText txtNombre, txtApellido, txtCargo, txtHorasTrabajadas;
        Button btnImprimir, btnIngresar;
        Integer contador=0;
        //Asignando los 3 espacios para los empleados  0-1-2
        Empleado worker[] = new Empleado[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asignando a variables locales los objetos en pantalla
        txtNombre= findViewById(R.id.txtNombre);
        txtApellido= findViewById(R.id.txtApellido);
        txtCargo= findViewById(R.id.txtCargo);
        txtHorasTrabajadas= findViewById(R.id.txtHorastrabajadas);
        btnImprimir = findViewById(R.id.btnImprimir);
        btnIngresar = findViewById(R.id.btnIngresar);


        btnImprimir.setEnabled(true);

            //DATOS DUMMY
            worker[0] = new Empleado("Kevin", "Pleitez", "Gerente", 175);
            worker[1] = new Empleado("Oswaldo", "Valle", "Asistente", 175);



        btnIngresar.setOnClickListener((v)->{
          String nombre,apellido, cargo;
          Integer  horas=0;

        System.out.println(worker[0].Nombre.toString());
        });

        btnImprimir.setOnClickListener((v)->{
            Intent intent = new Intent(this, ImprimirEmpleados.class);
            String arrayAsString = new Gson().toJson(worker);
            intent.putExtra("array", arrayAsString);
            startActivity(intent);


        });
    }
}