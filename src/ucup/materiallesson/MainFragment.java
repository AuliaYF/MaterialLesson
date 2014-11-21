package ucup.materiallesson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainFragment extends Fragment{

	private String mString;

	public static MainFragment newInstance(int position){
		MainFragment fragment = new MainFragment();
		fragment.mString = "Fragment #" + String.valueOf(position + 1);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView text = (TextView)inflater.inflate(R.layout.fragment_view, container, false);
		text.setText(mString);
		return text;
	}

}
