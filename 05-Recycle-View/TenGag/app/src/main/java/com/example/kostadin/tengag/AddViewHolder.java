package com.example.kostadin.tengag;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kostadin Kostadinov on 03/03/2018.
 */

public class AddViewHolder extends BaseViewHolder<Add> {
    @BindView(R.id.btn_buy)Button btn_buy;
    @BindView(R.id.add_img)ImageView add_img;
    private Add item;

    public AddViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(Add item) {
        Picasso.with(itemView.getContext()).load(item.getImageUrl()).into(add_img);
    }

    @OnClick(R.id.btn_buy)
    public void onBuyClick(){
        Uri uriUrl = Uri.parse("http://google.com");
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        Context context = itemView.getContext();
        context.startActivity(launchBrowser);
    }
}
