package edu.neu.numad22sp_zichenghuang;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.AdapterView;

public class ItemCard implements ItemClickListener {

    private final String linkAddress;
    private boolean isChecked;

    public ItemCard(String linkAddress, boolean isChecked) {
        this.linkAddress = linkAddress;
        this.isChecked = isChecked;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public boolean getStatus() {
        return isChecked;
    }

    @Override
    public void onItemClick(int position) {
        isChecked = !isChecked;
    }

    @Override
    public void onCheckBoxClick(int position) {
        isChecked = !isChecked;
    }
}
