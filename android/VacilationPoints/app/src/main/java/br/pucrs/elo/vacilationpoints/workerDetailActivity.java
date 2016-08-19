package br.pucrs.elo.vacilationpoints;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.pucrs.elo.vacilationpoints.dummy.DummyContent;
import br.pucrs.elo.vacilationpoints.worker.Vacillation;

/**
 * An activity representing a single worker detail screen. This
 * activity is only used narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link workerListActivity}.
 */
public class workerDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, "tl.elo@cpca.pucrs.br");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Notes about worker");
                intent.putExtra(Intent.EXTRA_TEXT, "Dear TL,\n I want to inform you that your employee arrived late to work today.\n Att,\nVacillation Points APP");

                startActivity(Intent.createChooser(intent, "Send Email"));

            }
        });

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(workerDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(workerDetailFragment.ARG_ITEM_ID));
            workerDetailFragment fragment = new workerDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.worker_detail_container, fragment)
                    .commit();
        }

        CollapsingToolbarLayout c = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        if(getIntent().getStringExtra(workerDetailFragment.ARG_ITEM_ID).equals("Eduardo Lorandi")){
            c.setBackgroundResource(R.drawable.bug);
        } else if(getIntent().getStringExtra(workerDetailFragment.ARG_ITEM_ID).equals("Andrei Martins")){
            c.setBackgroundResource(R.drawable.smoke);
        } else if(getIntent().getStringExtra(workerDetailFragment.ARG_ITEM_ID).equals("Bernardo Koefender")){
            c.setBackgroundResource(R.drawable.smoke);
        }

        /*View recyclerView = findViewById(R.id.worker_detail);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);*/
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEM_MAP.get(getIntent().getStringExtra(workerDetailFragment.ARG_ITEM_ID)).getVacillationList()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, workerListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /*#####################################################################################################*/
    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<Vacillation> mValues;

        public SimpleItemRecyclerViewAdapter(List<Vacillation> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.worker_list_vacillation, parent, false);

            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Vacillation v = mValues.get(position);

            holder.mTextVaciPoints.setText(String.valueOf(mValues.get(position).getValue()));
            holder.mTextVaciText.setText(mValues.get(position).getType());
            holder.mTextVaciDate.setText(mValues.get(position).getDate());
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mTextVaciPoints;
            public final TextView mTextVaciText;
            public final TextView mTextVaciDate;

            public ViewHolder(View view) {
                super(view);

                mView = view;
                mTextVaciPoints = (TextView) view.findViewById(R.id.vaci_points);
                mTextVaciText = (TextView) view.findViewById(R.id.vaci_text);
                mTextVaciDate = (TextView) view.findViewById(R.id.vaci_date);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + "'";
            }
        }
    }
}
