package demo.robolectric.com.roboletricdemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.*;

public class RobolectricActivity extends AppCompatActivity implements OnClickListener {

    private EditText mEnterMessage;
    private Button mEnterButton;
    private TextView mWelcomeTextView;
    private Button mHintButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robolectric);
        initViews();
        setClickListener();

    }


    private void initViews() {
        mEnterMessage = (EditText)findViewById(R.id.edit_text_message);
        mEnterButton = (Button)findViewById(R.id.button_enter);
        mWelcomeTextView = (TextView)findViewById(R.id.text_view_welcome);
        mHintButton = (Button)findViewById(R.id.button_show_hint);
    }

    private void setClickListener() {
        mHintButton.setOnClickListener(this);
        mEnterButton.setOnClickListener(this);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SecondActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_enter:
                start(this);
                break;
            case R.id.button_show_hint:
                Toast.makeText(RobolectricActivity.this, getApplicationContext()
                        .getString(R.string.hint_text), Toast.LENGTH_SHORT).show();
        }
    }
}
