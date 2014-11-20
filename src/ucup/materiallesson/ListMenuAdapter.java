package ucup.materiallesson;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListMenuAdapter extends ArrayAdapter<ListMenuModel>{

	public ListMenuAdapter(Context context, List<ListMenuModel> objects) {
		super(context, R.layout.list_menu_item, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;

		if(convertView == null) {
			// inflate the GridView item layout
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.list_menu_item, parent, false);

			// initialize the view holder
			viewHolder = new ViewHolder();
			viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.icon);
			viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.title);
			convertView.setTag(viewHolder);
		} else {
			// recycle the already inflated view 
			viewHolder = (ViewHolder) convertView.getTag();
		}

		// update the item view
		ListMenuModel item = getItem(position);
		viewHolder.ivIcon.setImageResource(item.getIcon());
		viewHolder.tvTitle.setText(item.getTitle());

		return convertView;
	}

	private static class ViewHolder{
		ImageView ivIcon;
		TextView tvTitle;
	}
}
