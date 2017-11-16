package geocoder.kw.tex.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import geocoder.kw.tex.myapplication.Model.Mantan;
import geocoder.kw.tex.myapplication.R;

/**
 * Created by User on 16-Nov-17.
 */

public class MantanAdapter extends RecyclerView.Adapter<MantanAdapter.MantanViewHolder> {
    private List<Mantan> mantans;

    public MantanAdapter(List<Mantan> mantans) {
        this.mantans = mantans;
    }

    @Override
    public MantanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mantan,parent,false);
        MantanViewHolder mantanViewHolder = new MantanViewHolder(view);
        return mantanViewHolder;
    }

    @Override
    public void onBindViewHolder(MantanViewHolder holder, int position) {
        Mantan mantan = mantans.get(position);
        holder.namaMantan.setText(mantan.getNama());
        holder.tglJadian.setText(mantan.getTglJadian());
        holder.tglPutus.setText(mantan.getTglPutus());

    }

    @Override
    public int getItemCount() {
        return mantans.size();
    }

    public class MantanViewHolder extends RecyclerView.ViewHolder {
        TextView namaMantan,tglJadian,tglPutus;


        public MantanViewHolder(View itemView) {
            super(itemView);
            namaMantan = (TextView) itemView.findViewById(R.id.tv_nama_mantan);
            tglJadian = (TextView) itemView.findViewById(R.id.tv_tanggal_jadian);
            tglPutus = (TextView) itemView.findViewById(R.id.tv_tanggal_putus);
        }
    }
}
