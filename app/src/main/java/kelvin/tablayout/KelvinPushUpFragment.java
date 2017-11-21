package kelvin.tablayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a888888888.sport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class KelvinPushUpFragment extends Fragment {


    public KelvinPushUpFragment() {
        // Required empty public constructor////
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment kkkkkkkkkkkkkkkkkkk
        View rootView= inflater.inflate(R.layout.fragment_kelvin_exercise, container, false);
        TextView text_View_of_exercise_title=(TextView)rootView.findViewById(R.id.exercise_title);
        TextView text_view_of_today_record_data=(TextView)rootView.findViewById(R.id.text_view_of_today_record_data);
        TextView text_view_of_lowest_record_data=(TextView)rootView.findViewById(R.id.text_view_of_lowest_record_data) ;
        TextView text_view_of_highest_record_data=(TextView)rootView.findViewById(R.id.text_view_of_highest_record_data);
        text_View_of_exercise_title.setText("伏地挺身個人記錄");
        text_view_of_today_record_data.setText("10次");
        text_view_of_highest_record_data.setText("15次");
        text_view_of_lowest_record_data.setText("5次");
        final Button button_of_invitation=(Button)rootView.findViewById(R.id.button_of_invitation);
        button_of_invitation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_kelvin_running_invitation,new kelvin_push_up_invitation(),null)
                        .addToBackStack(null)
                        .commit();
            }

        });
        return rootView;
    }

}
