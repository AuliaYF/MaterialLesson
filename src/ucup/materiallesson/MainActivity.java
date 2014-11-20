package ucup.materiallesson;

import java.util.ArrayList;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

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
		mListView.setItemChecked(arg2, true);
		mListView.setSelection(arg2);
		
		mDrawerLayout.closeDrawer(mListView);
	}

}
