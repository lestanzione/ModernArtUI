package br.com.stanzione.modernartui;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class ModernArtActivity extends Activity {
	
	SeekBar seekBarColor;
	LinearLayout block1, block2, block3, block4, block5, block6,
		block7, block8, block9, block10, block11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modern_art);
		
		block1 = (LinearLayout) findViewById(R.id.block1);
		block2 = (LinearLayout) findViewById(R.id.block2);
		block3 = (LinearLayout) findViewById(R.id.block3);
		block4 = (LinearLayout) findViewById(R.id.block4);
		block5 = (LinearLayout) findViewById(R.id.block5);
		block6 = (LinearLayout) findViewById(R.id.block6);
		block7 = (LinearLayout) findViewById(R.id.block7);
		block8 = (LinearLayout) findViewById(R.id.block8);
		block9 = (LinearLayout) findViewById(R.id.block9);
		block10 = (LinearLayout) findViewById(R.id.block10);
		block11 = (LinearLayout) findViewById(R.id.block11);
		
		seekBarColor = (SeekBar) findViewById(R.id.seekBarColor);
		seekBarColor.setMax(255);

		seekBarColor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
				
				block1.setBackgroundColor(Color.argb(0xFF, progress, 51, 204));
				block2.setBackgroundColor(Color.argb(0xFF, 255, progress, 0));
				block3.setBackgroundColor(Color.argb(0xFF, 255, 119, progress));
				block4.setBackgroundColor(Color.argb(0xFF, progress, 204, 153));
				block5.setBackgroundColor(Color.argb(0xFF, 238, 204, progress));
				block7.setBackgroundColor(Color.argb(0xFF, 255, progress, 136));
				block8.setBackgroundColor(Color.argb(0xFF, progress, 51, 204));
				block9.setBackgroundColor(Color.argb(0xFF, 255, progress, 0));
				block10.setBackgroundColor(Color.argb(0xFF, 255, 119, progress));
				block11.setBackgroundColor(Color.argb(0xFF, progress, 204, 153));
				
			}
			
			public void onStartTrackingTouch(SeekBar arg0) {}
			
			public void onStopTrackingTouch(SeekBar seekBar) {}
			
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.modern_art, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.more_info:
	            
	            createDialog();
	        	
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	public void createDialog(){
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ModernArtActivity.this);

		alertDialogBuilder
		.setMessage("Inspired by the works of artists such as Piet Mondrian" +
				" and Ben Nicholson.\n\nClick below to learn more!")
		.setCancelable(false)
		.setPositiveButton("Visit MOMA",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				
				showWebpage();
				
			}
		})
		.setNegativeButton("Not Now",
				new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				
				dialog.cancel();
				
			}
		});
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		
	}
	
	public void showWebpage(){
		
		Uri webpage = Uri.parse("http://www.moma.org");
        Intent webIntent = null;
        webIntent = new Intent(Intent.ACTION_VIEW, webpage);
		
        startActivity(webIntent);
        
	}

}
