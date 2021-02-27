package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;

public class ImprimirEmpleados extends AppCompatActivity {
            TextView Nombre1, Sueldo1, isss1,afp1,renta1,bono1;
            TextView Nombre2, Sueldo2, isss2,afp2,renta2,bono2;
            TextView Nombre3, Sueldo3, isss3,afp3,renta3,bono3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimir_empleados);
        //Asignando Variables a sus respuesta de impresion
        Nombre1 = findViewById(R.id.txtNombre1);
        Sueldo1 = findViewById(R.id.txtSueldo1);
        isss1 = findViewById(R.id.txtISSS1);
        afp1 = findViewById(R.id.txtAFP1);
        renta1 = findViewById(R.id.txtRenta1);
        bono1 = findViewById(R.id.txtBono1);

        Nombre2 = findViewById(R.id.txtNombre2);
        Sueldo2 = findViewById(R.id.txtSueldo2);
        isss2 = findViewById(R.id.txtISSS2);
        afp2 = findViewById(R.id.txtAFP2);
        renta2 = findViewById(R.id.txtRenta2);
        bono2 = findViewById(R.id.txtBono2);

        Nombre3 = findViewById(R.id.txtNombre3);
        Sueldo3 = findViewById(R.id.txtSueldo3);
        isss3 = findViewById(R.id.txtISSS3);
        afp3 = findViewById(R.id.txtAFP3);
        renta3 = findViewById(R.id.txtRenta3);
        bono3 = findViewById(R.id.txtBono3);
        Bundle bundle = getIntent().getExtras();
        Empleado worker1 = getIntent().getExtras().getParcelable("empleo1");
        Empleado worker2 = getIntent().getExtras().getParcelable("empleo2");
        Empleado worker3 = getIntent().getExtras().getParcelable("empleo3");



        //Imprimiendo los valores en sus respectivos items en base a los objetos recolectados




             Nombre1.setText( " "+ worker1.Nombre.toString() + " " + worker1.Apellido);
             isss1.setText("$" + String.format ("%.2f",worker1.ISSS));
             afp1.setText("$" + String.format ("%.2f",worker1.AFP));
             renta1.setText("$" + String.format ("%.2f",worker1.RENTA));
             Sueldo1.setText("$"+ String.format ("%.2f",worker1.seldom_liquid()));
             bono1.setText("$" + String.format ("%.2f",worker1.bonoGerente() ));

            Nombre2.setText( " "+ worker1.Nombre.toString() + " " + worker2.Apellido);
            isss2.setText("$" + String.format ("%.2f",worker2.ISSS));
            afp2.setText("$" + String.format ("%.2f",worker2.AFP));
            renta2.setText("$" + String.format ("%.2f",worker2.RENTA));
            Sueldo2.setText("$"+ String.format ("%.2f",worker2.seldom_liquid()));
            bono2.setText("$" + String.format ("%.2f",worker2.bonoAsistente() ));

            Nombre3.setText( " "+ worker3.Nombre.toString() + " " + worker1.Apellido);
            isss3.setText("$" + String.format ("%.2f",worker3.ISSS));
            afp3.setText("$" + String.format ("%.2f",worker3.AFP));
            renta3.setText("$" + String.format ("%.2f",worker3.RENTA));
            Sueldo3.setText("$"+ String.format ("%.2f",worker3.seldom_liquid()));
            bono3.setText("$" + String.format ("%.2f",worker3.bonoGerente() ));

    }
}