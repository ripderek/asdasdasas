package com.example.myapplicationrevistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplicationrevistas.Adaptadores.AdaptadorJournal;
import com.example.myapplicationrevistas.Modelos.Journal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {
    ListView lstRevistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear la peticion
        //Data
        lstRevistas = (ListView) findViewById(R.id.listRevistas);
        Map<String, String> datos = new HashMap<String, String>();

        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        ArrayList<Journal> lstjorunal = new ArrayList<>();

        JSONArray JSONs = new JSONArray(result);
        lstjorunal = Journal.JsonObjectsBuild(JSONs);


        AdaptadorJournal adapJourn = new AdaptadorJournal(MainActivity.this, lstjorunal);
        lstRevistas.setAdapter(adapJourn);

       // Log.i("result", JSONlista.toString());






    }
}