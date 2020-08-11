package art.maxandriani.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class HelloService extends Service {
  public HelloService() {
  }

  @Override
  public IBinder onBind(Intent intent) {
    // TODO: Return the communication channel to the service.
    Toast
      .makeText(this, R.string.hello_service_on_bind, Toast.LENGTH_SHORT)
      .show();
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Toast
      .makeText(this, R.string.hello_service_on_create, Toast.LENGTH_SHORT)
      .show();
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Toast
      .makeText(this, R.string.hello_service_on_start_command, Toast.LENGTH_SHORT)
      .show();
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Toast
      .makeText(this, R.string.hello_service_on_destroy, Toast.LENGTH_SHORT)
      .show();
  }
}
