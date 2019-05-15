package com.zawlynn.dependency.ui.main.adapter;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zawlynn.dependency.R;
import com.zawlynn.dependency.pojo.Movie;
import com.zawlynn.dependency.ui.main.viewholder.PopuarViewHolder;
import com.zawlynn.dependency.utils.OnItemClick;


public class PopularMovieAdapter extends ListAdapter<Movie,PopuarViewHolder> {
    private OnItemClick click_event;
    public PopularMovieAdapter(OnItemClick itemClick) {
        super(new MovieItemCallback());
        click_event=itemClick;
    }

    @NonNull
    @Override
    public PopuarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemLayoutView =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new PopuarViewHolder(itemLayoutView,click_event);
    }

    @Override
    public void onBindViewHolder(@NonNull final PopuarViewHolder holder, int i) {
        holder.bind(getItem(i));
    }

    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };
}
