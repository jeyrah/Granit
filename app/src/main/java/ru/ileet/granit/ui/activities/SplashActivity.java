package ru.ileet.granit.ui.activities;

import android.content.Context;
import android.content.Intent;

import android.os.Handler;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import pl.tajchert.sample.DotsTextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ileet.granit.R;
import ru.ileet.granit.data.Patients;
import ru.ileet.granit.data.service.Service;

public class SplashActivity extends AppCompatActivity {
    private List<Patients> mPatientsList;
    private DotsTextView mDots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mDots = new DotsTextView(this);
        mDots.showAndPlay();
        mDots.start();

        mPatientsList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://176.112.212.179/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service.Server service = retrofit.create(Service.Server.class);
        Call<List<Patients>> call = service.listPatients();
        call.enqueue(new Callback<List<Patients>>() {
            @Override
            public void onResponse(Call<List<Patients>> call, Response<List<Patients>> response) {
                ListIterator<Patients> listIterPat = response.body().listIterator();
                while (listIterPat.hasNext()) {
                    Patients patient = listIterPat.next();
                    mPatientsList.add(patient);
                }
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                intent.putParcelableArrayListExtra(MainActivity.PATIENTS_EXTRA,
                        (ArrayList<? extends Parcelable>) mPatientsList);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<List<Patients>> call, Throwable t) {
                TextView noConnectingTextView = (TextView)findViewById(R.id.noConnecting);
                noConnectingTextView.setVisibility(View.VISIBLE);
            }
        });
    }
}
