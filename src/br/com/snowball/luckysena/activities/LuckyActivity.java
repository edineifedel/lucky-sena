package br.com.snowball.luckysena.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LuckyActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button chooseNumbersBtn = (Button) findViewById(R.id.luckyNumbersBtn);
		chooseNumbersBtn.setOnClickListener(chooseNumbersBtnListener);
	}

	private OnClickListener chooseNumbersBtnListener = new OnClickListener() {

		@Override
		public void onClick(View view) {
			Intent intent = new Intent(LuckyActivity.this, NumbersChooseActivity.class);
			startActivityForResult(intent, 0);
		}
			
	};
}