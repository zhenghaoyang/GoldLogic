package com.goldlogic.jiadianxi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.goldlogic.jiadianxi.R;
import com.goldlogic.jiadianxi.bean.Product;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/8.
 */

public class ProductAdapter extends BaseAdapter {

    private List<Product> productList;
    private Context context;
    private String TAG = "howy";
    private Product product;


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }


    @Override
    public int getCount() {
        return productList == null ? 0 : productList.size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    //将具体的集合数据装配到具体的一个item layout中。
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView: ");
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_product_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
//        装配数据
//        for (int i = 0; i < 3; i++) {
            product = productList.get(0);
            Log.d(TAG, "product: " + product + productList);
            holder.tvTag.setText(product.getTag());
//        holder.ivCompanyLogo.setImageBitmap(Bitmap.createBitmap());
            holder.tvInvestLevel.setText(product.getExt6());
            Log.d(TAG, "getView: " + product.getExt6());
            holder.tvCompanyBackground.setText(product.companyBackground);
            holder.tvYearInterest.setText(product.yearInverest);
//        }


        return convertView;
    }


    class ViewHolder {
        @Bind(R.id.tv_tag)
        TextView tvTag;
        @Bind(R.id.iv_company_logo)
        ImageView ivCompanyLogo;
        @Bind(R.id.tv_invest_level)
        TextView tvInvestLevel;
        @Bind(R.id.tv_company_background)
        TextView tvCompanyBackground;
        @Bind(R.id.tv_year_interest)
        TextView tvYearInterest;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
