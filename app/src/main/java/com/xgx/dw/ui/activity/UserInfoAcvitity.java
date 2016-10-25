package com.xgx.dw.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.xgx.dw.R;
import com.xgx.dw.SpotPricingBean;
import com.xgx.dw.StoreBean;
import com.xgx.dw.TransformerBean;
import com.xgx.dw.UserBean;
import com.xgx.dw.app.G;
import com.xgx.dw.app.Setting;
import com.xgx.dw.base.BaseAppCompatActivity;
import com.xgx.dw.bean.LoginInformation;
import com.xgx.dw.dao.StoreBeanDaoHelper;
import com.xgx.dw.dao.TransformerBeanDaoHelper;
import com.xgx.dw.presenter.impl.UserPresenterImpl;
import com.xgx.dw.presenter.interfaces.IUserPresenter;
import com.xgx.dw.ui.view.interfaces.IUserView;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import fr.ganfra.materialspinner.MaterialSpinner;

public class UserInfoAcvitity extends BaseAppCompatActivity implements IUserView, Toolbar.OnMenuItemClickListener {
    @Bind(R.id.imeTv)
    TextView imeTv;
    @Bind(R.id.store_spinner)
    MaterialSpinner storeSpinner;
    @Bind(R.id.store_layout)
    LinearLayout storeLayout;
    @Bind(R.id.transformer_spinner)
    MaterialSpinner transformerSpinner;
    @Bind(R.id.transformer_layout)
    LinearLayout transformerLayout;
    @Bind(R.id.user_id)
    MaterialEditText userId;
    @Bind(R.id.user_name)
    MaterialEditText userName;
    @Bind(R.id.voltageRatio)
    MaterialEditText voltageRatio;
    @Bind(R.id.currentRatio)
    MaterialEditText currentRatio;
    @Bind(R.id.price)
    TextView price;
    @Bind(R.id.phone)
    MaterialEditText phone;
    @Bind(R.id.action_save)
    RippleView actionSave;
    private IUserPresenter presenter;
    private List<StoreBean> storebeans;
    private UserBean bean;
    private List<TransformerBean> transformerBean;
    private String currentStoreId;
    private String currentStoreName;
    private boolean isFirst;


    public void initContentView() {
        baseSetContentView(R.layout.activity_create_user_three);
    }

    public void initPresenter() {
        presenter = new UserPresenterImpl();
    }

    public void initView() {
        getToolbar().setOnMenuItemClickListener(this);
        String ime = getIntent().getStringExtra("ime");
        imeTv.setText(checkText(ime));
        Setting setting = new Setting(this);
        currentStoreId = setting.loadString(G.currentStoreId);
        currentStoreName = setting.loadString(G.currentStoreName);
        initSpinnerData();
        initEditInfo();
    }

    private void initEditInfo() {
        isFirst = true;
        bean = ((UserBean) getIntent().getSerializableExtra("bean"));
        if (bean != null && !TextUtils.isEmpty(this.bean.getUserId())) {
            getSupportActionBar().setTitle("个人资料");
            this.userId.setText(this.bean.getUserId());
            this.userId.setEnabled(false);
            userName.setText(checkText(this.bean.getUserName()));
            price.setText(checkText(bean.getPrice()));
            phone.setText(checkText(bean.getPhone()));
            currentRatio.setText(checkText(bean.getCurrentRatio()));
            voltageRatio.setText(checkText(bean.getVoltageRatio()));
            imeTv.setText(checkText(bean.getIme()));
            try {
                for (int i = 0; i < storebeans.size(); i++) {
                    if (bean.getStoreId().equals(((StoreBean) storebeans.get(i)).getId())) {
                        storeSpinner.setSelection(i + 1);
                        storeSpinner.setEnabled(false);
                    }
                }
            } catch (Exception e) {

            }
            try {
                transformerBean = TransformerBeanDaoHelper.getInstance().testQueryBy(bean.getStoreId());
                if ((transformerBean != null) && (transformerBean.size() > 0)) {
                    String[] arrayOfString = new String[transformerBean.size()];
                    for (int j = 0; j < transformerBean.size(); j++) {
                        arrayOfString[j] = ((TransformerBean) transformerBean.get(j)).getName();
                    }
                    ArrayAdapter localArrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, arrayOfString);
                    localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    transformerSpinner.setAdapter(localArrayAdapter);
                }
                for (int i = 0; i < transformerBean.size(); i++) {
                    if (bean.getTransformerId().equals(((TransformerBean) transformerBean.get(i)).getId())) {
                        transformerSpinner.setSelection(i + 1);
                        transformerSpinner.setEnabled(false);
                    }
                }
            } catch (Exception e) {

            }
        }
        storeSpinner.setEnabled(false);
        transformerSpinner.setEnabled(false);
        userId.setEnabled(false);
        userName.setEnabled(false);
        voltageRatio.setEnabled(false);
        currentRatio.setEnabled(false);
        price.setEnabled(false);
        phone.setEnabled(false);
        actionSave.setVisibility(View.GONE);
    }


    private void initSpinnerData() {
        //如果是10级用户 则直接拉去当前用户的营业厅，如果是11用户 则直接显示当前用户的营业厅和台区
        storebeans = StoreBeanDaoHelper.getInstance().getAllData();
        if ((this.storebeans != null) && (this.storebeans.size() > 0)) {
            String[] arrayOfString = new String[this.storebeans.size()];
            for (int j = 0; j < this.storebeans.size(); j++) {
                arrayOfString[j] = ((StoreBean) this.storebeans.get(j)).getName();
            }
            ArrayAdapter localArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayOfString);
            localArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.storeSpinner.setAdapter(localArrayAdapter);
        }

    }


    public void saveTransformer(boolean paramBoolean) {
        hideProgress();
        if (paramBoolean) {
            showToast("保存成功");
            finish();
        }
    }


    public boolean onCreateOptionsMenu(Menu paramMenu) {
        if (bean != null && !TextUtils.isEmpty(bean.getUserId())) {
            getMenuInflater().inflate(R.menu.menu_erweima, paramMenu);
        }
        return true;
    }


    public boolean onMenuItemClick(MenuItem paramMenuItem) {
        switch (paramMenuItem.getItemId()) {
            case R.id.action_showerweima:
                startActivity(new Intent(this, TestGeneratectivity.class).putExtra("type", 3).putExtra("id", bean.getUserId()));
                break;
            case R.id.action_spotInfo:
                Intent intent = new Intent(getContext(), AdminSpotListActivity.class);
                intent.putExtra("id", bean.getUserId());
                startActivity(intent);
                break;
        }
        return true;
    }


}