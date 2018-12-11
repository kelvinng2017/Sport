package kelvin.tablayout;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a888888888.sport.MainActivity;
import com.example.a888888888.sport.R;
import com.onesignal.OneSignal;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import de.hdodenhof.circleimageview.CircleImageView;

public class ExerciseTeaching extends AppCompatActivity {

    FoodAdapter dataAdapter = null;
    private String url;
    private String exercise_name;
    private String from_page="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_teaching);
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .setNotificationOpenedHandler(new MainActivity.ExampleNotificationOpenedHandler())
                .init();
        Toolbar exercise_teaching_toolbar = findViewById(R.id.exercise_teaching_toolbar);
        requestQueue = Volley.newRequestQueue(ExerciseTeaching.this.getApplicationContext());
        setSupportActionBar(exercise_teaching_toolbar);
        ActionBar exercise_teaching_actionbar = getSupportActionBar();
        if (exercise_teaching_actionbar != null) {
            exercise_teaching_actionbar.setDisplayHomeAsUpEnabled(true);
            exercise_teaching_actionbar.setTitle("選擇運動教學影片");
        }
        Bundle bundle=getIntent().getExtras();
        from_page=bundle.getString("from_page");
        Log.i("OnCreate的From_page",from_page);
        displaylistView();

    }
    private String showUri = "http://192.168.0.4:1335/login.php";
    com.android.volley.RequestQueue requestQueue;
    private void getData() {
        StringRequest jsonObjectRequest = new StringRequest
                (Request.Method.POST,showUri, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject= new JSONObject(response.toString());
                            JSONArray data = jsonObject.getJSONArray("data");
                            JSONObject jasondata;

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ExerciseTeaching.this,"", Toast.LENGTH_SHORT).show();//?唾???靘?ㄐ
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.append(error.getMessage());
                    }
                }

                )
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("login", update);
                return params;
            }

        };
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (from_page.equals("MainActivity")){
                Intent intent = new Intent(ExerciseTeaching.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
            if (from_page.equals("SimpleActivity")){
                Intent intent = new Intent(ExerciseTeaching.this, SimpleMainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (from_page.equals("MainActivity")){
            Intent intent = new Intent(ExerciseTeaching.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }

        if (from_page.equals("SimpleActivity")){
            Intent intent = new Intent(ExerciseTeaching.this, SimpleMainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
        }
    }

    private String update;
    private void displaylistView() {
        ArrayList<ExerciseTitle> food_notes_list = new ArrayList<ExerciseTitle>();
        ExerciseTitle food_note = new ExerciseTitle(R.drawable.walk_image, "跑步教學影片","26秒");
        food_notes_list.add(food_note);
        //food_note = new ExerciseTitle(R.drawable.et1, "暖身操教學影片","3分鐘44秒");
        //food_notes_list.add(food_note);
        food_note = new ExerciseTitle(R.drawable.et2, "平板支撐教學影片","1分鐘45秒");
        food_notes_list.add(food_note);
        food_note = new ExerciseTitle(R.drawable.et3, "仰臥起坐教學影片","1分鐘16秒");
        food_notes_list.add(food_note);
        //food_note = new ExerciseTitle(R.drawable.et4, "俯臥撐1教學影片","1分鐘16秒");
        //food_notes_list.add(food_note);
        food_note = new ExerciseTitle(R.drawable.et5, "俯臥撐教學影片","1分鐘10秒");
        food_notes_list.add(food_note);
        food_note = new ExerciseTitle(R.drawable.et6, "舉腳教學影片","1分鐘09秒");
        food_notes_list.add(food_note);
        food_note = new ExerciseTitle(R.drawable.et7, "橋式教學影片","1分鐘09秒");
        food_notes_list.add(food_note);
        food_note = new ExerciseTitle(R.drawable.et8, "空氣椅教學影片","51秒");
        food_notes_list.add(food_note);


        dataAdapter = new FoodAdapter(this, R.layout.exercise_teaching_layout, food_notes_list);
        ListView listView = (ListView) findViewById(R.id.exercise_list);

        listView.setAdapter(dataAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ExerciseTitle food_note = (ExerciseTitle) parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(),"clicked on row:"+states.getName(),Toast.LENGTH_SHORT).show();
                Log.i("我點擊",""+position+""+food_note.getExercise_name());
                switch (position){
                    case 0:
                        update = "00";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport00";

                        break;
                    case 1:
                        update = "01";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport01";

                        break;
                    case 2:
                        update = "02";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport02";
                        break;
                    case 3:
                        update = "03";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport03";
                        break;
                    case 4:
                        update = "04";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport04";
                        break;
                    case 5:
                        update = "05";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport05";
                        break;
                    case 6:
                        update = "06";
                        getData();
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport06";
                        break;
                    /*case 7:
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport07";
                        break;
                    case 8:
                        url="http://192.168.0.4:5500/video_feed";
                        exercise_name="sport08";
                        break;*/////
                    default:
                        break;
                }
                Toast.makeText(ExerciseTeaching.this,exercise_name,Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setClass(ExerciseTeaching.this, WebView2.class);
                Bundle bundle =new Bundle();
                bundle.putString("URL",url);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


    }

    private class FoodAdapter extends ArrayAdapter<ExerciseTitle> {

        private ArrayList<ExerciseTitle> food_notes_list;

        public FoodAdapter(Context context, int textviewResoureid, ArrayList<ExerciseTitle> food_notes_list) {
            super(context, textviewResoureid, food_notes_list);
            this.food_notes_list = new ArrayList<ExerciseTitle>();
            this.food_notes_list.addAll(food_notes_list);
        }

        private class ViewHolder {
            ImageView exercise_image;
            TextView exercise_title;
            TextView exercise_video_lenght;


        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));
            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.exercise_teaching_layout, null);

                holder = new ViewHolder();
                holder.exercise_image = (ImageView) convertView.findViewById(R.id.exercise_name_icon);
                holder.exercise_title = (TextView) convertView.findViewById(R.id.exercise_name);
                holder.exercise_video_lenght=(TextView)convertView.findViewById(R.id.exercise_video_length);


                convertView.setTag(holder);


            }
            else {
                holder=(ViewHolder)convertView.getTag();
            }
            ExerciseTitle food_note=food_notes_list.get(position);
            //holder.exercise_image.setImageResource(food_note.getExercise_image());
            Picasso.get().load(food_note.getExercise_image()).memoryPolicy(MemoryPolicy.NO_CACHE,MemoryPolicy.NO_STORE).fit().centerCrop().into(holder.exercise_image);
            Picasso.get().setIndicatorsEnabled(true);
            holder.exercise_title.setText(food_note.getExercise_name());
            holder.exercise_video_lenght.setText(food_note.getExercise_video_length());
            return convertView;
        }
    }
}


