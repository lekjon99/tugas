package com.example.sinurat.testapp;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sinurat on 4/2/2016.
 */
public class ContanctAdapter extends ArrayAdapter<ModelContact> {

    private Activity activity;
    private List<ModelContact> items;
    private int row;
    private ModelContact objBean;

    public ContanctAdapter(Activity act, int row, List<ModelContact> items) {
        super(act, row, items);

        this.activity = act;
        this.row = row;
        this.items = items;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, null);

            holder = new ViewHolder();
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        if ((items == null) || ((position + 1) > items.size()))
            return view;

        objBean = items.get(position);

        holder.tvname = (TextView) view.findViewById(R.id.tvname);
        holder.tvPhoneNo = (TextView) view.findViewById(R.id.tvphone);

        if (holder.tvname != null && null != objBean.getName()
                && objBean.getName().trim().length() > 0) {
            holder.tvname.setText(Html.fromHtml(objBean.getName()));
        }
        if (holder.tvPhoneNo != null && null != objBean.getPhoneNo()
                && objBean.getPhoneNo().trim().length() > 0) {
            holder.tvPhoneNo.setText(Html.fromHtml(objBean.getPhoneNo()));
        }
        return view;
    }

    public class ViewHolder {
        public TextView tvname, tvPhoneNo;
    }

}
