package com.want.shoppingcar.shopcar.contract;


import com.want.shoppingcar.ceo.IPresenter;
import com.want.shoppingcar.ceo.IView;

public interface GuessULikeContract {
    interface Presenter extends IPresenter {
        void reqPinCheck();
        void postError();

    }

    interface View extends IView {
        /**
         * pin码验证成功
         */
        void pinCheckSuccess();
        /**
         * showToast
         */
        void onShowMsg();
    }

}
