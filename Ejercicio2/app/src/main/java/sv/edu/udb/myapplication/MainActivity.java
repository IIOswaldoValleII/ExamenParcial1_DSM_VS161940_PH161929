package sv.edu.udb.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtEntrada;
    TextView txtImprimir;
    Button btnImprimir, btnIngresar;
    List candidatos = new LinkedList();
    String cadena = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtEntrada = findViewById(R.id.txtIngreso);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnImprimir = findViewById(R.id.btnImprimirR);
        txtImprimir = findViewById(R.id.txtImprimir);
        btnIngresar.setOnClickListener( (v)->{

            String entrada = txtEntrada.getText().toString();


            if (!entrada.equals("")) {
                cadena= entrada;
                String[] elementos = cadena.split(",");

                for (int i=0; i< elementos.length; i++){
                    if (Integer.parseInt(elementos[i])>=1 &&Integer.parseInt(elementos[i])<=4)
                    candidatos.add(Integer.parseInt(elementos[i]));
                    txtEntrada.setText("");
                }
            } //If Si esta vacio
            else{
                Toast toastMessage = Toast.makeText(this,"Campo vacío",Toast.LENGTH_SHORT);
                toastMessage.show();
            }
        });

        btnImprimir.setOnClickListener((v)->{
               Integer cantidadVotos = candidatos.size();
                Double cantidad_c1 =0.0;
                Double cantidad_c2 =0.0;
                Double cantidad_c3 =0.0;
                Double cantidad_c4 =0.0;
                Double porcentaje1 = 0.0;
            Double porcentaje2 = 0.0;
            Double porcentaje3 = 0.0;
            Double porcentaje4 = 0.0;
                for(Object a: candidatos){
                    if (a.equals(1)){
                            cantidad_c1++;
                        }
                    if (a.equals(2)){
                        cantidad_c2++;
                    }
                    if (a.equals(3)){
                        cantidad_c3++;
                    }
                    if (a.equals(4)){
                        cantidad_c4++;
                    }
                }

                porcentaje1= (cantidad_c1/cantidadVotos)*100;
                porcentaje2= (cantidad_c2/cantidadVotos)*100;
                porcentaje3= (cantidad_c3/cantidadVotos)*100;
                porcentaje4= (cantidad_c4/cantidadVotos)*100;


            txtImprimir.setText("Votos para candidato 1:  "  + String.format("%.4g%n", porcentaje1) + "%\n" +
                                "Votos para candidato 2:  "  + String.format("%.4g%n", porcentaje2) + "%\n" +
                                "Votos para candidato 3:  "  + String.format("%.4g%n", porcentaje3) + "%\n" +
                                "Votos para candidato 4:  "  + String.format("%.4g%n", porcentaje4) + "%\n"
                    );




        });



    }
}