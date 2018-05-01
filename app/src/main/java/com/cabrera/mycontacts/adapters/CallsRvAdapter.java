package com.cabrera.mycontacts.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cabrera.mycontacts.R;
import com.cabrera.mycontacts.models.ModelCalls;

import java.util.List;

public class CallsRvAdapter extends RecyclerView.Adapter<CallsRvAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context mContext;

    private List<ModelCalls> mlistCall;

    public CallsRvAdapter(Context context, List<ModelCalls> listCalls){
        mContext = context;
        mlistCall = listCalls;
    };


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        layoutInflater = LayoutInflater.from(mContext);

        View view = layoutInflater.inflate(R.layout.items_calls,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TextView name, duration, date;

        name = holder.name;
        duration = holder.duration;
        date = holder.date;

        name.setText(mlistCall.get(position).getNumber());
        duration.setText(mlistCall.get(position).getDuration());
        date.setText(mlistCall.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return mlistCall.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,duration,date;
        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.contact_name);
            duration = itemView.findViewById(R.id.call_duration);
            date = itemView.findViewById(R.id.call_date);
        }
    }
}
