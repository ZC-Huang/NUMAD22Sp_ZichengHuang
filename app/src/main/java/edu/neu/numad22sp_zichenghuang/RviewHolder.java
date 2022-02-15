package edu.neu.numad22sp_zichenghuang;


import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {

    public TextView linkAddress;
    public CheckBox checkBox;

    public RviewHolder(View itemView, final ItemClickListener listener) {
        super(itemView);
        linkAddress = itemView.findViewById(R.id.link_address);
        checkBox = itemView.findViewById(R.id.checkbox);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {

                        listener.onItemClick(position);
                    }
                }
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    int position = getLayoutPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onCheckBoxClick(position);
                    }
                }
            }
        });
    }
}
