package id.my.okisulton.covid19data.ui.fragment.indonesia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.my.okisulton.covid19data.R;
import id.my.okisulton.covid19data.ui.fragment.indonesia.model.Provinsi;

public class ProvinsiAdapter extends RecyclerView.Adapter<ProvinsiAdapter.ViewHolder> {


    private List<Provinsi> provinsis;

    public ProvinsiAdapter(List<Provinsi> provinsis) {
        this.provinsis = provinsis;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_provinsi.setText(provinsis.get(position).getAtribute().getProvinsi());
        holder.tv_positif.setText(provinsis.get(position).getAtribute().getKasus_Posi());
        holder.tv_meninggal.setText(provinsis.get(position).getAtribute().getKasus_Meni());
        holder.tv_sembuh.setText(provinsis.get(position).getAtribute().getKasus_Semb());

    }

    @Override
    public int getItemCount() {
        return provinsis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_positif, tv_meninggal, tv_sembuh, tv_provinsi;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_provinsi = itemView.findViewById(R.id.tv_provinsi);
            tv_positif = itemView.findViewById(R.id.tv_positif);
            tv_meninggal = itemView.findViewById(R.id.tv_meninggal);
            tv_sembuh = itemView.findViewById(R.id.tv_sembuh);

        }
    }
}
