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
import ru.ileet.granit.R;
import ru.ileet.granit.adapters.PatientsAdapter;
import ru.ileet.granit.helpers.DateTime;
import ru.ileet.granit.ui.activities.MainActivity;



/**
 * Created by Ama on 27.07.2016.
 */
public class TodayPatientsFragment extends Fragment {
    private List<Patients> mPatientsList;
   private List<Patients> mPatientsListToday;


    private ListView mListView;
    private PatientsAdapter mPatientsAdapter;

    private final static String PATIENTS_BUNDLE = "ru.ileet.granit.TodayPatientsFragment";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPatientsList = MainActivity.mPatients;

        if(savedInstanceState != null){
           mPatientsListToday = savedInstanceState.getParcelableArrayList(
                   TodayPatientsFragment.PATIENTS_BUNDLE);
        } else {
           mPatientsListToday = new ArrayList<>();
            DateTime dateTime = new DateTime();
            for (int i = 0; i < mPatientsList.size(); i++) {
                long serverDate = mPatientsList.get(i).getDate1();

                if(dateTime.isSameDay(serverDate)){
                   mPatientsListToday.add(mPatientsList.get(i));
                }
            }
        }

        View rootView = inflater.inflate(R.layout.today_frag, container, false);
        mListView = (ListView)rootView.findViewById(R.id.patients_list_today);
        mPatientsAdapter = new PatientsAdapter(getContext(), mPatientsListToday);
        mListView.setAdapter(mPatientsAdapter);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(TodayPatientsFragment.PATIENTS_BUNDLE,
                (ArrayList<? extends Parcelable>) mPatientsListToday);
        super.onSaveInstanceState(outState);
    }
}
