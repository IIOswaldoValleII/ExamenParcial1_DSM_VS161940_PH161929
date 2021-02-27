package sv.edu.udb.empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;




public class MainActivity extends AppCompatActivity {
        EditText txtNombre, txtApellido, txtCargo, txtHorasTrabajadas;
        Button btnImprimir, btnIngresar;
        Integer contador=0;
        //Asignando los 3 espacios para los empleados  0-1-2
        Empleado worker[] = new Empleado[3];
        int i=0;  //Contador interno

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
        btnImprimir.setEnabled(false);


        btnIngresar.setOnClickListener((v)->{
          String nombre,apellido, cargo;
          Integer  horas=0;

          if (!(txtNombre.getText().toString()).equals("") && !(txtApellido.getText().toString()).equals("")
                  && !(txtCargo.getText().toString()).equals("") && !(txtHorasTrabajadas.getText().toString()).equals("")){

                    nombre = txtNombre.getText().toString();
                    apellido = txtApellido.getText().toString();
                    cargo = txtCargo.getText().toString();
                    horas = Integer.parseInt(txtHorasTrabajadas.getText().toString());

                        worker[i] = new Empleado(nombre, apellido, cargo, horas);
                        worker[i].setSueldoBase(horas);
                        worker[i].setISSS(horas);
                        worker[i].setAFP(horas);
                        worker[i].setRENTA(horas);

              Limpiar();
                i++;  //Sumando posicion para el nuevo objeto a ingresar
              if (i==1) {
                  btnImprimir.setEnabled(true);
                  btnIngresar.setEnabled(false);
              }


              } //Fin de If vacio
            else{
              Toast toastMessage = Toast.makeText(this,"Campos vacíos",Toast.LENGTH_SHORT);
              toastMessage.show();
          }

        });

        btnImprimir.setOnClickListener((v)->{
            Intent intent = new Intent(this, ImprimirEmpleados.class);
            //Se crearon 3 objetos de la misma clase bajo las respectivas posiciones para ser mandados a la siguiente pantalla
            intent.putExtra("empleo1",worker[0]);
            intent.putExtra("empleo2",worker[1]);
            intent.putExtra("empleo3",worker[2]);
            startActivity(intent);
        });
    }


    public void Limpiar(){
            txtNombre.setText("");
            txtApellido.setText("");
            txtCargo.setText("");
            txtHorasTrabajadas.setText("");
    }

}