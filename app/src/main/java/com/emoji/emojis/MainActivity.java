package com.emoji.emojis;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.emoji.emojis.R;
import com.emoji.emojis.fragments.EightFragment;
import com.emoji.emojis.fragments.FiveFragment;
import com.emoji.emojis.fragments.FourFragment;
import com.emoji.emojis.fragments.NineFragment;
import com.emoji.emojis.fragments.OneFragment;
import com.emoji.emojis.fragments.SevenFragment;
import com.emoji.emojis.fragments.SixFragment;
import com.emoji.emojis.fragments.TenFragment;
import com.emoji.emojis.fragments.ThreeFragment;
import com.emoji.emojis.fragments.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new OneFragment(), "Angry");
        adapter.addFrag(new TwoFragment(), "Happy");
        adapter.addFrag(new ThreeFragment(), "Sad");
        adapter.addFrag(new FourFragment(), "Confused");
        adapter.addFrag(new FiveFragment(), "Girls");
        adapter.addFrag(new SixFragment(), "Boys");
        adapter.addFrag(new SevenFragment(), "Dead");
        adapter.addFrag(new EightFragment(), "Cool");
        adapter.addFrag(new NineFragment(), "Sing");
        adapter.addFrag(new TenFragment(), "Misc");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
