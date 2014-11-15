package qaziconsultancy.statusbarblocker;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.WindowManager;


public class DemoActivity extends Activity {

    WindowManager manager;
    StatusBarTouchInterceptor view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        manager = ((WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE));

        WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
        localLayoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        localLayoutParams.gravity = Gravity.TOP;

        localLayoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
        // this is to enable the notification to recieve touch events
        WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
        // Draws over status bar
        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        localLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        localLayoutParams.height = (int) (50 * getResources()
                .getDisplayMetrics().scaledDensity);
        localLayoutParams.format = PixelFormat.TRANSPARENT;

        view = new StatusBarTouchInterceptor(this);

        manager.addView(view, localLayoutParams);
    }

    @Override
    protected void onDestroy() {
        if(manager != null && view != null){
            try {
                manager.removeView(view);
            }
            catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if(manager != null && view != null){
            try {
                manager.removeView(view);
            }
            catch (IllegalArgumentException e){
                e.printStackTrace();
            }
        }
        super.onPause();
    }
}
