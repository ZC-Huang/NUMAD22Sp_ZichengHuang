package edu.neu.numad22sp_zichenghuang;

import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ItemCard extends AppCompatActivity implements ItemClickListener {

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
        String url;
        url = this.getLinkAddress();
        gotoUrl(url);
    }

    private void gotoUrl(String linkAddress) {
        Uri uri = Uri.parse(linkAddress);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public void onCheckBoxClick(int position) {
        isChecked = !isChecked;
    }
}
