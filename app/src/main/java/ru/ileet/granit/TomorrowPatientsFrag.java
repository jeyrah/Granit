package ru.ileet.granit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ama on 27.07.2016.
 */
public class TomorrowPatientsFrag extends Fragment {
    private List<Patients> mPatientsList;

    public TomorrowPatientsFrag() {
        super();
    }

    public TomorrowPatientsFrag(List<Patients> patientsList){
        mPatientsList = patientsList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tomorrow_frag, container, false);
        ((TextView)rootView.findViewById(R.id.text2)).setText("Tomorrow");
        return rootView;
    }
}
