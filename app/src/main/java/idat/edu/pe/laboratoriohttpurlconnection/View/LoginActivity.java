package idat.edu.pe.laboratoriohttpurlconnection.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import idat.edu.pe.laboratoriohttpurlconnection.Controller.UsuarioController;
import idat.edu.pe.laboratoriohttpurlconnection.R;

public class LoginActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    EditText correo;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn1 = findViewById(R.id.LogBtnLogin);
        btn2 = findViewById(R.id.RegBtnLogin);
        correo = findViewById(R.id.LogEdtUserName);
        pass = findViewById(R.id.LogEdtUserPass);
        //Evento Click
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GUI -> AsyncTask
                new Hilo().execute();
            }
        });

        //EL REGISTRO EMPIESA AQUI
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regView = new Intent(getApplicationContext(),RegistroActivity.class);
                startActivity(regView);

            }
        });

    }

    private class Hilo
            extends AsyncTask<String,String,JSONObject>{

        ProgressDialog dlg;


        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            dlg = new ProgressDialog(LoginActivity.this);
            dlg.setTitle("SUPPORT");
            dlg.setMessage("Validando Usuario...");
            dlg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            dlg.setCancelable(true);
            dlg.show();
        }
        @Override
        protected JSONObject doInBackground(String... strings) {
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            UsuarioController ctl = new UsuarioController();
            JSONObject env = null;
            try {
                env = new JSONObject();
                env.accumulate("usu_nombre",correo.getText());
                env.accumulate("usu_passwd",pass.getText());



            }catch (Exception ex){
                ex.printStackTrace();
            }

            return ctl.consumo("http://181.65.215.174/Slim2.6.2/Login", "POST",env);
        }
        @Override
        protected void onPostExecute(JSONObject s) {

            //super.onPostExecute(s);
            if(dlg.isShowing()){dlg.dismiss();}
            try {
                Toast.makeText(getApplicationContext(),s.getString("message"),Toast.LENGTH_LONG).show();
                if(s.getBoolean("status")==true){
                    Intent ingreso = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(ingreso);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            //Intent x = new Intent(getApplicationContext(),MainActivity.class);
            //startActivity(x);
        }
    }

}
