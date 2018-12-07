package com.iamdeejay.penit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iamdeejay.penit.R;
import com.iamdeejay.penit.model.PenEntry;

import java.util.List;

public class PenAdapter extends RecyclerView.Adapter<PenAdapter.PenViewHolder> {

    private List<PenEntry> penEntryList;
    private Context context;

    public PenAdapter(Context context, List<PenEntry> penEntryList) {
        this.penEntryList = penEntryList;
        this.context = context;
    }

    @NonNull
    @Override
    public PenViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pen_list, viewGroup, false);
        return new PenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PenViewHolder penViewHolder, int position) {
        PenEntry penEntry = penEntryList.get(position);
        penViewHolder.title.setText(penEntry.getTitle());
        penViewHolder.content.setText(penEntry.getContent());

    }

    @Override
    public int getItemCount() {
        if (penEntryList == null){
            return 0;
        }
        return penEntryList.size();
    }

    public class PenViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView content;

        public PenViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
        }
    }

    public void setNote(List<PenEntry> penEntries) {
        penEntryList = penEntries;
        notifyDataSetChanged();
    }
}
