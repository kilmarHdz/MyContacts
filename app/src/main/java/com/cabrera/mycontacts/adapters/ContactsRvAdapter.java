package com.cabrera.mycontacts.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cabrera.mycontacts.R;
import com.cabrera.mycontacts.models.ModelContact;

import java.util.List;

public class ContactsRvAdapter extends RecyclerView.Adapter<ContactsRvAdapter.ViewHolder> {

    Context mContext;

    private LayoutInflater inflater;
    private List<ModelContact> mListContact;


    public  ContactsRvAdapter(Context context, List<ModelContact> listContact){
        mListContact = listContact;
        mContext = context;

    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.items_contacs,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        TextView contact_name, contact_number;
        contact_name = holder.contact_name;
        contact_number = holder.contact_number;

        contact_name.setText(mListContact.get(position).getName());
        contact_number.setText(mListContact.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return mListContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView contact_name, contact_number;

        public ViewHolder(View itemView) {
            super(itemView);

            contact_name = itemView.findViewById(R.id.contact_name);
            contact_number = itemView.findViewById(R.id.contact_number);
        }
    }
}
