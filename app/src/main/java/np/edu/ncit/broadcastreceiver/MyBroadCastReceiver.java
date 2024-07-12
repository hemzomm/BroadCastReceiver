package np.edu.ncit.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;
import android.widget.Toast;

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            Log.d("Debug Log", "Airplane Mode Changed!");
            Toast.makeText(context.getApplicationContext(), "Airplane Mode Changed!", Toast.LENGTH_LONG).show();
        }
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(intent.getAction())) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);

            switch (wifiState) {
                case WifiManager.WIFI_STATE_DISABLED:
                    Log.d("Debug Log", "Wi-Fi is turned off");
                    Toast.makeText(context.getApplicationContext(), "Wi-Fi is turned off", Toast.LENGTH_LONG).show();
                    break;
                case WifiManager.WIFI_STATE_ENABLED:
                    Log.d("Debug Log", "Wi-Fi is turned on");
                    Toast.makeText(context.getApplicationContext(), "Wi-Fi is turned on", Toast.LENGTH_LONG).show();
                    break;
                case WifiManager.WIFI_STATE_UNKNOWN:
                default:
                    Log.d("Debug Log", "Wi-Fi state is unknown");
                    Toast.makeText(context.getApplicationContext(), "Wi-Fi state is unknown", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    }
}
