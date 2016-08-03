package ru.ileet.granit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ama on 27.07.2016.
 */
public class TodayPatientsFragment extends Fragment {
    private List<Patients> mPatientsList;
    private ListView mListView;

    public TodayPatientsFragment() {
        super();
    }

    TodayPatientsFragment(List<Patients> patientsList){
        mPatientsList = patientsList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.today_frag, container, false);
        mListView = (ListView)rootView.findViewById(R.id.patients_list_today);
        return rootView;
    }
}
