package com.example.am.aplikacjamyliwego;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

public class DrawPinActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        Button saveButton = (Button) findViewById(R.id.button3);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);


        final Gps tmp = new Gps(this);
        final Database db = new Database(this);

        final EditText editText_pinName = (EditText) findViewById(R.id.editText_pinName);
        final EditText editText_animal = (EditText) findViewById(R.id.editText_animal);
        if(saveButton != null)
            saveButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    List<DrawingPin> allPins = db.getAllDrawingPins();
                    DrawingPin newPin = new DrawingPin();
                    newPin.setLongitude(tmp.getLongitude());
                    newPin.setLatitude(tmp.getLatitude());
                    newPin.setName(editText_pinName.getText().toString());
                    newPin.setType(editText_animal.getText().toString());
                    int ret = db.getMaxIdDrawingPin();
                    if(ret >= 0)
                        newPin.setId(ret + 1);
                    if(db.addDrawingPin(newPin))
                    {
                        Context context = getApplicationContext();
                        CharSequence text = "Pomyślnie dodano nowy punkt!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }else{
                        Context context = getApplicationContext();
                        CharSequence text = "Błąd przy dodawaniu!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

                }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draw_pin, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
