package qaziconsultancy.statusbarblocker;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Toast;

public class StatusBarTouchInterceptor extends ViewGroup {

    Context context;

    public StatusBarTouchInterceptor(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Toast.makeText(context, "Status bar blocked", Toast.LENGTH_LONG).show();
        return true;
    }
}