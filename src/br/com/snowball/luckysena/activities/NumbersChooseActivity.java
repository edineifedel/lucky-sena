package br.com.snowball.luckysena.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import br.com.snowball.luckysena.generator.SenaNumberGenerator;

public class NumbersChooseActivity extends Activity {

	RelativeLayout layout;
	private int height;
	private int width;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.numbers_choosen_activity);

		// TextView text = new TextView(this);
		// text.setText("Aeeeee");
		// text.setTextColor(0xFFFFFF);
		layout = new RelativeLayout(this);
		getDisplaySizes();
		showImagesOnScreen();

		setContentView(layout);

		// Button luckyNumbersBtn = (Button) findViewById(R.id.luckyNumbersBtn);
		// luckyNumbersBtn.setOnClickListener(generateBtnListener);
	}

	private void showImagesOnScreen() {
		int coordY = getInitialY();
		for (int i = 0; i < 2; i++) {
			int coordX = getInitialX();
			for (int j = 0; j < 3; j++) {
				ImageView image = new ImageView(this);
				image.setImageResource(R.drawable.ball_white);
				RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
						100, 100);
				lp.leftMargin = coordX;
				lp.topMargin = coordY;
				layout.addView(image, lp);
				coordX = coordX + 120;
			}
			coordY = coordY + 120;
		}
	}

	private int getInitialY() {
		return (int) (0.3 * height);
	}

	private int getInitialX() {
		return (int) (0.15 * width);
	}

	private void getDisplaySizes() {
		Display display = getWindowManager().getDefaultDisplay();
		this.width = display.getWidth();
		this.height = display.getHeight();
	}

	private OnClickListener generateBtnListener = new OnClickListener() {

		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(
					NumbersChooseActivity.this);
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