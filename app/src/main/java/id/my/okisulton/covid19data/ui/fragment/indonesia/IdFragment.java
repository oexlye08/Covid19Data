package id.my.okisulton.covid19data.ui.fragment.indonesia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.my.okisulton.covid19data.R;
import id.my.okisulton.covid19data.api.ApiInterface;
import id.my.okisulton.covid19data.api.ServiceGenerator;
import id.my.okisulton.covid19data.ui.fragment.indonesia.adapter.ProvinsiAdapter;
import id.my.okisulton.covid19data.ui.fragment.indonesia.model.Data;
import id.my.okisulton.covid19data.ui.fragment.indonesia.model.Provinsi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IdFragment extends Fragment {
    private final String TAG = IdFragment.class.getSimpleName();

    TextView total_positive_id, total_meninggal_id, total_sembuh_id;
    ApiInterface apiInterface;

    RecyclerView recyclerView;
    ProvinsiAdapter provinsiAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_id, container, false);

        total_positive_id = view.findViewById(R.id.total_positive_id);
        total_meninggal_id = view.findViewById(R.id.total_meninggal_id);
        total_sembuh_id = view.findViewById(R.id.total_sembuh_id);
        recyclerView = view.findViewById(R.id.rc_provinsi);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
//


        sembuhId();
        provinceLoad();


        return view;
    }

    private void provinceLoad() {
        apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<Provinsi>> call = apiInterface.getProv();
        call.enqueue(new Callback<List<Provinsi>>() {
            @Override
            public void onResponse(Call<List<Provinsi>> call, Response<List<Provinsi>> response) {
                if (response.isSuccessful() && response.body() !=null){
                    List<Provinsi> provinsis = response.body();
                    provinsiAdapter = new ProvinsiAdapter(provinsis);
                    recyclerView.setAdapter(provinsiAdapter);
                    provinsiAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Provinsi>> call, Throwable t) {

            }
        });
    }

    private void sembuhId() {
        apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<ArrayList<Data>> call = apiInterface.getDataId();

        call.enqueue(new Callback<ArrayList<Data>>() {
            @Override
            public void onResponse(Call<ArrayList<Data>> call, Response<ArrayList<Data>> response) {
                total_positive_id.setText(response.body().get(0).getPositif());
                total_meninggal_id.setText(response.body().get(0).getMeninggal());
                total_sembuh_id.setText(response.body().get(0).getSembuh());
            }

            @Override
            public void onFailure(Call<ArrayList<Data>> call, Throwable t) {

            }
        });
    }

}