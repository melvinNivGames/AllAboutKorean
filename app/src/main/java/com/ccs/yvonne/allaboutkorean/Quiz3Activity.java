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

public class Quiz3Activity extends AppCompatActivity {
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
                startActivity(new Intent(Quiz3Activity.this, CategoriesQuizActivity.class));
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
                Toast.makeText(Quiz3Activity.this, "Score: " + score + " out of 25", Toast.LENGTH_SHORT).show();
                score = 0;
            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(Quiz3Activity.this,CategoriesQuizActivity.class));
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
            Toast.makeText(Quiz3Activity.this, "        Swipe left or right.\nClick save button to submit.",
                    Toast.LENGTH_SHORT).show();
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
            TextView engTextQuiz = (TextView) rootView.findViewById(R.id.engContentQuiz);

            GradientDrawable gd = new GradientDrawable();
            gd.setColor(0xFFFFFFFF); // Changes this drawbale to use a single color instead of a gradient
            gd.setCornerRadius(5);
            gd.setStroke(5, 0xFF000000);
            ImageView korImageQuiz = (ImageView) rootView.findViewById(R.id.koreaImageQuiz);
            korImageQuiz.setBackground(gd);

            final CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.checkBox);
            final Button btnChoice1 = (Button) rootView.findViewById(R.id.choice1);
            final Button btnChoice2 = (Button) rootView.findViewById(R.id.choice2);
            final Button btnChoice3 = (Button) rootView.findViewById(R.id.choice3);
            final int secNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            korImageQuiz.setImageResource(R.drawable.question);

            btnChoice1.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if(secNumber == 2 || secNumber == 3 || secNumber == 11 || secNumber == 12 || secNumber == 15 ||
                            secNumber == 18 || secNumber == 20 || secNumber == 21 || secNumber == 22)
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
                    if(secNumber == 1 || secNumber == 5 || secNumber == 8 || secNumber == 13 || secNumber == 23)
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
                    if(secNumber == 4 || secNumber == 6 || secNumber == 7 || secNumber == 9 || secNumber == 10 ||
                            secNumber == 14 || secNumber == 16 || secNumber == 17 || secNumber == 19 || secNumber == 24 ||
                            secNumber == 25)
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
                korTextQuiz.setText("pain-aepeul");
                engTextQuiz.setText("pineapple");
                btnChoice1.setText("아보카도");
                btnChoice2.setText("파인애플");//ETO
                btnChoice3.setText("레몬");
            }
            else if(secNumber == 2)
            {
                korTextQuiz.setText("mal");
                engTextQuiz.setText("horse");
                btnChoice1.setText("말");//ETO
                btnChoice2.setText("돼지");
                btnChoice3.setText("고양이");
            }
            else if(secNumber == 3)
            {
                korTextQuiz.setText("mog-yoil");
                engTextQuiz.setText("thursday");
                btnChoice1.setText("목요일");//ETO
                btnChoice2.setText("월요일");
                btnChoice3.setText("토요일");
            }
            else if(secNumber == 4)
            {
                korTextQuiz.setText("subag");
                engTextQuiz.setText("watermelon");
                btnChoice1.setText("파인애플");
                btnChoice2.setText("딸기");
                btnChoice3.setText("수박");//ETO
            }
            else if(secNumber == 5)
            {
                korTextQuiz.setText("paendeo");
                engTextQuiz.setText("panda");
                btnChoice1.setText("고양이");
                btnChoice2.setText("팬더");//ETO
                btnChoice3.setText("쥐");
            }
            else if(secNumber == 6)
            {
                korTextQuiz.setText("wol-yoil");
                engTextQuiz.setText("monday");
                btnChoice1.setText("목요일");
                btnChoice2.setText("일요일");
                btnChoice3.setText("월요일");//ETO
            }
            else if(secNumber == 7)
            {
                korTextQuiz.setText("yang");
                engTextQuiz.setText("sheep");
                btnChoice1.setText("말");
                btnChoice2.setText("개");
                btnChoice3.setText("양");//ETO
            }
            else if(secNumber == 8)
            {
                korTextQuiz.setText("toyoil");
                engTextQuiz.setText("saturday");
                btnChoice1.setText("수요일");
                btnChoice2.setText("토요일");//ETO
                btnChoice3.setText("금요일");
            }
            else if(secNumber == 9)
            {
                korTextQuiz.setText("mellon");
                engTextQuiz.setText("melon");
                btnChoice1.setText("딸기");
                btnChoice2.setText("파인애플");
                btnChoice3.setText("멜론");//ETO
            }
            else if(secNumber == 10)
            {
                korTextQuiz.setText("gom");
                engTextQuiz.setText("bear");
                btnChoice1.setText("사자");
                btnChoice2.setText("호랑이");
                btnChoice3.setText("곰");//ETO
            }
            else if(secNumber == 11)
            {
                korTextQuiz.setText("juhwangsaeg");
                engTextQuiz.setText("orange");
                btnChoice1.setText("주황색");//ETO
                btnChoice2.setText("버찌");
                btnChoice3.setText("무화과");
            }
            else if(secNumber == 12)
            {
                korTextQuiz.setText("holang-i");
                engTextQuiz.setText("tiger");
                btnChoice1.setText("호랑이");//ETO
                btnChoice2.setText("개");
                btnChoice3.setText("돼지");
            }
            else if(secNumber == 13)
            {
                korTextQuiz.setText("suyoil");
                engTextQuiz.setText("wednesday");
                btnChoice1.setText("토요일");
                btnChoice2.setText("수요일");//ETO
                btnChoice3.setText("목요일");
            }
            else if(secNumber == 14)
            {
                korTextQuiz.setText("kokoneos");
                engTextQuiz.setText("coconut");
                btnChoice1.setText("바나나");
                btnChoice2.setText("사과");
                btnChoice3.setText("코코넛");//ETO
            }
            else if(secNumber == 15)
            {
                korTextQuiz.setText("goyang-i");
                engTextQuiz.setText("cat");
                btnChoice1.setText("고양이");//ETO
                btnChoice2.setText("개");
                btnChoice3.setText("돼지");
            }
            else if(secNumber == 16)
            {
                korTextQuiz.setText("geum-yoil");
                engTextQuiz.setText("friday");
                btnChoice1.setText("목요일");
                btnChoice2.setText("일요일");
                btnChoice3.setText("금요일");//ETO
            }
            else if(secNumber == 17)
            {
                korTextQuiz.setText("peng-gwin");
                engTextQuiz.setText("penguin");
                btnChoice1.setText("양");
                btnChoice2.setText("말");
                btnChoice3.setText("펭귄");//ETO
            }
            else if(secNumber == 18)
            {
                korTextQuiz.setText("hwayoil");
                engTextQuiz.setText("tuesday");
                btnChoice1.setText("화요일");//ETO
                btnChoice2.setText("토요일");
                btnChoice3.setText("금요일");
            }
            else if(secNumber == 19)
            {
                korTextQuiz.setText("banana");
                engTextQuiz.setText("banana");
                btnChoice1.setText("파인애플");
                btnChoice2.setText("딸기");
                btnChoice3.setText("바나나");//ETO
            }
            else if(secNumber == 20)
            {
                korTextQuiz.setText("dwaeji");
                engTextQuiz.setText("pig");
                btnChoice1.setText("돼지");//ETO
                btnChoice2.setText("곰");
                btnChoice3.setText("호랑이");
            }
            else if(secNumber == 21)
            {
                korTextQuiz.setText("gabs");
                engTextQuiz.setText("values");
                btnChoice1.setText("값");//ETO
                btnChoice2.setText("수학");
                btnChoice3.setText("영어");
            }
            else if(secNumber == 22)
            {
                korTextQuiz.setText("gwahag gisul");
                engTextQuiz.setText("technology");
                btnChoice1.setText("공학");//ETO
                btnChoice2.setText("역사");
                btnChoice3.setText("값");
            }
            else if(secNumber == 23)
            {
                korTextQuiz.setText("yeogsa");
                engTextQuiz.setText("history");
                btnChoice1.setText("공학");
                btnChoice2.setText("역사");//ETO
                btnChoice3.setText("값");
            }
            else if(secNumber == 24)
            {
                korTextQuiz.setText("jilihag");
                engTextQuiz.setText("geography");
                btnChoice1.setText("공학");
                btnChoice2.setText("역사");
                btnChoice3.setText("지리학");//ETO
            }
            else if(secNumber == 25)
            {
                korTextQuiz.setText("gwahag");
                engTextQuiz.setText("science");
                btnChoice1.setText("지리학");
                btnChoice2.setText("공학");
                btnChoice3.setText("과학");//ETO
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