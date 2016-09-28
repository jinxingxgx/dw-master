package com.xgx.dw.presenter.impl;

import android.view.View;

import com.xgx.dw.TransformerBean;
import com.xgx.dw.UserBean;
import com.xgx.dw.app.G;
import com.xgx.dw.app.Setting;
import com.xgx.dw.base.BasePresenter;
import com.xgx.dw.dao.TransformerBeanDaoHelper;
import com.xgx.dw.dao.UserBeanDaoHelper;
import com.xgx.dw.presenter.interfaces.ITransformerPresenter;
import com.xgx.dw.presenter.interfaces.IUserPresenter;
import com.xgx.dw.ui.view.interfaces.ICreateTransformerView;
import com.xgx.dw.ui.view.interfaces.ITransformerView;
import com.xgx.dw.ui.view.interfaces.IUserListView;
import com.xgx.dw.ui.view.interfaces.IUserView;

public class UserPresenterImpl extends BasePresenter implements IUserPresenter {
    public void saveTransformer(ICreateTransformerView paramICreateTransformerView, TransformerBean paramTransformerBean, boolean paramBoolean) {
        if (isEmpty(paramTransformerBean.getStore_name(), paramICreateTransformerView, "请选择营业厅"))
            return;
        if (isEmpty(paramTransformerBean.getId(), paramICreateTransformerView, "台区编号不能为空")) return;
        if (isEmpty(paramTransformerBean.getName(), paramICreateTransformerView, "台区名称不能为空"))
            return;
        if (TransformerBeanDaoHelper.getInstance().hasKey(paramTransformerBean.getId())) {
            paramICreateTransformerView.showToast("已有相同编号的台区");
            paramICreateTransformerView.saveTransformer(false);
            return;
        }
        TransformerBeanDaoHelper.getInstance().addData(paramTransformerBean);
        paramICreateTransformerView.saveTransformer(true);
    }

    public void searchTransformer(ITransformerView paramITransformerView, TransformerBean paramTransformerBean) {
        paramITransformerView.searchTransformer(TransformerBeanDaoHelper.getInstance().getAllData());
    }

    @Override
    public void saveUser(IUserView IBaseView, UserBean userBean, int type, boolean isSave) {
        IBaseView.hideProgress();
        if (isEmpty(userBean.getUserId(), IBaseView, "用户编号不能为空")) return;
        if (isEmpty(userBean.getUserName(), IBaseView, "用户名称不能为空")) return;
        if (isEmpty(userBean.getStoreName(), IBaseView, "请选择营业厅")) return;
        if (type == 11) {
            if (isEmpty(userBean.getTransformerId(), IBaseView, "台区名称不能为空")) return;
        }

        if (UserBeanDaoHelper.getInstance().hasKey(userBean.getUserId()) && isSave == true) {
            IBaseView.showToast("已有相同编号的用户");
            IBaseView.saveTransformer(false);
            return;
        }
        userBean.setType(type + "");
        UserBeanDaoHelper.getInstance().addData(userBean);
        IBaseView.saveTransformer(true);
    }

    @Override
    public void searchUser(IUserListView IBaseView) {
        IBaseView.getUserList(UserBeanDaoHelper.getInstance().getAllData());
    }
}