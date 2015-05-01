package com.ljp.pathmenu;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class PathMenuActivity extends Activity {
	/** Called when the activity is first created. */

	private boolean			areButtonsShowing;
	private RelativeLayout	composerButtonsWrapper;
	private ImageView		composerButtonsShowHideButtonIcon;
	private RelativeLayout	composerButtonsShowHideButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		composerButtonsWrapper = (RelativeLayout) findViewById(R.id.composer_buttons_wrapper);
		composerButtonsShowHideButton = (RelativeLayout) findViewById(R.id.composer_buttons_show_hide_button);
		composerButtonsShowHideButtonIcon = (ImageView) findViewById(R.id.composer_buttons_show_hide_button_icon);

		composerButtonsShowHideButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (!areButtonsShowing) {
					MyAnimations.startAnimationsIn(composerButtonsWrapper, 300);
                    ObjectAnimator.ofFloat(composerButtonsShowHideButtonIcon, "rotation", -270, 300).setDuration(300).start();
				}
				else {
					MyAnimations.startAnimationsOut(composerButtonsWrapper, 300);
                    ObjectAnimator.ofFloat(composerButtonsShowHideButtonIcon, "rotation", -270, 0).setDuration(300).start();
				}
				areButtonsShowing = !areButtonsShowing;
			}
		});
		for (int i = 0; i < composerButtonsWrapper.getChildCount(); i++) {
			composerButtonsWrapper.getChildAt(i).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View arg0) {
				}
			});
		}

        ObjectAnimator.ofFloat(composerButtonsShowHideButtonIcon, "rotation", 0, 360).setDuration(200).start();

	}

}