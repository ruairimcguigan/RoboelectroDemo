package demo.robolectric.com.roboletricdemo.support;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by rmcg2 on 24/09/2016.
 */
public class ResourceLocator {

    public static final String getString(int stringId){

        return RuntimeEnvironment.application.getString(stringId);
    }
}
