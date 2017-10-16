package com.ccs.yvonne.allaboutkorean;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz2Activity extends AppCompatActivity {
    int score = 0;
    static int answer[];
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
        setContentView(R.layout.activity_quiz1);
        answer = new int[25];

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
                startActivity(new Intent(Quiz2Activity.this, CategoriesQuizActivity.class));
                answer = new int[0];
                finish();
            }
        });

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int num: answer)
                {
                    score += num;
                }
                Toast.makeText(Quiz2Activity.this, "Score: " + score + " out of 25", Toast.LENGTH_SHORT).show();
                score = 0;
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(Quiz2Activity.this,CategoriesQuizActivity.class));
        answer = new int[0];
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz1, menu);
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
            Toast.makeText(Quiz2Activity.this, "        Swipe left or right.\nClick save button to submit.",
                    Toast.LENGTH_LONG).show();
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
            View rootView = inflater.inflate(R.layout.fragment_quiz1, container, false);
            TextView engTextQuiz = (TextView) rootView.findViewById(R.id.engContentQuiz);
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(0xFFFFFFFF); // Changes this drawbale to use a single color instead of a gradient
            gd.setCornerRadius(5);
            gd.setStroke(5, 0xFF000000);
            TextView korTextQuiz = (TextView) rootView.findViewById(R.id.koreaContentQuiz);
            korTextQuiz.setBackground(gd);

            final CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
            Button btnChoice1 = (Button) rootView.findViewById(R.id.choice1);
            Button btnChoice2 = (Button) rootView.findViewById(R.id.choice2);
            Button btnChoice3 = (Button) rootView.findViewById(R.id.choice3);
            ImageView korImageQuiz = (ImageView) rootView.findViewById(R.id.koreaImageQuiz);
            final int secNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            btnChoice1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(secNumber == 1 || secNumber == 3 || secNumber == 4 || secNumber == 8 || secNumber == 9 ||
                            secNumber == 11 || secNumber == 13 || secNumber == 14 || secNumber == 18 || secNumber == 19 ||
                            secNumber == 23 || secNumber == 24)
                    {
                        answer[secNumber-1] = 1;
                        checkBox.setChecked(true);
                    }
                    else
                    {
                        answer[secNumber-1] = 0;
                        checkBox.setChecked(true);
                    }
                }
            });

            btnChoice2.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(secNumber == 6 || secNumber == 10 || secNumber == 16 || secNumber == 20)
                    {
                        answer[secNumber-1] = 1;
                        checkBox.setChecked(true);
                    }
                    else
                    {
                        answer[secNumber-1] = 0;
                        checkBox.setChecked(true);
                    }
                }
            });

            btnChoice3.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(secNumber == 2 || secNumber == 5 || secNumber == 7 || secNumber == 12 || secNumber == 15 ||
                            secNumber == 17 || secNumber == 21 || secNumber == 22 || secNumber == 25)
                    {
                        answer[secNumber-1] = 1;
                        checkBox.setChecked(true);
                    }
                    else
                    {
                        answer[secNumber-1] = 0;
                        checkBox.setChecked(true);
                    }
                }
            });

            if(secNumber == 1)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("cloud");
                korImageQuiz.setImageResource(R.drawable.cloudy);
                btnChoice1.setText("heulin");//ETO
                btnChoice2.setText("ttatteushan");
                btnChoice3.setText("chuwi");
            }
            else if(secNumber == 2)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("university");
                korImageQuiz.setImageResource(R.drawable.university);
                btnChoice1.setText("junghaggyo");
                btnChoice2.setText("yuchiwon");
                btnChoice3.setText("daehag");//ETO
            }
            else if(secNumber == 3)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("orange");
                korImageQuiz.setImageResource(R.drawable.orangec);
                btnChoice1.setText("juhwangsaeg");//ETO
                btnChoice2.setText("galsaeg");
                btnChoice3.setText("hwaiteu");
            }
            else if(secNumber == 4)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("snow");
                korImageQuiz.setImageResource(R.drawable.snow);
                btnChoice1.setText("nun");//ETO
                btnChoice2.setText("angae");
                btnChoice3.setText("balam-i sen");
            }
            else if(secNumber == 5)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("green");
                korImageQuiz.setImageResource(R.drawable.green);
                btnChoice1.setText("ja");
                btnChoice2.setText("hwaiteu");
                btnChoice3.setText("nogsaeg");//ETO
            }
            else if(secNumber == 6)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("black");
                korImageQuiz.setImageResource(R.drawable.black);
                btnChoice1.setText("hoesaeg");
                btnChoice2.setText("geom-eun");//ETO
                btnChoice3.setText("ja");
            }
            else if(secNumber == 7)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("elementary school");
                korImageQuiz.setImageResource(R.drawable.elementary_school);
                btnChoice1.setText("godeunghaggyo");
                btnChoice2.setText("yuchiwon");
                btnChoice3.setText("chodeunghaggyo");//ETO
            }
            else if(secNumber == 8)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("red");
                korImageQuiz.setImageResource(R.drawable.red);
                btnChoice1.setText("ppalgan");//ETO
                btnChoice2.setText("jebikkoch");
                btnChoice3.setText("galsaeg");
            }
            else if(secNumber == 9)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("warm");
                korImageQuiz.setImageResource(R.drawable.warm);
                btnChoice1.setText("ttatteushan");//ETO
                btnChoice2.setText("chuwi");
                btnChoice3.setText("haesbich");
            }
            else if(secNumber == 10)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("violet");
                korImageQuiz.setImageResource(R.drawable.violet);
                btnChoice1.setText("juhwangsaeg");
                btnChoice2.setText("jebikkoch");//ETO
                btnChoice3.setText("ppalgan");
            }
            else if(secNumber == 11)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("north america");
                korImageQuiz.setImageResource(R.drawable.north_america);
                btnChoice1.setText("bug-amelika");//ETO
                btnChoice2.setText("asia");
                btnChoice3.setText("yuleob");
            }
            else if(secNumber == 12)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("middle school");
                korImageQuiz.setImageResource(R.drawable.middle_school);
                btnChoice1.setText("daehag");
                btnChoice2.setText("yuchiwon");
                btnChoice3.setText("junghaggyo");//ETO
            }
            else if(secNumber == 13)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("gray");
                korImageQuiz.setImageResource(R.drawable.gray);
                btnChoice1.setText("hoesaeg");//ETO
                btnChoice2.setText("galsaeg");
                btnChoice3.setText("ppalgan");
            }
            else if(secNumber == 14)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("windy");
                korImageQuiz.setImageResource(R.drawable.windy);
                btnChoice1.setText("balam-i sen");//ETO
                btnChoice2.setText("chuwi");
                btnChoice3.setText("heulin");
            }
            else if(secNumber == 15)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("white");
                korImageQuiz.setImageResource(R.drawable.white);
                btnChoice1.setText("nogsaeg");
                btnChoice2.setText("geom-eun");
                btnChoice3.setText("hwaiteu");//ETO
            }
            else if(secNumber == 16)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("blue");
                korImageQuiz.setImageResource(R.drawable.blue);
                btnChoice1.setText("ja");
                btnChoice2.setText("puleun");//ETO
                btnChoice3.setText("hoesaeg");
            }
            else if(secNumber == 17)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("high school");
                korImageQuiz.setImageResource(R.drawable.high_school);
                btnChoice1.setText("yuchiwon");
                btnChoice2.setText("chodeunghaggyo");
                btnChoice3.setText("godeunghaggyo");//ETO
            }
            else if(secNumber == 18)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("purple");
                korImageQuiz.setImageResource(R.drawable.purple);
                btnChoice1.setText("ja");//ETO
                btnChoice2.setText("hoesaeg");
                btnChoice3.setText("galsaeg");
            }
            else if(secNumber == 19)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("sunshine");
                korImageQuiz.setImageResource(R.drawable.sunshine);
                btnChoice1.setText("haesbich");//ETO
                btnChoice2.setText("nun");
                btnChoice3.setText("heulin");
            }
            else if(secNumber == 20)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("brown");
                korImageQuiz.setImageResource(R.drawable.brown);
                btnChoice1.setText("ppalgan");
                btnChoice2.setText("galsaeg");//ETO
                btnChoice3.setText("juhwangsaeg");
            }
            else if(secNumber == 21)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("south america");
                korImageQuiz.setImageResource(R.drawable.south_america);
                btnChoice1.setText("bug-amelika");
                btnChoice2.setText("yuleob");
                btnChoice3.setText("nam-amelika");//ETO
            }
            else if(secNumber == 22)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("kindergarten");
                korImageQuiz.setImageResource(R.drawable.kindergarten);
                btnChoice1.setText("junghaggyo");
                btnChoice2.setText("daehag");
                btnChoice3.setText("yuchiwon");//ETO
            }
            else if(secNumber == 23)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("rain");
                korImageQuiz.setImageResource(R.drawable.rain);
                btnChoice1.setText("bi");//ETO
                btnChoice2.setText("nun");
                btnChoice3.setText("heulin");
            }
            else if(secNumber == 24)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("fog");
                korImageQuiz.setImageResource(R.drawable.fog);
                btnChoice1.setText("angae");//ETO
                btnChoice2.setText("heulin");
                btnChoice3.setText("chuwi");
            }
            else if(secNumber == 25)
            {
                korTextQuiz.setText("  ??  ");
                engTextQuiz.setText("cold");
                korImageQuiz.setImageResource(R.drawable.cold);
                btnChoice1.setText("bi");
                btnChoice2.setText("nogsaeg");
                btnChoice3.setText("chuwi");//ETO
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
            // Show 25 total pages.
            return 25;
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
                case 12:
                    return "SECTION 13";
                case 13:
                    return "SECTION 14";
                case 14:
                    return "SECTION 15";
                case 15:
                    return "SECTION 16";
                case 16:
                    return "SECTION 17";
                case 17:
                    return "SECTION 18";
                case 18:
                    return "SECTION 19";
                case 19:
                    return "SECTION 20";
                case 20:
                    return "SECTION 21";
                case 21:
                    return "SECTION 22";
                case 22:
                    return "SECTION 23";
                case 23:
                    return "SECTION 24";
                case 24:
                    return "SECTION 25";
            }
            return null;
        }
    }
}