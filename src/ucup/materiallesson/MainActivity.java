package ucup.materiallesson;

import java.util.ArrayList;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {

	private Toolbar mToolbar;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mListView;
	private ArrayList<ListMenuModel> mListMenu;
	private ListMenuAdapter mListMenuAdapter;
	private FragmentManager mFragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mFragmentManager = getSupportFragmentManager();
		
		mToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
		setSupportActionBar(mToolbar);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
		mDrawerToggle = new ActionBarDrawerToggle(
				this, 
				mDrawerLayout, 
				mToolbar, 
				R.string.drawer_open, 
				R.string.drawer_close){

			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		};

		// Set the drawer toggle as the DrawerListener
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		mToolbar.setClickable(true);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		mListView = (ListView)findViewById(R.id.left_drawer);
		mListView.setOnItemClickListener(this);

		mListMenu = new ArrayList<ListMenuModel>();
		mListMenu.add(new ListMenuModel("List #1", "List #1", R.drawable.ic_action_computer));
		mListMenu.add(new ListMenuModel("List #2", "List #2", R.drawable.ic_action_computer));
		mListMenu.add(new ListMenuModel("List #3", "List #3", R.drawable.ic_action_computer));
		mListMenuAdapter = new ListMenuAdapter(getApplicationContext(),
				mListMenu);
		mListView.setAdapter(mListMenuAdapter);
		
		displayView(0);
	}

	private void displayView(int position) {
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new MainFragment().newInstance(position);
			break;
		case 1:
			fragment = new MainFragment().newInstance(position);
			break;
		case 2:
			fragment = new MainFragment().newInstance(position);
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentTransaction ft = mFragmentManager.beginTransaction();
			ft.replace(R.id.content_frame, fragment);
			ft.commit();

			getSupportActionBar().setTitle(mListMenu.get(position).getDesc());
			mListView.setItemChecked(position, true);
			mListView.setSelection(position);

			mDrawerLayout.closeDrawer(mListView);
		} else {
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		displayView(arg2);
	}

}
