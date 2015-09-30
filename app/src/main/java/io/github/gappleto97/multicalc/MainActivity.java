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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;

    public String str =" ";
    EditText showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        showResult = (EditText)findViewById(R.id.result_id);

        showBasic();
        setTitle(mTitle);
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
        try {
            switch (number) {
                case 1:
                    mTitle = getString(R.string.title_section1);
                    showBasic();
                    break;
                case 2:
                    mTitle = getString(R.string.title_section2);
                    showScientific();
                    break;
                case 3:
                    mTitle = getString(R.string.title_section3);
                    showProgrammatic();
                    break;
            }
            setTitle(mTitle);
        }
        catch (Exception e) {
            Log.d("Debug","Catch block triggered");
        }
    }
    /*
    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
    } */

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
            return inflater.inflate(R.layout.fragment_main, container, false);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public void btn0Clicked(View v){
        insert(0);
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
    }

    public void btnminusClicked(View v){
        insert('-');
    }

    public void btndivideClicked(View v){
        insert('÷');
    }

    public void btnmultiClicked(View v){
        insert('×');
    }

    public void btndotClicked(View v){
        insert('.');
    }

    public void btnequalClicked(View v){
        calculate();
    }

    public void btnclearClicked(View v){
        reset();
    }

    public void btnOpParClicked(View v)   {
        insert('(');
    }

    public void btnClParClicked(View v)   {
        insert(')');
    }

    public void btnCrtClicked(View v){
        insert('^');
    }

    public void btnRootClicked(View v){
        insert('√');
    }

    public void btnFactClicked(View v)  {
        insert('!');
    }

    public void btnlnClicked(View v)  {
        insert(' ');
    }

    public void btnSignClicked(View v)  {
    }

    public void btnsinClicked(View v)  {
        insert("sin");
    }

    public void btnsinhClicked(View v)  {
        insert("sinh");
    }

    public void btncosClicked(View v)  {
        insert("cos");
    }

    public void btncoshClicked(View v)  {
        insert("cosh");
    }

    public void btntanClicked(View v)  {
        insert("tan");
    }

    public void btntanhClicked(View v)  {
        insert("tanh");
    }

    public void btnbackClicked(View v)  {
        remove();
    }

    private void hideBasic()    {

    }

    private void hideScientific()   {
        findViewById(R.id.Btnsin_id).setVisibility(View.GONE);
        findViewById(R.id.Btnsinh_id).setVisibility(View.GONE);
        findViewById(R.id.Btncos_id).setVisibility(View.GONE);
        findViewById(R.id.Btncosh_id).setVisibility(View.GONE);
        findViewById(R.id.Btntan_id).setVisibility(View.GONE);
        findViewById(R.id.Btntanh_id).setVisibility(View.GONE);
        findViewById(R.id.Btnfact_id).setVisibility(View.GONE);
        findViewById(R.id.Btnln_id).setVisibility(View.GONE);
        findViewById(R.id.Btnroot_id).setVisibility(View.GONE);
        findViewById(R.id.Btncrt_id).setVisibility(View.GONE);
    }

    private void hideProgrammatic() {

    }

    private void showBasic()    {
        hideScientific();
        hideProgrammatic();
        ((Button)findViewById(R.id.Btnclear_id)).setText("CLEAR");
    }

    private void showScientific()   {
        hideBasic();
        hideProgrammatic();
        findViewById(R.id.Btnsin_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btnsinh_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btncos_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btncosh_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btntan_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btntanh_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btnfact_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btnln_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btnroot_id).setVisibility(View.VISIBLE);
        findViewById(R.id.Btncrt_id).setVisibility(View.VISIBLE);
        ((Button)findViewById(R.id.Btnclear_id)).setText("CLR");
    }

    private void showProgrammatic() {
        hideBasic();
        hideScientific();
    }

    private void reset() {
        // TODO Auto-generated method stub
        //str =" ";
        showResult.setText(str = " ");
    }

    private void insert(int j) {
        // TODO Auto-generated method stub
        if (str.equals(" "))
            str = "";
        str = str+Integer.toString(j);
        //num = Integer.valueOf(str).intValue();
        showResult.setText(str);
    }

    private void insert(String j)   {
        String a = str.substring(str.length() - 1);
        Log.v("debug", a);
        if (str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
            Log.v("debug","true");
        }
        else
            Log.v("debug","false");
        str = str+j;
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
        if (!str.equals(" ") || j == '(' || j == '√')
            str = str+j;
        showResult.setText(str);
    }

    private void remove()   {
        Log.d("debug","remove called");
        str = str.substring(0,Math.max(str.length() - 1, 0));
        showResult.setText(str);
        if (str.equals(""))
            str = " ";
    }

    private void perform() {
        // TODO Auto-generated method stub
        str = "";
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
            // term = factor | term `*` factor | term `/` factor | term brackets | term root
            // factor = brackets | number | factor `^` factor | trig
            // brackets = `(` expression `)`
            // trig = sin factor | sinh factor | cos factor | cosh factor | tan factor | tanh factor

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
                    if (c == '÷') { // division
                        eatChar();
                        v /= parseFactor();
                    } else if (c == '×' || c == '(' || c == '√' || c == 's' || c == 'c' || c == 't') { // multiplication
                        if (c == '×') eatChar();
                        v *= parseFactor();
                    } else {
                        return v;
                    }
                }
            }

            double parseFactor() {
                double v = 0;
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
                } else if (c == '√') {    //root
                    eatChar();
                    v = Math.sqrt(parseExpression());
                } else if (c == 's' || c == 'c' || c == 't') {
                    int o = c;
                    eatChar();
                    eatChar();
                    eatChar();
                    if (c == 'h')   {
                        eatChar();
                        if (o == 's')
                            v = Math.sinh(parseExpression());
                        else if (o == 'c')
                            v = Math.cosh(parseExpression());
                        else if (o == 't')
                            v = Math.tanh(parseExpression());
                    }
                    else    {
                        if (o == 's')
                            v = Math.sin(parseExpression());
                        else if (o == 'c')
                            v = Math.cos(parseExpression());
                        else if (o == 't')
                            v = Math.tan(parseExpression());
                    }
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
        double result = 0;
        try {
            result = new Parser().parse();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        String print;
        if (result == (int)result)
            print = Integer.toString((int) result);
        else
            print = Double.toString(result);
        showResult.setText(print);
        if (!print.equals("NaN"))
            str = print;
        else
            str = " ";
    }
}
