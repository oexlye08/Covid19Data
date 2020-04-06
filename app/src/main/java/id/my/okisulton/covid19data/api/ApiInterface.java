package id.my.okisulton.covid19data.api;

import java.util.ArrayList;
import java.util.List;

import id.my.okisulton.covid19data.ui.fragment.global.model.Global;
import id.my.okisulton.covid19data.ui.fragment.home.model.Dead;
import id.my.okisulton.covid19data.ui.fragment.home.model.Positive;
import id.my.okisulton.covid19data.ui.fragment.home.model.Recovered;
import id.my.okisulton.covid19data.ui.fragment.indonesia.model.Data;
import id.my.okisulton.covid19data.ui.fragment.indonesia.model.Provinsi;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/meninggal")
    Call<Dead> getDead();

    @GET("/sembuh")
    Call<Recovered> getRecovered();

    @GET("/positif")
    Call<Positive> getPositive();

    @GET("/indonesia")
    Call<ArrayList<Data>> getDataId();

    @GET("/indonesia/provinsi")
    Call<List<Provinsi>> getProv();

    @GET("/")
    Call<List<Global>> getGlobal();



}
