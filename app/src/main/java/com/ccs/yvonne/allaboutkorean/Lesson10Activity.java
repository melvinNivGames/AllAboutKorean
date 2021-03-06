package com.ccs.yvonne.allaboutkorean;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

public class Lesson10Activity extends AppCompatActivity{
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

    }
    public void onBackPressed() {
        startActivity(new Intent(Lesson10Activity.this,CategoriesActivity.class));
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
            Toast.makeText(Lesson10Activity.this, "Swipe left or right.", Toast.LENGTH_SHORT).show();
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
                korText.setText("wonsung-i");
                engText.setText("monkey");
                korImage.setImageResource(R.drawable.monkey);
            }
            else if(secNumber == 2)
            {
                korText.setText("peng-gwin");
                engText.setText("penguin");
                korImage.setImageResource(R.drawable.penguin);
            }
            else if(secNumber == 3)
            {
                korText.setText("gae");
                engText.setText("dog");
                korImage.setImageResource(R.drawable.dog);
            }
            else if(secNumber == 4)
            {
                korText.setText("saja");
                engText.setText("lion");
                korImage.setImageResource(R.drawable.lion);
            }
            else if(secNumber == 5)
            {
                korText.setText("holang-i");
                engText.setText("tiger");
                korImage.setImageResource(R.drawable.tiger);
            }
            else if(secNumber == 6)
            {
                korText.setText("gom");
                engText.setText("bear");
                korImage.setImageResource(R.drawable.bear);
            }
            else if(secNumber == 7)
            {
                korText.setText("jwi");
                engText.setText("rat");
                korImage.setImageResource(R.drawable.rat);
            }
            else if(secNumber == 8)
            {
                korText.setText("yang");
                engText.setText("sheep");
                korImage.setImageResource(R.drawable.sheep);
            }
            else if(secNumber == 9)
            {
                korText.setText("paendeo");
                engText.setText("panda");
                korImage.setImageResource(R.drawable.panda);
            }
            else if(secNumber == 10)
            {
                korText.setText("dwaeji");
                engText.setText("pig");
                korImage.setImageResource(R.drawable.pig);
            }
            else if(secNumber == 11)
            {
                korText.setText("mal");
                engText.setText("horse");
                korImage.setImageResource(R.drawable.horse);
            }
            else if(secNumber == 12)
            {
                korText.setText("goyang-i");
                engText.setText("cat");
                korImage.setImageResource(R.drawable.cat);
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
            // Show 12 total pages.
            return 12;
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
                case 6:
                    return "SECTION 7";
                case 7:
                    return "SECTION 8";
                case 8:
                    return "SECTION 9";
                case 9:
                    return "SECTION 10";
                case 10:
                    return "SECTION 11";
                case 11:
                    return "SECTION 12";
            }
            return null;
        }
    }
}