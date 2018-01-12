package kelvin.tablayout;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a888888888.sport.R;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link kelvin_walking_invitation.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link kelvin_walking_invitation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class kelvin_walking_invitation extends Fragment implements View.OnTouchListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final int start_time_data_of_walking_invitation=1;
    public static final int start_date_data_of_walking_invitation=2;
    public static final int end_time_data_of_walking_invitation=3;
    public static final int end_date_data_of_walking_invitation=4;
    public String start_hour_of_kelvin_walking_invitation;
    public int start_hour_int_of_kelvin_walking_invitation;
    public String start_minute_of_kelvin_walking_invitation;
    public int start_minute_int_of_kelvin_walking_invitation;
    public String start_day_of_kelvin_walking_invitation;
    public String start_month_of_kelvin_walking_invitation;
    public String start_year_of_kelvin_walking_invitation;
    public int start_year_int_of_kelvin_walking_invitation;
    public int start_month_int_of_kelvin_walking_invitation;
    public int start_day_int_of_kelvin_walking_invitation;
    public TextView show_start_time_of_walking_invitation;
    public TextView show_start_date_of_walking_invitation;

    public String end_hour_of_kelvin_walking_invitation;
    public int end_hour_int_of_kelvin_walking_invitation;
    public String end_minute_of_kelvin_walking_invitation;
    public int end_minute_int_of_kelvin_walking_invitation;
    public String end_day_of_kelvin_walking_invitation;
    public String end_month_of_kelvin_walking_invitation;
    public String end_year_of_kelvin_walking_invitation;
    public int end_year_int_of_kelvin_walking_invitation;
    public int end_month_int_of_kelvin_walking_invitation;
    public int end_day_int_of_kelvin_walking_invitation;
    public TextView show_end_time_of_walking_invitation;
    public TextView show_end_date_of_walking_invitation;
    DecimalFormat mDecimalFormat = new DecimalFormat("##00");
    public EditText edit_text_of_walking_set_count;

    public Toast toast;
    public Button button_of_walking_invitation_confirm;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public int walking_set_count;
    public InputMethodManager imm_of_walking_invitation;

    private OnFragmentInteractionListener mListener;


    public kelvin_walking_invitation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment kelvin_walking_invitation.
     */
    // TODO: Rename and change types and number of parameters
    public static kelvin_walking_invitation newInstance(String param1, String param2) {
        kelvin_walking_invitation fragment = new kelvin_walking_invitation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        imm_of_walking_invitation = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this
        final View view = inflater.inflate(R.layout.fragment_kelvin_walking_invitation, null);
        view.setOnTouchListener(this);

        edit_text_of_walking_set_count=(EditText)view.findViewById(R.id.editText_of_walking_count);
        edit_text_of_walking_set_count.requestFocus();

        Date mDate = new Date();
        start_hour_int_of_kelvin_walking_invitation= mDate.getHours();
        start_minute_int_of_kelvin_walking_invitation=mDate.getMinutes();
        start_year_int_of_kelvin_walking_invitation=mDate.getYear()+1900;
        start_month_int_of_kelvin_walking_invitation=mDate.getMonth()+1;
        start_day_int_of_kelvin_walking_invitation=mDate.getDate();
        end_hour_int_of_kelvin_walking_invitation= mDate.getHours();
        end_minute_int_of_kelvin_walking_invitation=mDate.getMinutes();
        end_year_int_of_kelvin_walking_invitation=mDate.getYear()+1900;
        end_month_int_of_kelvin_walking_invitation=mDate.getMonth()+1;
        end_day_int_of_kelvin_walking_invitation=mDate.getDate();

        show_start_time_of_walking_invitation=(TextView)view.findViewById(R.id.show_start_time_of_walking_invitation);
        show_start_time_of_walking_invitation.setText(mDecimalFormat.format(start_hour_int_of_kelvin_walking_invitation) +":"+mDecimalFormat.format(start_minute_int_of_kelvin_walking_invitation) );
        show_start_time_of_walking_invitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new StartTimeFragment();

                newFragment.setTargetFragment(kelvin_walking_invitation.this,start_time_data_of_walking_invitation);
                newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
            }
        });

        show_start_date_of_walking_invitation=(TextView)view.findViewById(R.id.show_start_date_of_walking_invitation);
        show_start_date_of_walking_invitation.setText(start_year_int_of_kelvin_walking_invitation+"年"+start_month_int_of_kelvin_walking_invitation+"月"+start_day_int_of_kelvin_walking_invitation);
        show_start_date_of_walking_invitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new StartDateFragment();
                newFragment.setTargetFragment(kelvin_walking_invitation.this,start_date_data_of_walking_invitation);
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });
        show_end_time_of_walking_invitation=(TextView)view.findViewById(R.id.show_end_time_of_walking_invitation);
        show_end_time_of_walking_invitation.setText(mDecimalFormat.format(end_hour_int_of_kelvin_walking_invitation) +":"+mDecimalFormat.format(end_minute_int_of_kelvin_walking_invitation) );
        show_end_time_of_walking_invitation.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new EndTimeFragment();

                newFragment.setTargetFragment(kelvin_walking_invitation.this,end_time_data_of_walking_invitation);
                newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
            }
        });
        show_end_date_of_walking_invitation=(TextView)view.findViewById(R.id.show_end_date_of_walking_invitation);
        show_end_date_of_walking_invitation.setText(end_year_int_of_kelvin_walking_invitation+"年"+end_month_int_of_kelvin_walking_invitation+"月"+end_day_int_of_kelvin_walking_invitation);
        show_end_date_of_walking_invitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new EndDateFragment();
                newFragment.setTargetFragment(kelvin_walking_invitation.this,end_date_data_of_walking_invitation);
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });
        button_of_walking_invitation_confirm=(Button)view.findViewById(R.id.button_of_walking_invitation_confirm);
        button_of_walking_invitation_confirm.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if("".equals( edit_text_of_walking_set_count.getText().toString().trim())){
                    toast.makeText(getActivity(), getResources().getString(R.string.empty_of_edit_text), Toast.LENGTH_SHORT).show();
                    edit_text_of_walking_set_count.requestFocus();
                    //imm2 = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm_of_walking_invitation.showSoftInput(edit_text_of_walking_set_count, 0);

                }else{
                    walking_set_count=Integer.parseInt( edit_text_of_walking_set_count.getText().toString());
                    if(walking_set_count<1000||walking_set_count>50000){
                        toast.makeText(getActivity(), "步數不能小於1000或大於50000", Toast.LENGTH_SHORT).show();
                        edit_text_of_walking_set_count.setText(" ");
                        imm_of_walking_invitation.showSoftInput(edit_text_of_walking_set_count, 0);
                    }else{
                        if(start_hour_of_kelvin_walking_invitation==null||start_minute_of_kelvin_walking_invitation==null){
                            toast.makeText(getActivity(), "請選擇時間", Toast.LENGTH_SHORT).show();
                            DialogFragment newFragment = new StartTimeFragment();
                            newFragment.setTargetFragment(kelvin_walking_invitation.this,start_time_data_of_walking_invitation);
                            newFragment.show(getActivity().getSupportFragmentManager(), "timePicker");
                        }else{
                            toast=Toast.makeText(getActivity(), "步數:"+walking_set_count+"時間是:"+start_hour_of_kelvin_walking_invitation+":"+start_minute_of_kelvin_walking_invitation, Toast.LENGTH_SHORT);
                            toast.show();

                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment_kelvin_running_invitation,new kelvin_running_tag_friend(),null)
                                    .addToBackStack(null)
                                    .commit();
                        }



                    }
                }

            }


        });

        return view;

    }







    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String Tag, String number) {//要從kelvin_tab_layout.java拿onFragmentInteraction的(String Tag, String number) 貼到這裡來
        if (mListener != null) {
            mListener.onFragmentInteraction(Tag,number);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String Tag, String number);//要從kelvin_tab_layout.java拿onFragmentInteraction的(String Tag, String number) 貼到這裡來
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == start_time_data_of_walking_invitation){
            start_minute_of_kelvin_walking_invitation= mDecimalFormat.format(Double.parseDouble(data.getStringExtra(StartTimeFragment.MINUTE_OF_START_TIME_PICKER_FRAGMENT)));
            start_hour_of_kelvin_walking_invitation = mDecimalFormat.format(Double.parseDouble(data.getStringExtra(StartTimeFragment.HOUR_OF_START_TIME_PICKER_FRAGMENT)));
            show_start_time_of_walking_invitation.setText(start_hour_of_kelvin_walking_invitation+":"+start_minute_of_kelvin_walking_invitation);
        }

        if(requestCode == start_date_data_of_walking_invitation){
            start_day_of_kelvin_walking_invitation=data.getStringExtra(StartDateFragment.DAY_OF_START_Date_PICKER_FRAGMENT);
            start_month_of_kelvin_walking_invitation=data.getStringExtra(StartDateFragment.MONTH_OF_START_Date_PICKER_FRAGMENT);
            start_year_of_kelvin_walking_invitation=data.getStringExtra(StartDateFragment.YEAR_OF_START_Date_PICKER_FRAGMENT);
            show_start_date_of_walking_invitation.setText(start_year_of_kelvin_walking_invitation+"年"+start_month_of_kelvin_walking_invitation+"月"+start_day_of_kelvin_walking_invitation);
        }

        if(requestCode == end_time_data_of_walking_invitation){
            end_minute_of_kelvin_walking_invitation= mDecimalFormat.format(Double.parseDouble(data.getStringExtra(EndTimeFragment.MINUTE_OF_END_TIME_PICKER_FRAGMENT)));
            end_hour_of_kelvin_walking_invitation = mDecimalFormat.format(Double.parseDouble(data.getStringExtra(EndTimeFragment.HOUR_OF_END_TIME_PICKER_FRAGMENT)));
            show_end_time_of_walking_invitation.setText(end_hour_of_kelvin_walking_invitation+":"+end_minute_of_kelvin_walking_invitation);
        }

        if(requestCode == end_date_data_of_walking_invitation){
            end_day_of_kelvin_walking_invitation=data.getStringExtra(EndDateFragment.DAY_OF_END_Date_PICKER_FRAGMENT);
            end_month_of_kelvin_walking_invitation=data.getStringExtra(EndDateFragment.MONTH_OF_END_Date_PICKER_FRAGMENT);
            end_year_of_kelvin_walking_invitation=data.getStringExtra(EndDateFragment.YEAR_OF_END_Date_PICKER_FRAGMENT);
            show_end_date_of_walking_invitation.setText(end_year_of_kelvin_walking_invitation+"年"+end_month_of_kelvin_walking_invitation+"月"+end_day_of_kelvin_walking_invitation);
        }




}
}
