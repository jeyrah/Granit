package ru.ileet.granit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ama on 19.07.2016.
 */
public interface GranitService {
    @GET ("patient/get")
    Call<List<Patients>> listPatients();
}
