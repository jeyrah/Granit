package ru.ileet.granit.data.service;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import ru.ileet.granit.data.Patients;

/**
 * Created by Ama on 05.08.2016.
 */
public class Service {

    public static interface Server {
        @GET("patient/get")
        Call<List<Patients>> listPatients();
    }


}
