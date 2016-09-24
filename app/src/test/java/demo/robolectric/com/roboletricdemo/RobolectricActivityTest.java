package demo.robolectric.com.roboletricdemo;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static demo.robolectric.com.roboletricdemo.support.Assert.assertViewIsVisible;
import static demo.robolectric.com.roboletricdemo.support.ResourceLocator.getString;
import static demo.robolectric.com.roboletricdemo.support.ViewLocator.getButton;
import static demo.robolectric.com.roboletricdemo.support.ViewLocator.getEditText;
import static demo.robolectric.com.roboletricdemo.support.ViewLocator.getTextView;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadows.ShadowToast.getTextOfLatestToast;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RobolectricActivityTest {

    private RobolectricActivity activity;
    private Button hintButton;
    private Button enterButton;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(RobolectricActivity.class);
        hintButton = getButton(activity, R.id.button_show_hint);
        enterButton = getButton(activity, R.id.button_enter);
    }

    @Test
    public void testShouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void testShouldHaveTitle() throws Exception {
        assertThat(activity.getTitle().toString(), equalTo(getString(R.string.app_name)));

    }

    /**
     * Test for textView visibility
     * Test to verify that text being shown in Textview is accurate
     */
    @Test
    public void testTextView() throws Exception {
        TextView textView = getTextView(activity, R.id.text_view_welcome);
        assertViewIsVisible(textView);
        assertThat(textView.getText().toString(),
                equalTo(getString(R.string.welcome_text)));
    }

    @Test
    public void testEditTextView() throws Exception {
        EditText editText = getEditText(activity, R.id.edit_text_message);
        assertViewIsVisible(editText);
        assertThat(editText.getHint().toString(),
                equalTo(getString(R.string.edit_text_hint)));
    }

    @Test
    public void testEnterButton() throws Exception {
        assertViewIsVisible(enterButton);
        assertThat(enterButton.getText().toString(), equalTo(getString(R.string.Enter)));
    }

    @Test
    public void testHintButtonIsVisible() throws Exception {
        assertViewIsVisible(hintButton);
        assertThat(hintButton.getText().toString(), equalTo(getString(R.string.hint)));
    }

    @Test
    public void testShouldShowHintWhenClicked() throws Exception {
        hintButton.performClick();
        assertThat(getTextOfLatestToast(), equalTo(getString(R.string.hint_text)) );
    }

    @Test
    public void shouldLoginWhenLoginButtonClicked() throws Exception
    {
        enterButton.performClick();

        ShadowActivity shadowActivity = shadowOf( activity );
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        ShadowIntent shadowIntent = shadowOf( startedIntent );
        assertEquals( shadowIntent.getComponent().getClassName(),
                SecondActivity.class.getName() );
    }

}