package art.maxandriani.calculadoradesalarios.infra;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import art.maxandriani.calculadoradesalarios.R;
import art.maxandriani.calculadoradesalarios.views.SettingsActivity;
import com.google.android.material.appbar.MaterialToolbar;

import static androidx.core.content.ContextCompat.startActivity;

public class MainMenuUtils {

  public static void setupMainMenu(MaterialToolbar toolbar, final Context context) {
    toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
      @Override
      public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
          case R.id.main_menu_settings:
            Intent settings = new Intent(context, SettingsActivity.class);
            context.startActivity(settings);
            return true;
        }
        return false;
      }
    });
  }

}
