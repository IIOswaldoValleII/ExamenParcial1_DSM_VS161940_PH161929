package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;
import java.text.DecimalFormat;

public class ImprimirEmpleados extends AppCompatActivity {
            TextView Nombre1, Cargo1, Sueldo1, isss1,afp1,renta1,bono1;
            TextView Nombre2, Cargo2, Sueldo2, isss2,afp2,renta2,bono2;
            TextView Nombre3, Cargo3, Sueldo3, isss3,afp3,renta3,bono3, nobono, salarioMayor, salarioMenor, SM;

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
        nobono = findViewById(R.id.txtNoBono);
        Cargo1 = findViewById(R.id.txtCargo1);
        Cargo2 = findViewById(R.id.txtCargo2);
        Cargo3 = findViewById(R.id.txtCargo3);
        nobono = findViewById(R.id.txtNoBono);
        salarioMayor = findViewById(R.id.txtSalariomayor);
        salarioMenor = findViewById(R.id.txtSalarioMenor);
        SM = findViewById(R.id.txtEmpleadosSM);
        SM.setText(" ");



        Bundle bundle = getIntent().getExtras();
        Empleado worker1 = getIntent().getExtras().getParcelable("empleo1");
        Empleado worker2 = getIntent().getExtras().getParcelable("empleo2");
        Empleado worker3 = getIntent().getExtras().getParcelable("empleo3");



        //Imprimiendo los valores en sus respectivos items en base a los objetos recolectados

        String C1, C2, C3;
        double S1, S2, S3;
        C1 = worker1.Cargo.toString();
        C2 = worker2.Cargo.toString();
        C3 = worker3.Cargo.toString();
        S1 = worker1.seldom_liquid();
        S2 = worker2.seldom_liquid();
        S3 = worker3.seldom_liquid();




             Nombre1.setText( " "+ worker1.Nombre.toString() + " " + worker1.Apellido);
             Cargo1.setText("Cargo: " + worker1.Cargo.toString());
             isss1.setText("$" + String.format ("%.2f",worker1.ISSS));
             afp1.setText("$" + String.format ("%.2f",worker1.AFP));
             renta1.setText("$" + String.format ("%.2f",worker1.RENTA));
             Sueldo1.setText("$"+ String.format ("%.2f",worker1.seldom_liquid()));


            Nombre2.setText( " "+ worker2.Nombre.toString() + " " + worker2.Apellido);
            Cargo2.setText("Cargo: " + worker2.Cargo.toString());
            isss2.setText("$" + String.format ("%.2f",worker2.ISSS));
            afp2.setText("$" + String.format ("%.2f",worker2.AFP));
            renta2.setText("$" + String.format ("%.2f",worker2.RENTA));
            Sueldo2.setText("$"+ String.format ("%.2f",worker2.seldom_liquid()));


            Nombre3.setText( " "+ worker3.Nombre.toString() + " " + worker3.Apellido);
            Cargo3.setText("Cargo: " + worker3.Cargo.toString());
            isss3.setText("$" + String.format ("%.2f",worker3.ISSS));
            afp3.setText("$" + String.format ("%.2f",worker3.AFP));
            renta3.setText("$" + String.format ("%.2f",worker3.RENTA));
            Sueldo3.setText("$"+ String.format ("%.2f",worker3.seldom_liquid()));



//nobono.setText(C1 + " " + C2 + " " + C3);


        //Calculo de los salarios mayores y menores de los empleados.
    String compa1 = new String(C1);
    String compa2 = new String(C2);
    String compa3 = new String(C3);

        double salarios[] = new double[] {S1, S2, S3};
        double smayor = salarios[0];
        double smenor = salarios[0];

            for (int x = 1; x < salarios.length; x++) {

                if (salarios[x] > smayor) {
                    smayor = salarios[x];
                }
                if (salarios[x] < smenor) {
                    smenor = salarios[x];
                }

                if (smayor == S1){
                    salarioMayor.setText(" El empleado con el mayor salario es:\nun " + worker1.Nombre.toString() + " " + worker1.Apellido);
                } else if (smayor == S2){
                    salarioMayor.setText(" El empleado con el mayor salario es:\nun " + worker2.Nombre.toString() + " " + worker2.Apellido);
                } else if (smayor == S3){
                    salarioMayor.setText(" El empleado con el mayor salario es:\nun " + worker3.Nombre.toString() + " " + worker3.Apellido);
                }


                if (smenor == S1){
                    salarioMenor.setText(" El empleado con el menor salario es:\nun " + worker1.Nombre.toString() + " " + worker1.Apellido);
                } else if (smenor== S2){
                    salarioMenor.setText(" El empleado con el menor salario es:\nun " + worker2.Nombre.toString() + " " + worker2.Apellido);
                } else if (smenor == S3){
                    salarioMenor.setText(" El empleado con el menor salario es:\nun " + worker3.Nombre.toString() + " " + worker3.Apellido);
                }








// Condicion para no generar bono al presentarse la conbinación de empleados.
           if(("gerente".equalsIgnoreCase(compa1)) && ("asistente".equalsIgnoreCase(compa2) && ("secretaria".equalsIgnoreCase(compa3)))){
           bono3.setText("$" + "0.00");
            bono2.setText("$" + "0.00");
              bono1.setText("$" + "0.00");
             nobono.setText("Orden de empleados detectado!!, Gerente-Asistente-Secretaria, no habra bono");
               Toast toastMessage = Toast.makeText(this,"No hay bono",Toast.LENGTH_SHORT);
         }else{
             bono1.setText("$" + String.format ("%.2f",worker1.bonoGerente() ));
              bono2.setText("$" + String.format ("%.2f",worker2.bonoAsistente() ));
              bono3.setText("$" + String.format ("%.2f",worker3.bonoGerente() ));
              nobono.setText("Se detecto un orden, Gerente-Asistente-Secretaria, No hay Bono");

           }

    }
    }
}