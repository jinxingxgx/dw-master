package com.xgx.dw;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.xgx.dw.PricingBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table Pricing.
*/
public class PricingBeanDao extends AbstractDao<PricingBean, String> {

    public static final String TABLENAME = "Pricing";

    /**
     * Properties of entity PricingBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", true, "ID");
        public final static Property UserPrimaryid = new Property(1, String.class, "userPrimaryid", false, "USER_PRIMARYID");
        public final static Property Pid = new Property(2, String.class, "pid", false, "PID");
        public final static Property Price = new Property(3, String.class, "price", false, "PRICE");
        public final static Property Bjprice = new Property(4, String.class, "bjprice", false, "BJPRICE");
        public final static Property SpotpriceId = new Property(5, String.class, "spotpriceId", false, "SPOTPRICE_ID");
        public final static Property UserId = new Property(6, String.class, "userId", false, "USER_ID");
        public final static Property UserName = new Property(7, String.class, "userName", false, "USER_NAME");
        public final static Property AdminName = new Property(8, String.class, "adminName", false, "ADMIN_NAME");
        public final static Property AdminNickName = new Property(9, String.class, "adminNickName", false, "ADMIN_NICK_NAME");
        public final static Property AdminPhone = new Property(10, String.class, "adminPhone", false, "ADMIN_PHONE");
        public final static Property StoreId = new Property(11, String.class, "storeId", false, "STORE_ID");
        public final static Property StoreName = new Property(12, String.class, "storeName", false, "STORE_NAME");
        public final static Property StoreAddress = new Property(13, String.class, "storeAddress", false, "STORE_ADDRESS");
        public final static Property TransformerId = new Property(14, String.class, "transformerId", false, "TRANSFORMER_ID");
        public final static Property TransformerName = new Property(15, String.class, "transformerName", false, "TRANSFORMER_NAME");
        public final static Property CreateTime = new Property(16, String.class, "createTime", false, "CREATE_TIME");
        public final static Property Type = new Property(17, String.class, "type", false, "TYPE");
        public final static Property Finishtype = new Property(18, String.class, "finishtype", false, "FINISHTYPE");
        public final static Property Ime = new Property(19, String.class, "ime", false, "IME");
    };


    public PricingBeanDao(DaoConfig config) {
        super(config);
    }
    
    public PricingBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'Pricing' (" + //
                "'ID' TEXT PRIMARY KEY NOT NULL ," + // 0: id
                "'USER_PRIMARYID' TEXT," + // 1: userPrimaryid
                "'PID' TEXT," + // 2: pid
                "'PRICE' TEXT," + // 3: price
                "'BJPRICE' TEXT," + // 4: bjprice
                "'SPOTPRICE_ID' TEXT," + // 5: spotpriceId
                "'USER_ID' TEXT," + // 6: userId
                "'USER_NAME' TEXT," + // 7: userName
                "'ADMIN_NAME' TEXT," + // 8: adminName
                "'ADMIN_NICK_NAME' TEXT," + // 9: adminNickName
                "'ADMIN_PHONE' TEXT," + // 10: adminPhone
                "'STORE_ID' TEXT," + // 11: storeId
                "'STORE_NAME' TEXT," + // 12: storeName
                "'STORE_ADDRESS' TEXT," + // 13: storeAddress
                "'TRANSFORMER_ID' TEXT," + // 14: transformerId
                "'TRANSFORMER_NAME' TEXT," + // 15: transformerName
                "'CREATE_TIME' TEXT," + // 16: createTime
                "'TYPE' TEXT," + // 17: type
                "'FINISHTYPE' TEXT," + // 18: finishtype
                "'IME' TEXT);"); // 19: ime
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'Pricing'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PricingBean entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String userPrimaryid = entity.getUserPrimaryid();
        if (userPrimaryid != null) {
            stmt.bindString(2, userPrimaryid);
        }
 
        String pid = entity.getPid();
        if (pid != null) {
            stmt.bindString(3, pid);
        }
 
        String price = entity.getPrice();
        if (price != null) {
            stmt.bindString(4, price);
        }
 
        String bjprice = entity.getBjprice();
        if (bjprice != null) {
            stmt.bindString(5, bjprice);
        }
 
        String spotpriceId = entity.getSpotpriceId();
        if (spotpriceId != null) {
            stmt.bindString(6, spotpriceId);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(7, userId);
        }
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(8, userName);
        }
 
        String adminName = entity.getAdminName();
        if (adminName != null) {
            stmt.bindString(9, adminName);
        }
 
        String adminNickName = entity.getAdminNickName();
        if (adminNickName != null) {
            stmt.bindString(10, adminNickName);
        }
 
        String adminPhone = entity.getAdminPhone();
        if (adminPhone != null) {
            stmt.bindString(11, adminPhone);
        }
 
        String storeId = entity.getStoreId();
        if (storeId != null) {
            stmt.bindString(12, storeId);
        }
 
        String storeName = entity.getStoreName();
        if (storeName != null) {
            stmt.bindString(13, storeName);
        }
 
        String storeAddress = entity.getStoreAddress();
        if (storeAddress != null) {
            stmt.bindString(14, storeAddress);
        }
 
        String transformerId = entity.getTransformerId();
        if (transformerId != null) {
            stmt.bindString(15, transformerId);
        }
 
        String transformerName = entity.getTransformerName();
        if (transformerName != null) {
            stmt.bindString(16, transformerName);
        }
 
        String createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindString(17, createTime);
        }
 
        String type = entity.getType();
        if (type != null) {
            stmt.bindString(18, type);
        }
 
        String finishtype = entity.getFinishtype();
        if (finishtype != null) {
            stmt.bindString(19, finishtype);
        }
 
        String ime = entity.getIme();
        if (ime != null) {
            stmt.bindString(20, ime);
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public PricingBean readEntity(Cursor cursor, int offset) {
        PricingBean entity = new PricingBean( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userPrimaryid
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // pid
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // price
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // bjprice
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // spotpriceId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // userId
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // userName
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // adminName
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // adminNickName
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // adminPhone
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // storeId
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // storeName
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // storeAddress
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // transformerId
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // transformerName
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // createTime
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17), // type
            cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18), // finishtype
            cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19) // ime
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PricingBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUserPrimaryid(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPid(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPrice(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBjprice(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setSpotpriceId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUserId(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUserName(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setAdminName(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setAdminNickName(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setAdminPhone(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setStoreId(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setStoreName(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setStoreAddress(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setTransformerId(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setTransformerName(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setCreateTime(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setType(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
        entity.setFinishtype(cursor.isNull(offset + 18) ? null : cursor.getString(offset + 18));
        entity.setIme(cursor.isNull(offset + 19) ? null : cursor.getString(offset + 19));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(PricingBean entity, long rowId) {
        return entity.getId();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(PricingBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
