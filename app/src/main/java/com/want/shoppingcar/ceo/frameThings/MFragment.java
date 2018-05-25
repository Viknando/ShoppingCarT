package com.want.shoppingcar.ceo.frameThings;

import android.support.v4.app.Fragment;


import com.want.shoppingcar.ceo.IPresenter;
import com.want.shoppingcar.ceo.IView;


/**
 * <b>Project:</b> android_sdk_base<br>
 * <b>Create Date:</b> 15/9/15<br>
 * <b>Author:</b> Gordon<br>
 * <b>Description:</b>
 * base {@link Fragment}
 * <br>
 */
public class MFragment extends Fragment implements IView {
    private IPresenter mPresenter;

    @SuppressWarnings("unchecked")
    protected <P> P getPresenter() {
        return (P) mPresenter;
    }

    @Override
    public void setPresenter(IPresenter presenter) {
        if (null != mPresenter) {
            // view already has the presenter
            return;
        }
        this.mPresenter = presenter;
    }

}
