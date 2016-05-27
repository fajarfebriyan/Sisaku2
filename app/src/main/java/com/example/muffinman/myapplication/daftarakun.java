package com.example.muffinman.myapplication;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;
//todo fix keyboard jangan langsung muncul tiba2. harusnya pilih email, baru munculin keyboard.

public class daftarakun extends AppCompatActivity {
    private EditText _name, _dateBirth, _noTelp, _email, _pass, _confPass;
    private String name, dateBirth, noTelp, email, pass, confPass, sex;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;

    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarakun);

        _name = (EditText) findViewById(R.id.editnama);
        _dateBirth = (EditText) findViewById(R.id.edittanghir);
        _noTelp = (EditText) findViewById(R.id.editnope);
        _email = (EditText) findViewById(R.id.editemail);
        _pass = (EditText) findViewById(R.id.editpass1);
        _confPass = (EditText) findViewById(R.id.editulangpass);
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSexGroup);

        Button daftar =(Button) findViewById(R.id.tomboldaftarakun);

       daftar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               try {
                   name = URLEncoder.encode(_name.getText().toString().trim(), "UTF-8");
                   dateBirth = URLEncoder.encode(_dateBirth.getText().toString().trim(), "UTF-8");
                   noTelp = URLEncoder.encode(_noTelp.getText().toString().trim(), "UTF-8");
                   email = URLEncoder.encode(_email.getText().toString().trim(), "UTF-8");
                   pass = URLEncoder.encode(_pass.getText().toString().trim(), "UTF-8");
                   confPass = URLEncoder.encode(_confPass.getText().toString().trim(), "UTF-8");
               } catch (UnsupportedEncodingException e) {
                   e.printStackTrace();
               }

               //radioButton
               int selectedId = radioSexGroup.getCheckedRadioButtonId();
               radioSexButton = (RadioButton)findViewById(selectedId);
               if(radioSexButton.getText().toString().equalsIgnoreCase("pria"))
                   sex = "M";
               else
                   sex = "F";

               //handling errors in input: incomplete set, wrong confirmation password, and possibly age restriction?
               if(name.isEmpty() || dateBirth.isEmpty() || noTelp.isEmpty() || email.isEmpty()
                       || pass.isEmpty() || confPass.isEmpty()) {
                   showToast("Input error. Coba lagi");
               }
               else if(confPass.equals(pass)) {
                   //show up animation or something
                   //create asyntask task
                   new register_task().execute();
               }
               else {
                   showToast("Confirmation password salah");
               }

               //Intent pageakunsaya = new Intent(getBaseContext(), akunsaya.class);
               //startActivity(pageakunsaya);
           }
       });

        ImageView beranda = (ImageView)findViewById(R.id.berandatombol);

        beranda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pageberanda = new Intent(getBaseContext() ,utama.class);
                startActivity(pageberanda);
            }
        });
    }

    private boolean check_internet_connection() {
        ConnectivityManager connec =(ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        if (connec.getActiveNetworkInfo()!=null)
            return true;
        else
            return false;
    }

    private class register_task extends AsyncTask<Void, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(Void... params) {
            URL url;
            String post;
            StringBuilder sb;
            JSONObject conn_result = new JSONObject();

            try {
                //url = new URL(getString(R.string.URLRegister));
                url = new URL(getString(R.string.URLRegister));
                HttpURLConnection url_connection = (HttpsURLConnection) url.openConnection();

                url_connection.setRequestMethod("POST");
                url_connection.setDoInput(true);
                url_connection.setDoOutput(true);

                sb = new StringBuilder().append("df83a489c749=c376fdd5cb8658453a7c9f96925451f70053004d")
                        .append("&full_name=").append(name)
                        .append("&email=").append(email)
                        .append("&birth_date=").append(dateBirth)
                        .append("&sex=").append(sex)
                        .append("&no_telp=").append(noTelp)
                        .append("&password=").append(pass)
                        ;
                post = sb.toString();

                OutputStream out = url_connection.getOutputStream();
                out.write(post.getBytes());

                InputStream in = url_connection.getInputStream();

                StringBuilder string_builder = new StringBuilder();

                int byte_read;

                while((byte_read = in.read())!=-1) {
                    string_builder.append((char)byte_read);
                }

                conn_result = new JSONObject(string_builder.toString());
                Log.d("json",string_builder.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }

            return conn_result;


        }

        @Override
        protected void onPostExecute(JSONObject result) {
            Boolean _success=false;
            String _error = "";
            String message_result = "";

            try {
                _success = result.getBoolean("success");
                _error = result.getString("error");
            }catch (JSONException e){e.printStackTrace();}

            if(_success) {
                //untuk sementara, munculin toast aja.
                //harusnya ganti activity
                message_result = "Register success!";
            }
            else if(check_internet_connection()) {
                message_result = "No Internet connection";
            }
            else if(!_success){
                //error messages from server:
                //INVALID_EMAIL
                //DUPLICATE_EMAIL
                //INSERT_FAIL
                //MISSING_PARAMETER
                if(_error.equals("INVALID_EMAIL")) {
                    message_result = "Email is invalid";
                }
                else if(_error.equals("DUPLICATE_EMAIL")){
                    message_result = "Email has been used";
                }
                else if(_error.equals("INSERT_FAIL")){
                    message_result = "Error. Insert fail";
                }
                else if(_error.equals("MISSING_PARAMETER")){
                    message_result = "Incomplete input data";
                }
            }


            showToast(message_result);
            showToast(name+dateBirth+sex+noTelp+email+pass);
        }
    }

    protected void showToast (String st) { //"Toast toast" is declared in the class
        try {
            toast.getView().isShown();     // true if visible
            toast.setText(st);
        } catch (Exception e) {         // invisible if exception
            toast = Toast.makeText(this, st, Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
