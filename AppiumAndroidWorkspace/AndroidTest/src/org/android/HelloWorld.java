package org.android;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloWorld extends Activity {
	
	/** Called when the activity is first created. */
	//onCreate method will be called on initiation
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);
		tv.setText("Hello World!");
		setContentView(tv);
	}
}