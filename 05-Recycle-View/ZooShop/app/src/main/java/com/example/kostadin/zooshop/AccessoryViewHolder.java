package com.example.kostadin.zooshop;

import android.content.ClipData;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Kostadin Kostadinov on 01/03/2018.
 */

class AccessoryViewHolder extends BaseViewHolder<Accessory> {

    @BindView(R.id.txt_name) TextView txt_name;
    @BindView(R.id.img_item) ImageView img_item;
    @BindView(R.id.txt_description) TextView txt_description;
    @BindView(R.id.btn_like) Button btn_like;

    private Accessory dataItem;

    AccessoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    @OnClick
    public void onLikeClicked(){

        btn_like.setEnabled(false);
        dataItem.setLiked();
    }
    @Override
    public void setData(Accessory item){
        this.dataItem = item;
        txt_name.setText(item.getName());
        txt_description.setText(item.getDescription());
        btn_like.setEnabled(!item.isLiked());
        Picasso.with(itemView.getContext()).load(item.getImageUrl()).into(img_item);
    }
}
