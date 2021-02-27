package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.HashMap;

public class ImprimirEmpleados extends AppCompatActivity {
            TextView prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir_empleados);


        prueba = findViewById(R.id.txtNombre1);
        String arrayAsString = getIntent().getExtras().getString("array");
        Gson gson  = new Gson();
         Empleado empleado = gson.fromJson(arrayAsString, Empleado.class);

    


    }
}