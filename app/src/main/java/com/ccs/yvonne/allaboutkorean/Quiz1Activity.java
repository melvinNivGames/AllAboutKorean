package com.ccs.yvonne.allaboutkorean;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.FloatingActionButton;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Quiz1Activity extends AppCompatActivity {
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
                startActivity(new Intent(Quiz1Activity.this, CategoriesQuizActivity.class));
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
                Toast.makeText(Quiz1Activity.this, "Score: " + score + " out of 25", Toast.LENGTH_SHORT).show();
                score = 0;
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(Quiz1Activity.this,CategoriesQuizActivity.class));
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
            Toast.makeText(Quiz1Activity.this, "        Swipe left or right.\nClick save button to submit.",
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
            TextView korTextQuiz = (TextView) rootView.findViewById(R.id.koreaContentQuiz);
            GradientDrawable gd = new GradientDrawable();
            gd.setColor(0xFFFFFFFF); // Changes this drawbale to use a single color instead of a gradient
            gd.setCornerRadius(5);
            gd.setStroke(5, 0xFF000000);
            TextView engTextQuiz = (TextView) rootView.findViewById(R.id.engContentQuiz);
            engTextQuiz.setBackground(gd);

            final CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
            Button btnChoice1 = (Button) rootView.findViewById(R.id.choice1);
            Button btnChoice2 = (Button) rootView.findViewById(R.id.choice2);
            Button btnChoice3 = (Button) rootView.findViewById(R.id.choice3);
            ImageView korImageQuiz = (ImageView) rootView.findViewById(R.id.koreaImageQuiz);
            final int secNumber = getArguments().getInt(ARG_SECTION_NUMBER);

            btnChoice1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(secNumber == 5 || secNumber == 6 || secNumber == 9 || secNumber == 11 || secNumber == 14 ||
                            secNumber == 20)
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
                    if(secNumber == 8 || secNumber == 10 || secNumber == 12 || secNumber == 13 || secNumber == 15 ||
                            secNumber == 16 || secNumber == 17 || secNumber == 19 || secNumber == 21 || secNumber == 24)
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
                    if(secNumber == 1 || secNumber == 2 || secNumber == 3 || secNumber == 4 || secNumber == 7 ||
                            secNumber == 18 || secNumber == 22 || secNumber == 23|| secNumber == 25)
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
                korTextQuiz.setText("hana");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.one);
                btnChoice1.setText("seven");
                btnChoice2.setText("four");
                btnChoice3.setText("one");
            }
            else if(secNumber == 2)
            {
                korTextQuiz.setText("du");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.two);
                btnChoice1.setText("three");
                btnChoice2.setText("seven");
                btnChoice3.setText("two");
            }
            else if(secNumber == 3)
            {
                korTextQuiz.setText("daseos");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.five);
                btnChoice1.setText("six");
                btnChoice2.setText("three");
                btnChoice3.setText("five");
            }
            else if(secNumber == 4)
            {
                korTextQuiz.setText("ahob");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.nine);
                btnChoice1.setText("four");
                btnChoice2.setText("two");
                btnChoice3.setText("nine");
            }
            else if(secNumber == 5)
            {
                korTextQuiz.setText("yug");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.six);
                btnChoice1.setText("six");
                btnChoice2.setText("nine");
                btnChoice3.setText("one");
            }
            else if(secNumber == 6)
            {
                korTextQuiz.setText("se");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.three);
                btnChoice1.setText("three");
                btnChoice2.setText("five");
                btnChoice3.setText("eight");
            }
            else if(secNumber == 7)
            {
                korTextQuiz.setText("ilgob");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.seven);
                btnChoice1.setText("one");
                btnChoice2.setText("nine");
                btnChoice3.setText("seven");
            }
            else if(secNumber == 8)
            {
                korTextQuiz.setText("sa");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.four);
                btnChoice1.setText("five");
                btnChoice2.setText("four");
                btnChoice3.setText("two");
            }
            else if(secNumber == 9)
            {
                korTextQuiz.setText("yeodeolb");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.eight);
                btnChoice1.setText("eight");
                btnChoice2.setText("three");
                btnChoice3.setText("six");
            }
            else if(secNumber == 10)
            {
                korTextQuiz.setText("sheeb-il-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.november);
                btnChoice1.setText("february");
                btnChoice2.setText("november");
                btnChoice3.setText("august");
            }
            else if(secNumber == 11)
            {
                korTextQuiz.setText("pal-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.august);
                btnChoice1.setText("august");
                btnChoice2.setText("january");
                btnChoice3.setText("may");
            }
            else if(secNumber == 12)
            {
                korTextQuiz.setText("il-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.january);
                btnChoice1.setText("march");
                btnChoice2.setText("january");
                btnChoice3.setText("september");
            }
            else if(secNumber == 13)
            {
                korTextQuiz.setText("oh-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.may);
                btnChoice1.setText("october");
                btnChoice2.setText("may");
                btnChoice3.setText("july");
            }
            else if(secNumber == 14)
            {
                korTextQuiz.setText("sheeb-ee-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.december);
                btnChoice1.setText("december");
                btnChoice2.setText("september");
                btnChoice3.setText("april");
            }
            else if(secNumber == 15)
            {
                korTextQuiz.setText("ee-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.febraury);
                btnChoice1.setText("june");
                btnChoice2.setText("february");
                btnChoice3.setText("november");
            }
            else if(secNumber == 16)
            {
                korTextQuiz.setText("yuk-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.june);
                btnChoice1.setText("october");
                btnChoice2.setText("june");
                btnChoice3.setText("march");
            }
            else if(secNumber == 17)
            {
                korTextQuiz.setText("sam-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.march);
                btnChoice1.setText("july");
                btnChoice2.setText("march");
                btnChoice3.setText("december");
            }
            else if(secNumber == 18)
            {
                korTextQuiz.setText("chil-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.july);
                btnChoice1.setText("august");
                btnChoice2.setText("january");
                btnChoice3.setText("july");
            }
            else if(secNumber == 19)
            {
                korTextQuiz.setText("saw-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.april);
                btnChoice1.setText("september");
                btnChoice2.setText("april");
                btnChoice3.setText("june");
            }
            else if(secNumber == 20)
            {
                korTextQuiz.setText("pal-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.august);
                btnChoice1.setText("august");
                btnChoice2.setText("march");
                btnChoice3.setText("december");
            }
            else if(secNumber == 21)
            {
                korTextQuiz.setText("sheeb-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.october);
                btnChoice1.setText("february");
                btnChoice2.setText("october");
                btnChoice3.setText("april");
            }
            else if(secNumber == 22)
            {
                korTextQuiz.setText("go-wol");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.september);
                btnChoice1.setText("january");
                btnChoice2.setText("june");
                btnChoice3.setText("september");
            }
            else if(secNumber == 23)
            {
                korTextQuiz.setText("apeulika");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.africa);
                btnChoice1.setText("eurasia");
                btnChoice2.setText("australia");
                btnChoice3.setText("africa");
            }
            else if(secNumber == 24)
            {
                korTextQuiz.setText("asia");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.asia);
                btnChoice1.setText("north america");
                btnChoice2.setText("asia");
                btnChoice3.setText("south america");
            }
            else if(secNumber == 25)
            {
                korTextQuiz.setText("yu-leob");
                engTextQuiz.setText("  ?  ");
                korImageQuiz.setImageResource(R.drawable.europe);
                btnChoice1.setText("antartica");
                btnChoice2.setText("eurasia");
                btnChoice3.setText("europe");
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