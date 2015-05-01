package com.ljp.pathmenu;

import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.Map;

public class MyAnimations {

	private final static int	R		= 200;

	public static void startAnimationsIn(ViewGroup viewgroup, int durationMillis) {

        final float angleBetween = 180 / (viewgroup.getChildCount() - 1);

		for (int i = 0; i < viewgroup.getChildCount(); i++) {
			ImageButton inoutimagebutton = (ImageButton) viewgroup.getChildAt(i);
			inoutimagebutton.setVisibility(View.VISIBLE);
			final double marginTop = Math.sin(angleBetween * i * Math.PI / 180) * R;
			final double marginRight = Math.cos(angleBetween * i * Math.PI / 180) * R;
			Log.d("animation", marginTop + "," + marginRight);

            Map<String, int[]> table =
                    new HashMap<String, int[]>(){{
                        put("translationX", new int[]{0, -(int)marginRight});
                        put("translationY", new int[]{0, -(int) marginTop});
                    }};

            for(Map.Entry<String, int[]> entry : table.entrySet()) {
                String property = entry.getKey();
                int[] range = entry.getValue();

                ObjectAnimator anim = ObjectAnimator.ofFloat(inoutimagebutton, property, range[0], range[1]);
                anim.setDuration(durationMillis);
                anim.setInterpolator(new OvershootInterpolator(2F));
                anim.setStartDelay((i * 100) / (-1 + viewgroup.getChildCount()));
                anim.start();
            }
		}
	}

	public static void startAnimationsOut(ViewGroup viewgroup, int durationMillis) {

        final float angleBetween = 180 / (viewgroup.getChildCount() - 1);

        for (int i = 0; i < viewgroup.getChildCount(); i++) {
			final ImageButton inoutimagebutton = (ImageButton) viewgroup.getChildAt(i);
			final double marginTop = Math.sin(angleBetween * i * Math.PI / 180) * R;
			final double marginRight = Math.cos(angleBetween * i * Math.PI / 180) * R;
			Log.d("animation", marginTop + "," + marginRight);

            Map<String, int[]> table =
                    new HashMap<String, int[]>(){{
                        put("translationX", new int[]{-(int)marginRight, 0});
                        put("translationY", new int[]{-(int)marginTop, 0});
                    }};

            for(Map.Entry<String, int[]> entry : table.entrySet()) {
                String property = entry.getKey();
                int[] range = entry.getValue();

                ObjectAnimator anim = ObjectAnimator.ofFloat(inoutimagebutton, property, range[0], range[1]);
                anim.setDuration(durationMillis);
                anim.setInterpolator(new OvershootInterpolator(2F));
                anim.setStartDelay((i * 100) / (-1 + viewgroup.getChildCount()));
                anim.start();
            }
		}

	}
}