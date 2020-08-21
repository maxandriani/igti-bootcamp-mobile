package art.maxandriani.calculadoradesalarios.infra;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class KeyboardUtils {

  public static final void hideSoftKeyboard(AppCompatActivity activity) {
    InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(activity.INPUT_METHOD_SERVICE);
    View currentFocused = activity.getCurrentFocus();
    if (currentFocused != null) {
      inputMethodManager.hideSoftInputFromWindow(currentFocused.getWindowToken(), 0);
    }
  }

  public static final void attachHideSoftKeyboardListener(final View parent, final AppCompatActivity activity) {
    // Set up touch listener for non-text box views to hide keyboard.
    if (!(parent instanceof EditText)) {
      parent.setOnTouchListener(new View.OnTouchListener() {
        public boolean onTouch(View v, MotionEvent event) {
          hideSoftKeyboard(activity);

          if (event.getAction() == MotionEvent.ACTION_UP) {
            v.performClick();
          }
          return true;
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
