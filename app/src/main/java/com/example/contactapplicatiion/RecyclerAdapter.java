package com.example.contactapplicatiion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<ContactPojo> list;
    TextView username, phoneno, mailid, address;

    public RecyclerAdapter(List<ContactPojo> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cutom_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        username = (TextView) view.findViewById(R.id.name);
        phoneno = (TextView) view.findViewById(R.id.phoneNo);
        mailid = (TextView) view.findViewById(R.id.mailid);
        address = (TextView) view.findViewById(R.id.address);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactPojo contactPojo = list.get(position);
        holder.defaultNnameText.setText(username.getText().toString());
        holder.firstName.setText(String.valueOf(contactPojo.getName()));
        holder.defaultPhoneText.setText(phoneno.getText().toString());
        holder.phoneNo.setText(String.valueOf(contactPojo.getPhoneNo()));
        holder.defaultMailIdText.setText(mailid.getText().toString());
        holder.mailId.setText(String.valueOf(contactPojo.getEmailId()));
        holder.defaultAddressText.setText(address.getText().toString());
        holder.address.setText(contactPojo.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView defaultNnameText, firstName, defaultPhoneText, phoneNo, defaultMailIdText, mailId, defaultAddressText, address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            defaultNnameText = itemView.findViewById(R.id.name);
            firstName = itemView.findViewById(R.id.username);
            defaultPhoneText = itemView.findViewById(R.id.phoneNo);
            phoneNo = itemView.findViewById(R.id.userphoneNumber);
            defaultMailIdText = itemView.findViewById(R.id.mailid);
            mailId = itemView.findViewById(R.id.user_mailId);
            defaultAddressText = itemView.findViewById(R.id.address);
            address = itemView.findViewById(R.id.userAddress);
        }
    }
}
