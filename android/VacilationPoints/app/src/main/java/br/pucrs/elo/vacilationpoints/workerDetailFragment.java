package br.pucrs.elo.vacilationpoints;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.pucrs.elo.vacilationpoints.dummy.DummyContent;
import br.pucrs.elo.vacilationpoints.worker.Vacillation;
import br.pucrs.elo.vacilationpoints.worker.Worker;

/**
 * A fragment representing a single worker detail screen.
 * This fragment is either contained in a {@link workerListActivity}
 * in two-pane mode (on tablets) or a {@link workerDetailActivity}
 * on handsets.
 */
public class workerDetailFragment extends Fragment {
    SimpleItemRecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Worker mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public workerDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.getName());
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View rootView = inflater.inflate(R.layout.worker_detail, container, false);

        /*System.out.println("FRAGMENT onCreateView");

        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.worker_detail, container, false);
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(mItem.getVacillationList()));
        return recyclerView;*/
        return inflater.inflate(R.layout.worker_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        recyclerView = (RecyclerView) getView().findViewById(R.id.worker_detail);
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(mItem.getVacillationList()));
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
            holder.mTextVaciPoints.setText( String.valueOf(mValues.get(position).getValue()));
            holder.mTextVaciText.setText(mValues.get(position).getType());
            holder.mTextVaciDate.setText(mValues.get(position).getDate());

        /*holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTwoPane) {
                    Bundle arguments = new Bundle();
                    arguments.putString(workerDetailFragment.ARG_ITEM_ID, holder.mItem.getName());
                    workerDetailFragment fragment = new workerDetailFragment();
                    fragment.setArguments(arguments);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.worker_detail_container, fragment)
                            .commit();
                } else {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, workerDetailActivity.class);
                    intent.putExtra(workerDetailFragment.ARG_ITEM_ID, holder.mItem.getName());

                    context.startActivity(intent);
                }
            }
        });*/
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

                if(mTextVaciPoints == null)
                    System.out.println("NULL NULL NULL NULL NULL NULL NULL NULL NULL NULL NULL NULL ");
            }

            @Override
            public String toString() {
                return super.toString() + " '" + "'";
            }
        }
    }
}