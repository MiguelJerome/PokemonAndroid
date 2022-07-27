package ca.collegelacite.evaluation_formative_11_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

// Neme: Miguel Jerome
// Numero etudiant: 2001326
// classe: IFM25907-030-P2022


public class MainActivity extends AppCompatActivity {

    // ListView <---> adaptateur <---> listeDePokemons
    private ListView listView;

    // Source de données pour l'adaptateur du ListView
    private ArrayList<Pokemon> listeDePokemons;


    // Adaptateur faisant le pont entre le ListView et les données.
    private AdaptateurPokemon adaptateur;

    // Fonction du cycle de vie exécutée lors de la création de l'activité.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Données source de l'adaptateur
        listeDePokemons = Pokemon.lireDonnées(this);

        // Créer l'adaptateur et le connecter aux données.
        adaptateur = new AdaptateurPokemon(this,listeDePokemons);

        // Connecter le ListView à l'adaptateur.
        ListView lv = findViewById(R.id.listeViewId);
        adaptateur = new AdaptateurPokemon(this,listeDePokemons);

        lv.setAdapter(adaptateur);

        // Installer un listener sur le ListView des pokémons.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                affichePageWeb(position);
            }
        });

    }

    // Mutateur de l'attribut sélection; on affiche les données du pokémon.


    private void affichePageWeb(int position)
    {
        Pokemon pokemon = listeDePokemons.get(position);
        String urlStr = pokemon.getWikiUrl();

        Uri webpage = Uri.parse(urlStr);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        startActivity(intent);
    }
}