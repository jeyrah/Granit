package ru.ileet.granit.ui.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.ileet.granit.data.Patients;
import ru.ileet.granit.adapters.PatientsAdapter;
import ru.ileet.granit.R;
import ru.ileet.granit.ui.activities.MainActivity;

/**
 * Created by Ama on 27.07.2016.
 */
public class AllPatientsFragment extends Fragment {
    private ListView mListView;
    private List<Patients> mPatientsList;
    private PatientsAdapter mPatientsAdapter;
    private final static String PATIENTS_BUNDLE = "ru.ileet.granit.AllPatinetsFragment";

    public AllPatientsFragment() {
        super();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        mPatientsList = MainActivity.mPatients;
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

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
