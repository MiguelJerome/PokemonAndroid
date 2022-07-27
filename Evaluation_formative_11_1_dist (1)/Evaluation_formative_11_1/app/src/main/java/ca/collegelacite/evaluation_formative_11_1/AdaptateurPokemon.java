package ca.collegelacite.evaluation_formative_11_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptateurPokemon extends BaseAdapter {
    private Context contexte;
    private ArrayList<Pokemon> sourceDonnees;
    private LayoutInflater inflater;

    public AdaptateurPokemon(Context ctx, ArrayList<Pokemon> donnees) {
        this.contexte = ctx;
        this.sourceDonnees = donnees;
        this.inflater = (LayoutInflater)this.contexte.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return sourceDonnees.size();
    }

    @Override
    public Object getItem(int i) {
        return sourceDonnees.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.pokemon_list_item, viewGroup, false);
        Pokemon pokemon = sourceDonnees.get(i);

        TextView nomTextView = rowView.findViewById(R.id.nomTextView);
        nomTextView.setText(pokemon.getNomAnglais());

        ImageView iv = rowView.findViewById(R.id.imageView2);
        pokemon.intoImageView(iv);

        TextView descTV = rowView.findViewById(R.id.descriptionTextView);
        descTV.setText(pokemon.getDescription());

        return rowView;
    }
}
