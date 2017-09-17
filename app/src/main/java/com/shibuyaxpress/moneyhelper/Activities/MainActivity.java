package com.shibuyaxpress.moneyhelper.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shibuyaxpress.moneyhelper.Model.Saldo;
import com.shibuyaxpress.moneyhelper.R;

import me.anwarshahriar.calligrapher.Calligrapher;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pbDistro;
    private TextView txtAhorro,txtCredito,txtEfectivo;
    //private FloatingActionButton fabNuevoRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this,"saowelcomeregular.ttf", true);

        pbDistro= findViewById(R.id.progressbar_proporcion);
        txtAhorro=findViewById(R.id.txt_ahorro_actual);
        txtCredito=findViewById(R.id.txt_credito_actual);
        txtEfectivo=findViewById(R.id.txt_efectivo_actual);
        //fabNuevoRegistro=findViewById(R.id.fab_registro);
        //setting the initial data for the personal account
        txtAhorro.setText(String.valueOf(Saldo.getInstance().getAhorroActual()));
        txtCredito.setText(String.valueOf(Saldo.getInstance().getCreditoActual()));
        txtEfectivo.setText(String.valueOf(Saldo.getInstance().getEfectivoActual()));

        pbDistro.setProgress(Saldo.getInstance().ProporcionMonto());
    }

    public void IngresarNuevoRegistro(View view){
        Intent launcher=new Intent(MainActivity.this,NewOperationActivity.class);
        finish();
        startActivity(launcher);
    }
}
