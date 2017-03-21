package surensth.com.signature;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by surensth on 9/23/16.
 */

public abstract class MasterFragment extends Fragment {

    public FragmentManager mFragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFragmentManager = getActivity().getSupportFragmentManager();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager()
                .beginTransaction();
        ft.replace(R.id.container,
                fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

    public void openFragmentNoHistory(Fragment fragment) {
        FragmentTransaction ft = getFragmentManager()
                .beginTransaction();
        ft.replace(R.id.container,
                fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commitAllowingStateLoss();
    }

    public void closeFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().remove(fragment).commit();

    }

}
