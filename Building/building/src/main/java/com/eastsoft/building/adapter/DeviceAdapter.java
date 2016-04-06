package com.eastsoft.building.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.eastsoft.building.R;

import java.util.List;

/**
 * Created by ll on 2016/4/6.
 */
public class DeviceAdapter extends BaseAdapter {
    private final List<CommontAdapterData> adapterDatas;
    IOnDeviceClick iOnDeviceClick;

    public DeviceAdapter(List<CommontAdapterData> adapterDatas, IOnDeviceClick iOnDeviceClick) {
        this.adapterDatas = adapterDatas;
        this.iOnDeviceClick =iOnDeviceClick;
    }


    @Override
    public int getCount() {
        return adapterDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return adapterDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scenario, parent, false);
            final ItemHolder holder = new ItemHolder();
            holder.name = (TextView) convertView.findViewById(R.id.item_name);
            holder.button= (Button) convertView.findViewById(R.id.item_btn_1);
            holder.button= (Button) convertView.findViewById(R.id.item_btn_1);
            holder.button2= (Button) convertView.findViewById(R.id.item_btn_2);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnDeviceClick.onClickSwitch(position, true);
                }
            });
            holder.button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnDeviceClick.onClickSwitch(position, false);
                }
            });
            convertView.setTag(holder);

        }
        ItemHolder itemHolder = (ItemHolder) convertView.getTag();

        CommontAdapterData adapterData = adapterDatas.get(position);
        itemHolder.name.setText(adapterData.name);
        return convertView;
    }

    class ItemHolder {
        public TextView name;
        public Button button;
        public Button button2;
        public long id;

    }
    public interface  IOnDeviceClick{
        public void onClickSwitch(int pos,boolean on);
        public void onClickDetail(int pos);
    }


}
