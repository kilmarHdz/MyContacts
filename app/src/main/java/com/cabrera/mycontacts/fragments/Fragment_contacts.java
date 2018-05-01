package com.cabrera.mycontacts.fragments;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cabrera.mycontacts.R;
import com.cabrera.mycontacts.adapters.ContactsRvAdapter;
import com.cabrera.mycontacts.models.ModelContact;

import java.util.ArrayList;
import java.util.List;

public class Fragment_contacts extends Fragment {
    private View v;

    private RecyclerView recyclerView;
    public Fragment_contacts(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_contacts, container, false);

        recyclerView = v.findViewById(R.id.rv_contacts);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        RecyclerView.LayoutManager layoutManager = linearLayoutManager;

        recyclerView.setLayoutManager(layoutManager);

        ContactsRvAdapter adapter = new ContactsRvAdapter(getContext(),getContacts());

        recyclerView.setAdapter(adapter);

        return v;
    }

    private List<ModelContact> getContacts(){

        List<ModelContact> list = new ArrayList<>();

        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                null,null, ContactsContract.Contacts.DISPLAY_NAME + " ASC");

        cursor.moveToFirst();

        while (cursor.moveToNext()){

            list.add(new ModelContact(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                    )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));
        }

        return list;
    }
}
