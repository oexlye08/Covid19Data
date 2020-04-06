package id.my.okisulton.covid19data.ui.fragment.global;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.my.okisulton.covid19data.R;
import id.my.okisulton.covid19data.api.ApiInterface;
import id.my.okisulton.covid19data.api.ServiceGenerator;
import id.my.okisulton.covid19data.ui.fragment.global.adapter.GlobalAdapter;
import id.my.okisulton.covid19data.ui.fragment.global.model.Global;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GlobalFragment extends Fragment {

    RecyclerView recyclerView;
    GlobalAdapter globalAdapter;
    ApiInterface apiInterface;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_global, container, false);

        recyclerView = view.findViewById(R.id.rc_negara);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        globalLoad();
        return view;

    }

    private void globalLoad() {
        apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<List<Global>> call = apiInterface.getGlobal();
        call.enqueue(new Callback<List<Global>>() {
            @Override
            public void onResponse(Call<List<Global>> call, Response<List<Global>> response) {
                if (response.isSuccessful() && response.body() !=null){
                    List<Global> provinsis = response.body();
                    globalAdapter = new GlobalAdapter(provinsis);
                    recyclerView.setAdapter(globalAdapter);
                    globalAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Global>> call, Throwable t) {

            }
        });
    }


}