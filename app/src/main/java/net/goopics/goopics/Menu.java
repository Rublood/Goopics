package net.goopics.goopics;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Menu extends ListActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] values = new String[] { "Device",
                "Géo localisation", "Accéléromètre",
                "Navigateur internet", "Dialogues", "Album photos",
                "Connexion réseau", "Gestion des fichiers",
                "Carnet de contacts" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, values);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Position : " + position, Toast.LENGTH_LONG).show();
    }
}
