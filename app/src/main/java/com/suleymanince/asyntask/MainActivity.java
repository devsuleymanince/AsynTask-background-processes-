package com.suleymanince.asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView sayilar;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new arkaplan().execute();

    }




    class arkaplan extends AsyncTask<Void,Integer,Void>
    {
        // İşlem sırasında ilk çalıştırılacak method
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            sayilar = findViewById(R.id.sayilar);
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.show();

        }

        //Arkaplan işlemlerinin gerçekleştiği metod
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0 ; i<=5;i++)
            {


                try {
                    publishProgress(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return null;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
        // Bir işlemin durumunun takip edilmesini sağlayan metod
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Integer idegeri = values[0];
            Log.i("i değerli",""+idegeri);
            sayilar.setText(String.valueOf(idegeri));

        }
        // Arkaplan işlemi sonrası yapılacak olan işlerin yapıldığı yer
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            sayilar.setText("Nihayet Bitti");
            progressDialog.cancel();

        }


    }

}