package ua.stu.arch.lab_1;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    public static ArrayList<String> contents = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, contents);
        listView.setAdapter(adapter);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Enter new item");

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.addItem(input.getText().toString());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

        Button removeBtn = (Button) findViewById(R.id.removeBtn);
        removeBtn.setEnabled(false);
        removeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                MainActivity.this.removeItem();
            }
        });

        Button saveBtn = (Button) findViewById(R.id.saveBtn);
        removeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        Button loadBtn = (Button) findViewById(R.id.loadBtn);
        removeBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

    }

    public void addItem(String str) {
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = (ArrayAdapter) listView.getAdapter();
        adapter.add(str);
        if(adapter.getCount() == 1) {
            Button removeBtn = (Button)findViewById(R.id.removeBtn);
            removeBtn.setEnabled(true);
        }
    }

    public void removeItem() {
        ListView listView = (ListView) findViewById(R.id.listView);
        int checked = listView.getCheckedItemPosition();
        ArrayAdapter<String> adapter = (ArrayAdapter) listView.getAdapter();
        adapter.remove(adapter.getItem(checked));
        if(adapter.getCount() == 0) {
            Button removeBtn = (Button)findViewById(R.id.removeBtn);
            removeBtn.setEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}