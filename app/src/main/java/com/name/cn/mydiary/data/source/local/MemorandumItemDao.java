package com.name.cn.mydiary.data.source.local;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.name.cn.mydiary.data.bookdetail.MemorandumItem;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MEMORANDUM_ITEM".
*/
public class MemorandumItemDao extends AbstractDao<MemorandumItem, Long> {

    public static final String TABLENAME = "MEMORANDUM_ITEM";

    /**
     * Properties of entity MemorandumItem.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MemorandumItemOwnId = new Property(1, Long.class, "memorandumItemOwnId", false, "MEMORANDUM_ITEM_OWN_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
    }

    private Query<MemorandumItem> memorandum_MemorandumItemsQuery;

    public MemorandumItemDao(DaoConfig config) {
        super(config);
    }
    
    public MemorandumItemDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MEMORANDUM_ITEM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MEMORANDUM_ITEM_OWN_ID\" INTEGER," + // 1: memorandumItemOwnId
                "\"NAME\" TEXT NOT NULL );"); // 2: name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MEMORANDUM_ITEM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MemorandumItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long memorandumItemOwnId = entity.getMemorandumItemOwnId();
        if (memorandumItemOwnId != null) {
            stmt.bindLong(2, memorandumItemOwnId);
        }
        stmt.bindString(3, entity.getName());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MemorandumItem entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long memorandumItemOwnId = entity.getMemorandumItemOwnId();
        if (memorandumItemOwnId != null) {
            stmt.bindLong(2, memorandumItemOwnId);
        }
        stmt.bindString(3, entity.getName());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MemorandumItem readEntity(Cursor cursor, int offset) {
        MemorandumItem entity = new MemorandumItem( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // memorandumItemOwnId
            cursor.getString(offset + 2) // name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MemorandumItem entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMemorandumItemOwnId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MemorandumItem entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MemorandumItem entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MemorandumItem entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "memorandumItems" to-many relationship of Memorandum. */
    public List<MemorandumItem> _queryMemorandum_MemorandumItems(Long memorandumItemOwnId) {
        synchronized (this) {
            if (memorandum_MemorandumItemsQuery == null) {
                QueryBuilder<MemorandumItem> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.MemorandumItemOwnId.eq(null));
                memorandum_MemorandumItemsQuery = queryBuilder.build();
            }
        }
        Query<MemorandumItem> query = memorandum_MemorandumItemsQuery.forCurrentThread();
        query.setParameter(0, memorandumItemOwnId);
        return query.list();
    }

}
