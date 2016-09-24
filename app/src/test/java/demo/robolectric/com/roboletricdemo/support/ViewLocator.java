package demo.robolectric.com.roboletricdemo.support;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by rmcg2 on 24/09/2016.
 */
public class ViewLocator {

    public static TextView getTextView(Activity activity, int viewId){
        return (TextView) activity.findViewById(viewId);
    }

    public static EditText getEditText(Activity activity, int viewId){
        return (EditText) activity.findViewById(viewId);
    }

    public static Button getButton(Activity activity, int viewId){
        return (Button) activity.findViewById(viewId);
    }
}
