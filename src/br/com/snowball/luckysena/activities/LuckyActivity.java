package br.com.snowball.luckysena.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import br.com.snowball.luckysena.R;
import br.com.snowball.luckysena.generator.SenaNumberGenerator;

public class LuckyActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button luckyNumbersBtn = (Button) findViewById(R.id.luckyNumbersBtn);
		luckyNumbersBtn.setOnClickListener(generateBtnListener);
	}

	private OnClickListener generateBtnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					LuckyActivity.this);
			builder.setMessage(SenaNumberGenerator.generateLuckyNumbers())
					.setTitle("Nœmeros da sorte")
					.setNeutralButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			builder.show();
		}
	};
}