package co.edu.uninorte.betit.View;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import co.edu.uninorte.betit.R;
import co.edu.uninorte.betit.model.Match;

public class ViewPagerActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPagerItemFragment.FragmentPagerItemCallback{

    private TabLayout tabLayout;

    private ViewPager pager;

    public static final String[] pageTitles = {"matches","bets","profile","users"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        getSupportActionBar().setElevation(0f);

        pager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tbl_basic);

        setUpPagerAndTabs();



    }

    private void setUpPagerAndTabs(){
        tabLayout.setTabTextColors(ContextCompat.getColor(this,android.R.color.white),
                ContextCompat.getColor(this,R.color.accent));
        tabLayout.setBackgroundColor(ContextCompat.getColor(this,R.color.primary));
        tabLayout.addOnTabSelectedListener(this);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),getApplicationContext());
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(pager);
        tabLayout.addOnTabSelectedListener(this);
    }

    public void dataChanged() {
        pager.getAdapter().notifyDataSetChanged();
    }



    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        pager.setCurrentItem(tab.getPosition(),true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPagerItemClick(String message) {
        Toast.makeText(this,message + "!",Toast.LENGTH_SHORT).show();
    }





}
