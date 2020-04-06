package id.my.okisulton.covid19data.ui.fragment.global.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.my.okisulton.covid19data.R;
import id.my.okisulton.covid19data.ui.fragment.global.model.Global;

public class GlobalAdapter extends RecyclerView.Adapter<GlobalAdapter.ViewHolder> {

    private List<Global> globals;

    public GlobalAdapter(List<Global> globals) {
        this.globals = globals;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_global, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_negara.setText(globals.get(position).getAttributes().getCountry_Region());
        holder.tv_positif_negara.setText(globals.get(position).getAttributes().getConfirmed());
        holder.tv_sembuh_negara.setText(globals.get(position).getAttributes().getRecovered());
        holder.tv_meninggal_negara.setText(globals.get(position).getAttributes().getDeaths());

    }

    @Override
    public int getItemCount() {
        return globals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_negara, tv_positif_negara, tv_sembuh_negara, tv_meninggal_negara;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_negara = itemView.findViewById(R.id.tv_negara);
            tv_positif_negara = itemView.findViewById(R.id.tv_positif_negara);
            tv_sembuh_negara = itemView.findViewById(R.id.tv_sembuh_negara);
            tv_meninggal_negara = itemView.findViewById(R.id.tv_meninggal_negara);
        }
    }
}
