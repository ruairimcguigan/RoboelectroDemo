package demo.robolectric.com.roboletricdemo.support;

import android.view.View;

import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by rmcg2 on 24/09/2016.
 */
public class Assert {

    public static void assertViewIsVisible(View view){
        assertNotNull(view);
        assertThat(view.getVisibility(), equalTo(View.VISIBLE));
    }
}
