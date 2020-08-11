package art.maxandriani.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class HelloReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        int text;

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                text = R.string.hello_receiver_airplane_mode;
                break;
            case Intent.ACTION_BATTERY_LOW:
                text = R.string.hello_receiver_battery_low;
                break;
            default:
                text = R.string.hello_receiver_message_received;
        }
        Toast
          .makeText(context, text, Toast.LENGTH_SHORT)
          .show();
    }
}
