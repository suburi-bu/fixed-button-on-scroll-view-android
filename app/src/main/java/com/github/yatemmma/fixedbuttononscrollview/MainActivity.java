package com.github.yatemmma.fixedbuttononscrollview;

import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] members = new String[100];
        Arrays.fill(members, " ");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1, members);
        ((ListView) findViewById(R.id.listView)).setAdapter(adapter);

        button = new ImageButton(this);
        button.setImageResource(R.drawable.droid);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d("Sample", "Touched.");
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Drawable image = getResources().getDrawable(R.drawable.droid);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        int marginRight = 20;
        int marginBottom = 20;
        int width = image.getIntrinsicWidth();
        int height = image.getIntrinsicHeight();
        int x = layout.getWidth() - width - marginRight;
        int y = layout.getHeight() - height - marginBottom;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, height);
        params.leftMargin = x;
        params.topMargin = y;
        layout.addView(button, params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
