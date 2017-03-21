package surensth.com.signature;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by surensth on 3/20/17.
 */

public class FormFragment extends MasterFragment {
    @BindView(R.id.signatureImageView)
    ImageView signatureImageView;

    public static FormFragment newInstance() {
        FormFragment fragment = new FormFragment();
        return fragment;
    }

    public FormFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.signatureImageView)
    public void OnClickSignatureImageView() {
        openFragment(SignatureFragment.newInstance());
    }

    @Override
    public void onResume() {
        super.onResume();
        Bitmap mBitmap = ((MainActivity) getActivity()).getmBitmap();
        if (mBitmap != null)
            signatureImageView.setImageBitmap(mBitmap);
    }
}
