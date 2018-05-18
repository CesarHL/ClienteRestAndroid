package com.example.erick.serviciorest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erick.model.Example;

import java.util.List;

public class PagoAdapter  extends ArrayAdapter<Example> {

    private List<Example> pagosList;
    private Context context;

    public PagoAdapter(List<Example> pagosList, Context context) {
        super(context, R.layout.row_layout, pagosList);
        this.pagosList = pagosList;
        this.context = context;
    }

    public int getCount() {
        if (pagosList != null)
            return pagosList.size();
        return 0;
    }

    public Example getItem(int position) {
        if (pagosList != null)
            return pagosList.get(position);
        return null;
    }

    public long getItemId(int position) {
        if (pagosList != null)
            return pagosList.get(position).hashCode();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.row_layout, parent, false);
        }

        Example pago = pagosList.get(position);


        TextView textTitle = (TextView) convertView.findViewById(R.id.title);
        textTitle.setText(pago.getBody());

        return convertView;
    }
}
