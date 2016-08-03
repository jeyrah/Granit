package ru.ileet.granit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    public List<Patients> mPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPatients = getPatients();

        mViewPager = (ViewPager)findViewById(R.id.container);
        mViewPager.setClickable(true);
        mViewPager.setScrollContainer(true);

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TodayPatientsFragment(mPatients), "Сегодня");
        adapter.addFragment(new TomorrowPatientsFrag(mPatients), "Завтра");
        adapter.addFragment(new AllPatinetsFrag(mPatients),"Все");
        mViewPager.setAdapter(adapter);

        mTabLayout = (TabLayout)findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private List<Patients> getPatients() {
        final List<Patients> patientsList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://176.112.212.179/")
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
                Toast.makeText(MainActivity.this,"Что-то пошло не так: "+t.getMessage(),Toast.LENGTH_LONG)
                    .show();
            }
        });

        return patientsList;
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
