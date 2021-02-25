package sv.edu.udb.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB, txtC;
    TextView txtPrint;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Definiendo variables de entrada y salida datos por medio de las ID
        txtPrint = findViewById(R.id.txtResultado);
        txtA = findViewById(R.id.txtVa);
        txtB = findViewById(R.id.txtVb);
        txtC = findViewById(R.id.txtVc);
        btnCalc = findViewById(R.id.btnCalcular);
        //Realizando la operacion de Calcular a traves de una funcion del tipo flecha (v View)
        btnCalc.setOnClickListener((v) -> {
            String varA = txtA.getText().toString();
            String varB = txtB.getText().toString();
            String varC = txtC.getText().toString();
            if (!varA.equals("") && !varB.equals("") && !varC.equals("")) {
                if (Numerico(varA) && Numerico(varB) && Numerico(varC)) {
                    if (Double.parseDouble(varA) != 0) {
                    Double x1=0.0;
                    Double x2=0.0;
                        Double A= Double.parseDouble(varA);
                        Double B= Double.parseDouble(varB);
                        Double C= Double.parseDouble(varC);
                    x1= (-B + Math.sqrt( Math.pow(B,2)-(4*A*C)))/2*A ;
                    x2= (-B - Math.sqrt( Math.pow(B,2)-(4*A*C)))/2*A ;
                            txtPrint.setText("Las raices resultantes son: \n " +  "X1: " + x1  +"\t X2: " + x2 + "");
                    } else {
                            Toast toastMessage = Toast.makeText(this,"El valor de A debe ser distinto de cero",Toast.LENGTH_SHORT);
                        toastMessage.show();
                    }
                } //Fin de Numerico
                else {
                    Toast toastMessage = Toast.makeText(this,"Valor no numerico detectado",Toast.LENGTH_SHORT);
                    toastMessage.show();
                }

            } //Fin de equals
            else {
                Toast toastMessage = Toast.makeText(this,"Campos vacíos",Toast.LENGTH_SHORT);
                toastMessage.show();
            }

        });
    }

    public static boolean Numerico(String string) {
        boolean resultado;

        try {
            Double.parseDouble(string);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        }

        return resultado;
    }

}//Fin de mainactivity
