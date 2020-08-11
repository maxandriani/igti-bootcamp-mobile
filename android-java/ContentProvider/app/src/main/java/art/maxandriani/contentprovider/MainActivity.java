package art.maxandriani.contentprovider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  ListView contactList;
  List<String> contactNames;
  ArrayAdapter contactAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    contactNames = new ArrayList<String>();
    contactAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contactNames);

    contactList = findViewById(R.id.contact_list_view);
    contactList.setAdapter(contactAdapter);

    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.READ_CONTACTS }, 100);
    } else {
      readContacts();
    }
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    readContacts();
  }

  private void readContacts() {
    ContentResolver resolver = getContentResolver();
    Cursor cursor = getContentResolver()
            .query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

    if (cursor.moveToFirst()) {
      do {
        contactNames.add(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
      } while (cursor.moveToNext());
    }
  }
}