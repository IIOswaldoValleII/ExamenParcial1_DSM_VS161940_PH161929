package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class ImprimirEmpleados extends AppCompatActivity {
            TextView Nombre1, Sueldo1, isss1,afp1,renta1,bono1;
            TextView Nombre2, Sueldo2, isss2,afp2,renta2,bono2;
            TextView Nombre3, Sueldo3, isss3,afp3,renta3,bono3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir_empleados);
        //Asignando Variables a sus respuesta de impresion
        Nombre1 = findViewById(R.id.txtNombre1);
        Sueldo1 = findViewById(R.id.txtSueldo1);
        afp1 = findViewById(R.id.txtAFP1);
        renta1 = findViewById(R.id.txtRenta1);
        bono1 = findViewById(R.id.txtBono1);

        Nombre2 = findViewById(R.id.txtNombre2);
        Sueldo2 = findViewById(R.id.txtSueldo2);
        afp2 = findViewById(R.id.txtAFP2);
        renta2 = findViewById(R.id.txtRenta2);
        bono2 = findViewById(R.id.txtBono2);

        Nombre3 = findViewById(R.id.txtNombre3);
        Sueldo3 = findViewById(R.id.txtSueldo3);
        afp3 = findViewById(R.id.txtAFP3);
        renta3 = findViewById(R.id.txtRenta3);
        bono3 = findViewById(R.id.txtBono3);

        Empleado worker1 = getIntent().getExtras().getParcelable("empleo1");
        Empleado worker2 = getIntent().getExtras().getParcelable("empleo2");
        Empleado worker3 = getIntent().getExtras().getParcelable("empleo3");

        //Imprimiendo los valores en sus respectivos items en base a los objetos recolectados

        Nombre1.setText( " "+ worker1.Nombre.toString() + " " + worker1.Apellido.toString());
        isss1.setText("$" + worker1.SueldoBase);


/*
        Nombre2.setText( " "+ worker2.Nombre.toString() + " " + worker2.Apellido);
        isss2.setText("$" + worker2.ISSS);
        afp2.setText("$" + worker2.AFP);
        renta2.setText("$" + worker2.RENTA);


        Nombre3.setText( " "+ worker3.Nombre.toString() + " " + worker3.Apellido);
        isss3.setText("$" + worker3.ISSS);
        afp3.setText("$" + worker3.AFP);
        renta3.setText("$" + worker3.RENTA);
*/












    }
}