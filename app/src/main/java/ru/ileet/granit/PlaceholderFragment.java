package ru.ileet.granit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ama on 27.07.2016.
 */
public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    private List<Patients> mPatientsList;
    private ListView mListViewPatients;
    private PatientsAdapter mPatientsAdapter;
    private TextView mTextViewError;

    public PlaceholderFragment(){super();}


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);
        mListViewPatients = (ListView) rootView.findViewById(R.id.patients_list);
        mTextViewError = (TextView)getView().findViewById(R.id.txt);
        mPatientsList = getPatients();
        mPatientsAdapter = new PatientsAdapter(getContext(), mPatientsList);
        mListViewPatients.setAdapter(mPatientsAdapter);
        return rootView;
    }

    public PlaceholderFragment newInstance(int sectionNumber){
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    private List<Patients> getPatients() {
        final List<Patients> patientsList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.3.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GranitService service = retrofit.create(GranitService.class);
        Call<List<Patients>> call = service.listPatients();
        call.enqueue(new Callback<List<Patients>>() {
            @Override
            public void onResponse(Call<List<Patients>> call, Response<List<Patients>> response) {
                ListIterator<Patients> listIterPat = response.body().listIterator();
                while (listIterPat.hasNext()){
                    Patients patient = listIterPat.next();
                    patientsList.add(patient);
                }
            }

            @Override
            public void onFailure(Call<List<Patients>> call, Throwable t) {
                mTextViewError.setText("Что-то пошло не так: "+t.getMessage());
            }
        });

        return patientsList;
    }
}
