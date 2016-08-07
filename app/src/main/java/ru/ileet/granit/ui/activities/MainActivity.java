package ru.ileet.granit.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ileet.granit.data.Patients;
import ru.ileet.granit.R;
import ru.ileet.granit.adapters.SectionsPagerAdapter;
import ru.ileet.granit.data.service.Service;
import ru.ileet.granit.ui.fragments.AllPatientsFragment;
import ru.ileet.granit.ui.fragments.TodayPatientsFragment;
import ru.ileet.granit.ui.fragments.TomorrowPatientsFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public static  List<Patients> mPatients;
    public final static String PATIENTS_EXTRA = "ru.ileet.granit.MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPatients = getIntent().getParcelableArrayListExtra(PATIENTS_EXTRA);

        mViewPager = (ViewPager)findViewById(R.id.container);
        mViewPager.setClickable(true);
        mViewPager.setScrollContainer(true);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodayPatientsFragment(), "Сегодня");
        adapter.addFragment(new TomorrowPatientsFragment(), "Завтра");
        adapter.addFragment(new AllPatientsFragment(),"Все");
        mViewPager.setAdapter(adapter);

        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
