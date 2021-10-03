package com.umb.umbactividad2plataformasmoviles.ui.presentation;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.umb.umbactividad2plataformasmoviles.R;


import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;



/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class Presentation extends BottomSheetDialogFragment {

        @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.presentacion, container, false);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog bottomSheetDialog=(BottomSheetDialog)super.onCreateDialog(savedInstanceState);
        bottomSheetDialog.setOnShowListener(dialog -> {
            BottomSheetDialog dialogc = (BottomSheetDialog) dialog;
            // When using AndroidX the resource can be found at com.google.android.material.R.id.design_bottom_sheet
            FrameLayout bottomSheet =  dialogc.findViewById(com.google.android.material.R.id.design_bottom_sheet);

            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
            bottomSheetBehavior.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

            final Handler handler  = new Handler();
            final Runnable runnable = new Runnable() {
                @Override
                public void run() {
                   if (dialogc.isShowing()) {
                        dialogc.dismiss();
                    }
                }
            };
            handler.postDelayed(runnable, 4000);
        });


        return bottomSheetDialog;
    }


}