package vnzit.com.sampletransitionanimation;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final List<Item> contents =  new ArrayList<>();
        contents.add(new Item(R.drawable.android1, "Hello"));
        contents.add(new Item(R.drawable.android2, "Everybody"));
        contents.add(new Item(R.drawable.android1, "Welcome"));
        contents.add(new Item(R.drawable.android2, "To"));
        contents.add(new Item(R.drawable.android1, "QuangSon's Blog"));

        final ListView lvContainer = (ListView) findViewById(R.id.lvContainer);
        lvContainer.setAdapter(new ItemAdapter(this, R.layout.item, contents));
        lvContainer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ITEM, contents.get(position));
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(MainActivity.this, view.findViewById(R.id.ivIcon), "icon");
                startActivity(intent, options.toBundle());
            }
        });
    }
}
