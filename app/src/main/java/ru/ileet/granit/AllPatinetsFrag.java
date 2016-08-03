package ru.ileet.granit;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ama on 27.07.2016.
 */
public class AllPatinetsFrag extends Fragment {
    private ListView mListView;
    private List<Patients> mPatientsList;
    private PatientsAdapter mPatientsAdapter;
    private final static String PATIENTS_BUNDLE = "ru.ileet.granit.TomorrowPatientsFrag";

    public AllPatinetsFrag() {
        super();
    }

    public AllPatinetsFrag(List<Patients> patientsList){
        mPatientsList = patientsList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mPatientsList = savedInstanceState.getParcelableArrayList(PATIENTS_BUNDLE);
        }
        View rootView = inflater.inflate(R.layout.all_frag, container, false);
        mListView = (ListView)rootView.findViewById(R.id.patients_list_all);
        mPatientsAdapter = new PatientsAdapter(getContext(), mPatientsList);
        mListView.setAdapter(mPatientsAdapter);

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(PATIENTS_BUNDLE, (ArrayList<? extends Parcelable>) mPatientsList);
        super.onSaveInstanceState(outState);
    }
}
