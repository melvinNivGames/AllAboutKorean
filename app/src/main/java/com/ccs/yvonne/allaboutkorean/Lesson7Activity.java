package com.ccs.yvonne.allaboutkorean;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by melvin.g.uy on 9/12/2017.
 */

import android.content.Intent;
import android.media.Image;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Lesson7Activity extends AppCompatActivity{
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                startActivity(new Intent(Lesson7Activity.this, CategoriesActivity.class));
                finish();
            }
        });

    }
    public void onBackPressed() {
        startActivity(new Intent(Lesson7Activity.this,CategoriesActivity.class));
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Toast.makeText(Lesson7Activity.this, "Swipe left or right.", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_lesson, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            TextView korText = (TextView) rootView.findViewById(R.id.koreaContent);
            TextView engText = (TextView) rootView.findViewById(R.id.engContent);
            ImageView korImage = (ImageView) rootView.findViewById(R.id.koreaImage);
            int secNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            if(secNumber == 1)
            {
                textView.setText(getString(R.string.section_format, secNumber));
                korText.setText("nae son jab-a jul su-iss-eo?");
                engText.setText("can you hold my hand?");
                korImage.setImageResource(R.drawable.can_you_hold_my_hand);
            }
            else if(secNumber == 2)
            {
                textView.setText(getString(R.string.section_format, secNumber));
                korText.setText("jebal kiseu haejwo");
                engText.setText("kiss me please");
                korImage.setImageResource(R.drawable.kiss_me_please);
            }
            else if(secNumber == 3)
            {
                textView.setText(getString(R.string.section_format, secNumber));
                korText.setText("neo neoui geos");
                engText.setText("i'm yours");
                korImage.setImageResource(R.drawable.im_yours);
            }
            else if(secNumber == 4)
            {
                textView.setText(getString(R.string.section_format, secNumber));
                korText.setText("salanghae");
                engText.setText("i love you");
                korImage.setImageResource(R.drawable.i_love_you);
            }
            else if(secNumber == 5)
            {
                textView.setText(getString(R.string.section_format, secNumber));
                korText.setText("neo nae ma-eum-i peolleog-ige hae");
                engText.setText("you make my heart flutter");
                korImage.setImageResource(R.drawable.you_make_my_heart_flutter);
            }
            else if(secNumber == 6)
            {
                textView.setText(getString(R.string.section_format, secNumber));
                korText.setText("naneun nae insaeng-eseo dangsin-i pil-yo");
                engText.setText("i need you in my life");
                korImage.setImageResource(R.drawable.i_need_you_in_my_life);
            }
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 6 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
                case 3:
                    return "SECTION 4";
                case 4:
                    return "SECTION 5";
                case 5:
                    return "SECTION 6";
            }
            return null;
        }
    }
}
