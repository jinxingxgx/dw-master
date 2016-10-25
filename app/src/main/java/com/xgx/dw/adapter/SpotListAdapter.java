package com.xgx.dw.adapter;

import android.support.v4.content.ContextCompat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xgx.dw.PricingBean;
import com.xgx.dw.R;
import com.xgx.dw.SpotPricingBean;
import com.xgx.dw.dao.SpotPricingBeanDaoHelper;
import com.xgx.dw.utils.MyUtils;

import java.util.List;

public class SpotListAdapter extends BaseQuickAdapter<PricingBean> {
    public SpotListAdapter(List<PricingBean> paramList) {
        super(R.layout.base_list_item, paramList);
    }

    protected void convert(BaseViewHolder baseViewHolder, PricingBean bean) {
        SpotPricingBean spotPricingBean = SpotPricingBeanDaoHelper.getInstance().getDataById(bean.getPid());
        String spotName = "";
        String jdj = "";
        String fdj = "";
        String pdj = "";
        String gdj = "";

        if (spotPricingBean != null) {
            spotName = spotPricingBean.getName();
            jdj = spotPricingBean.getPointed_price();
            fdj = spotPricingBean.getPeek_price();
            pdj = spotPricingBean.getFlat_price();
            gdj = spotPricingBean.getValley_price();
        }
        baseViewHolder.setText(R.id.title, "购电单号：" + bean.getSpotpriceId() +
                "\n营业厅名称：" + bean.getStoreName() +
                "\n营业厅地址：" + bean.getStoreAddress() +
                "\n电价名称：" + spotName +
                "\n尖：" + jdj +
                "\n峰：" + fdj +
                "\n平：" + pdj +
                "\n谷：" + gdj +
                "\n购电金额(元)：" + bean.getPrice() +
                "\n购电类型：" + bean.getType() +
                "\n操作员名称：" + bean.getAdminName() +
                "\n联系人名称：" + bean.getAdminName() +
                "\n联系人电话：" + bean.getAdminPhone());
        String type = bean.getType().equals("2") ? "已完成" : "未上传至设备";
        baseViewHolder.setText(R.id.subtitle, type);
        baseViewHolder.setTextColor(R.id.subtitle, ContextCompat.getColor(mContext, bean.getType().equals("2") ? android.R.color.holo_blue_light : android.R.color.holo_red_light));
        baseViewHolder.setText(R.id.content, "购电时间：" + bean.getCreateTime());
    }
}