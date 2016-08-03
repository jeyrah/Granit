package ru.ileet.granit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Ama on 22.07.2016.
 */
public class PatientsAdapter extends BaseAdapter{
    private Context mContext;
    private List<Patients> mPatientsList;
    private long mDateTime;

    public PatientsAdapter(Context context, List<Patients> patientsList){
        mContext = context;
        mPatientsList = patientsList;
    }

    @Override
    public int getCount() {
        return mPatientsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPatientsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.patinets_list_view, null);
        }

        ImageView profileImage = (ImageView) convertView.findViewById(R.id.profile_image);
        TextView fullname = (TextView) convertView.findViewById(R.id.fullname);
        TextView price = (TextView) convertView.findViewById(R.id.price);
        TextView dateTime = (TextView) convertView.findViewById(R.id.dateTime);

        if(mPatientsList.get(position).getPhoto() == ""){
            Picasso.with(mContext).load(R.drawable.nofoto).into(profileImage);
        } else {
            Picasso.with(mContext)
                    .load(mPatientsList.get(position).getPhoto()+".jpg")
                    .placeholder(R.drawable.nofoto)
                    .error(R.drawable.error)
                    .into(profileImage);
        }

        fullname.setText(String.valueOf(mPatientsList.get(position).getFullname()));

        price.setText(String.valueOf(mPatientsList.get(position).getPrice()));

        mDateTime = mPatientsList.get(position).getDate1();

        dateTime.setText(new ConvertTimeSTtoDateTime(mDateTime,"dd.MM.yyyy HH:mm").getFormattedDate());

        return convertView;
    }
}
