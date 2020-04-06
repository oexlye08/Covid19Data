package id.my.okisulton.covid19data.ui.fragment.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import id.my.okisulton.covid19data.R;
import id.my.okisulton.covid19data.api.ApiInterface;
import id.my.okisulton.covid19data.api.ServiceGenerator;
import id.my.okisulton.covid19data.ui.fragment.home.model.Dead;
import id.my.okisulton.covid19data.ui.fragment.home.model.Positive;
import id.my.okisulton.covid19data.ui.fragment.home.model.Recovered;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private final String TAG = HomeFragment.class.getSimpleName();

    private TextView total_positive_global, total_recovered_global, total_dead_global;
    ApiInterface apiInterface;
    ProgressBar progressBar;
    LinearLayout linearLayout;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        total_positive_global = view.findViewById(R.id.total_positive_global);
        total_dead_global = view.findViewById(R.id.total_dead_global);
        total_recovered_global = view.findViewById(R.id.total_recovered_global);
        progressBar = view.findViewById(R.id.progressbar);
        linearLayout = view.findViewById(R.id.linearLayout);

        View decorView = getActivity().getWindow().getDecorView(); // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(uiOptions);

        deadLoad();
        recoveredLoad();
        positiveLoad();
        return view;
    }

    private void positiveLoad() {
        apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<Positive> call = apiInterface.getPositive();

        call.enqueue(new Callback<Positive>() {
            @Override
            public void onResponse(Call<Positive> call, Response<Positive> response) {
                if (response.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.VISIBLE);
                    total_positive_global.setText(response.body().getValue());
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<Positive> call, Throwable t) {

            }
        });


    }

    private void recoveredLoad() {
        apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<Recovered> call = apiInterface.getRecovered();

        call.enqueue(new Callback<Recovered>() {
            @Override
            public void onResponse(Call<Recovered> call, Response<Recovered> response) {
                total_recovered_global.setText(response.body().getValue());
            }

            @Override
            public void onFailure(Call<Recovered> call, Throwable t) {

            }
        });

    }

    private void deadLoad() {
        apiInterface = ServiceGenerator.createService(ApiInterface.class);
        Call<Dead> call = apiInterface.getDead();

        call.enqueue(new Callback<Dead>() {
            @Override
            public void onResponse(Call<Dead> call, Response<Dead> response) {
                total_dead_global.setText(response.body().getValue());

            }

            @Override
            public void onFailure(Call<Dead> call, Throwable t) {

            }
        });

    }
}