package vnzit.com.sampletransitionanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sh on 6/13/16.
 */
public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM = "extra_item";

    ImageView ivIcon;
    TextView tvContent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ivIcon = (ImageView) findViewById(R.id.ivIcon);
        tvContent = (TextView) findViewById(R.id.tvContent);

        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent == null || !intent.hasExtra(EXTRA_ITEM)) {
            finish();
            return;
        }
        final Item item = (Item) intent.getSerializableExtra(EXTRA_ITEM);
        ivIcon.setImageResource(item.getIcon());
        tvContent.setText(item.getContent());
    }
}
