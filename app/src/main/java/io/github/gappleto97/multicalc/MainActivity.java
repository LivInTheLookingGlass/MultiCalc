package io.github.gappleto97.multicalc;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private LinearLayout mBasic, mScientific, mProgrammatic;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    public String str =" ";
    Character op = 'q';
    double num,numtemp;
    EditText showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        showResult = (EditText)findViewById(R.id.result_id);

        mBasic = (LinearLayout)findViewById(R.id.background_basic);
        //mScientific.setVisibility(View.GONE);
        //mProgrammatic.setVisibility(View.GONE);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                mBasic.setVisibility(View.VISIBLE);
                //mScientific.setVisibility(View.GONE);
                //mProgrammatic.setVisibility(View.GONE);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                mBasic.setVisibility(View.GONE);
                //mScientific.setVisibility(View.VISIBLE);
                //mProgrammatic.setVisibility(View.GONE);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                mBasic.setVisibility(View.GONE);
                //mScientific.setVisibility(View.GONE);
                //mProgrammatic.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
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

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public void btn1Clicked(View v){
        insert(1);
    }

    public void btn2Clicked(View v){
        insert(2);
    }

    public void btn3Clicked(View v){
        insert(3);
    }

    public void btn4Clicked(View v){
        insert(4);
    }

    public void btn5Clicked(View v){
        insert(5);
    }

    public void btn6Clicked(View v){
        insert(6);
    }

    public void btn7Clicked(View v){
        insert(7);
    }

    public void btn8Clicked(View v){
        insert(8);
    }

    public void btn9Clicked(View v){
        insert(9);
    }

    public void btnplusClicked(View v){
        insert('+');
        //perform();
        //op = '+';
    }

    public void btnminusClicked(View v){
        insert('-');
        //perform();
        //op = '-';
    }

    public void btndivideClicked(View v){
        insert('/');
        //perform();
        //op = '/';
    }

    public void btnmultiClicked(View v){
        insert('x');
        //perform();
        //op = '*';
    }

    public void btndotClicked(View v){
        insert('.');
        //perform();
        //op = '/';
    }

    public void btnequalClicked(View v){
        calculate();
    }

    public void btnclearClicked(View v){
        reset();
    }

    private void reset() {
        // TODO Auto-generated method stub
        str =" ";
        op ='q';
        num = 0;
        numtemp = 0;
        showResult.setText("");
    }

    private void insert(int j) {
        // TODO Auto-generated method stub
        if (str == " ")
            str = "";
        str = str+Integer.toString(j);
        //num = Integer.valueOf(str).intValue();
        showResult.setText(str);
    }

    private void insert(char j) {
        String a = str.substring(str.length() - 1);
        Log.v("debug", a);
        if (str.endsWith("x") || str.endsWith("/") || str.endsWith("+") || str.endsWith("-") || str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
            Log.v("debug","true");
        }
        else
            Log.v("debug","false");
        if (str != " ")
            str = str+j;
        op = j;
        showResult.setText(str);
    }

    private void perform() {
        // TODO Auto-generated method stub
        str = "";
        numtemp = num;
    }

    private void calculate() {
        class Parser {
            int pos = -1, c;

            void eatChar() {
                c = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            void eatSpace() {
                while (Character.isWhitespace(c))
                    eatChar();
            }

            double parse() {
                eatChar();
                double v = parseExpression();
                if (c != -1)
                    throw new RuntimeException("Unexpected: " + (char)c);
                return v;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor | term brackets
            // factor = brackets | number | factor `^` factor
            // brackets = `(` expression `)`

            double parseExpression() {
                double v = parseTerm();
                for (;;) {
                    eatSpace();
                    if (c == '+') { // addition
                        eatChar();
                        v += parseTerm();
                    } else if (c == '-') { // subtraction
                        eatChar();
                        v -= parseTerm();
                    } else {
                        return v;
                    }
                }
            }

            double parseTerm() {
                double v = parseFactor();
                for (;;) {
                    eatSpace();
                    if (c == '/') { // division
                        eatChar();
                        v /= parseFactor();
                    } else if (c == 'x' || c == '(') { // multiplication
                        if (c == 'x') eatChar();
                        v *= parseFactor();
                    } else {
                        return v;
                    }
                }
            }

            double parseFactor() {
                double v;
                boolean negate = false;
                eatSpace();
                if (c == '+' || c == '-') { // unary plus & minus
                    negate = c == '-';
                    eatChar();
                    eatSpace();
                }
                if (c == '(') { // brackets
                    eatChar();
                    v = parseExpression();
                    if (c == ')') eatChar();
                } else { // numbers
                    StringBuilder sb = new StringBuilder();
                    while ((c >= '0' && c <= '9') || c == '.') {
                        sb.append((char)c);
                        eatChar();
                    }
                    if (sb.length() == 0)
                        throw new RuntimeException("Unexpected: " + (char)c);
                    v = Double.parseDouble(sb.toString());
                }
                eatSpace();
                if (c == '^') { // exponentiation
                    eatChar();
                    v = Math.pow(v, parseFactor());
                }
                if (negate)
                    v = -v; // unary minus is applied after exponentiation; e.g. -3^2=-9
                return v;
            }
        }
        double result = new Parser().parse();
        String print = "";
        if (result == (int)result)
            print = Integer.toString((int) result);
        else
            print = Double.toString(result);
        showResult.setText(""+print);
        str = print;
        num = result;
    }
}
