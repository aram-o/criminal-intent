package com.bignerdranch.android.criminalintent;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class PictureDialogFragment extends DialogFragment {
    public static final String EXTRA_IMAGE_PATH = "com.bignerdranch.android.criminalintent.image_path";

    private ImageView mImageView;

    public static PictureDialogFragment newInstance(String imagePath){
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_IMAGE_PATH, imagePath);

        PictureDialogFragment fragment = new PictureDialogFragment();
        fragment.setArguments(args);
        fragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mImageView = new ImageView(getActivity());
        String path = (String) getArguments().getSerializable(EXTRA_IMAGE_PATH);
        Bitmap image = PictureUtils.getScaledBitmap(path, getActivity());

        mImageView.setImageBitmap(image);

        return mImageView;
    }
}
