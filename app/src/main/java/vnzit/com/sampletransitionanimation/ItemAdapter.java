package vnzit.com.sampletransitionanimation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sh on 6/13/16.
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    private static final int[] IMGS = {R.drawable.android1, R.drawable.android2};
    public ItemAdapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        final ViewHolder holder;
        if (v == null) {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            holder = new ViewHolder(v);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.bind(getItem(position), position);
        return v;
    }

    private static class ViewHolder {

        ImageView ivIcon;
        TextView tvContent;
        ViewHolder(View v) {
            ivIcon = (ImageView) v.findViewById(R.id.ivIcon);
            tvContent = (TextView) v.findViewById(R.id.tvContent);
        }

        @SuppressLint("DefaultLocale")
        public void bind(Item item, int position) {
            ivIcon.setImageResource(item.getIcon());
            tvContent.setText(String.format("Content: %s", item.getContent()));
        }
    }
}
