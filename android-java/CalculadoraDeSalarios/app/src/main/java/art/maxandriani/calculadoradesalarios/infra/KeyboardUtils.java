package art.maxandriani.calculadoradesalarios.infra;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import art.maxandriani.calculadoradesalarios.MainActivity;

public class KeyboardUtils {

  public static void hideSoftKeyboard(final Activity activity) {
    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
    inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
  }

  public static void attachHideSoftKeyboardListener(final View parent, final Activity activity) {
    // Set up touch listener for non-text box views to hide keyboard.
    if (!(parent instanceof EditText)) {
      parent.setOnTouchListener(new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
          hideSoftKeyboard(activity);
          return false;
        }
      });
    }

    //If a layout container, iterate over children and seed recursion.
    if (parent instanceof ViewGroup) {
      for (int i = 0; i < ((ViewGroup) parent).getChildCount(); i++) {
        View innerView = ((ViewGroup) parent).getChildAt(i);
        attachHideSoftKeyboardListener(innerView, activity);
      }
    }
  }

}
