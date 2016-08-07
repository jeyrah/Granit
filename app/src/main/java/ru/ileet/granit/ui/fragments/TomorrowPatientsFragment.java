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

import ru.ileet.granit.adapters.PatientsAdapter;
import ru.ileet.granit.data.Patients;
import ru.ileet.granit.R;
import ru.ileet.granit.helpers.DateTime;
import ru.ileet.granit.ui.activities.MainActivity;

/**
 * Created by Ama on 27.07.2016.
 */
public class TomorrowPatientsFragment extends Fragment {
    private List<Patients> mPatientsList;
    private List<Patients> mPatientsListTomorrow;

    private ListView mListView;
    private PatientsAdapter mPatientsAdapter;

    private final static String PATIENTS_BUNDLE = "ru.ileet.granit.TomorrowPatientsFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPatientsList = MainActivity.mPatients;

        if (savedInstanceState != null){
            mPatientsListTomorrow = savedInstanceState.getParcelableArrayList(
                    TomorrowPatientsFragment.PATIENTS_BUNDLE);
        } else {
            mPatientsListTomorrow = new ArrayList<>();
            DateTime dateTime = new DateTime();
            for (int i = 0; i < mPatientsList.size() ; i++) {
                long serverTimestamp = mPatientsList.get(i).getDate1();

                if (dateTime.isNextDay(serverTimestamp)){
                    mPatientsListTomorrow.add(mPatientsList.get(i));
                }
            }
        }

        View rootView = inflater.inflate(R.layout.tomorrow_frag, container, false);
        mListView = (ListView) rootView.findViewById(R.id.patients_list_tomorrow);
        mPatientsAdapter = new PatientsAdapter(getContext(),mPatientsListTomorrow);
        mListView.setAdapter(mPatientsAdapter);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(TomorrowPatientsFragment.PATIENTS_BUNDLE,
                (ArrayList<? extends Parcelable>) mPatientsListTomorrow);
        super.onSaveInstanceState(outState);
    }
}
