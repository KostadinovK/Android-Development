package com.example.kostadin.zooshop;

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
 * Created by Kostadin Kostadinov on 02/03/2018.
 */

class PromotionViewHolder extends BaseViewHolder<Promotion>{

    @BindView(R.id.img_prom) ImageView img_prom;
    @BindView(R.id.btn_buy) Button btn_buy;

    private Promotion dataItem;

    PromotionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }



    @OnClick
    public void onBuyClicked(){

        btn_buy.setEnabled(false);

    }
    @Override
    public void setData(Promotion item){
        this.dataItem = item;
        Picasso.with(itemView.getContext()).load(item.getImgUrl()).into(img_prom);
    }


}
