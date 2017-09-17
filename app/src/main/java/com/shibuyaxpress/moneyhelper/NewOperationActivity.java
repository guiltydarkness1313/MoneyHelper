package com.shibuyaxpress.moneyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.shibuyaxpress.moneyhelper.Model.Saldo;

import me.anwarshahriar.calligrapher.Calligrapher;

public class NewOperationActivity extends AppCompatActivity {

    EditText montotxt;
    RadioGroup groupTipoMonto;
    Spinner spinnerTipoCuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"saowelcomeregular.ttf", true);

        //sete
        montotxt=findViewById(R.id.txt_monto);
        groupTipoMonto=findViewById(R.id.radio_group_tipo_monto);
        spinnerTipoCuenta=findViewById(R.id.spinner_tipocuenta);

    }

    public void RegistrarDatos(View view){
        double monto=0;
        String strmonto=montotxt.getText().toString();
        if(TextUtils.isEmpty(strmonto)){
            Toast.makeText(this,"No ingresaste un valor en monto",Toast.LENGTH_SHORT).show();
            montotxt.setError("ingrese un valor para proceder");
        }else{
        monto+=Double.parseDouble(montotxt.getText().toString());
        String tipoCuenta=spinnerTipoCuenta.getSelectedItem().toString();

            switch (groupTipoMonto.getCheckedRadioButtonId()){
                case R.id.rbtn_egreso:
                    Saldo.getInstance().setEgreso(monto,tipoCuenta);
                    finish();
                    Intent launcher=new Intent(this,MainActivity.class);
                    startActivity(launcher);
                    break;

                case R.id.rbtn_ingreso:
                    Saldo.getInstance().setIngreso(monto,tipoCuenta);
                    finish();
                    Intent launcher2=new Intent(this,MainActivity.class);
                    startActivity(launcher2);
                    break;

                default:
                    Toast.makeText(this,"no se selecciono una opcion",Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}
