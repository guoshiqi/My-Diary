package com.name.cn.mydiary.data.source.local.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.name.cn.mydiary.data.bookdetail.Journal;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "JOURNAL".
*/
public class JournalDao extends AbstractDao<Journal, Long> {

    public static final String TABLENAME = "JOURNAL";

    /**
     * Properties of entity Journal.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property BookId = new Property(1, Long.class, "bookId", false, "BOOK_ID");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property CreateTime = new Property(3, java.util.Date.class, "createTime", false, "CREATE_TIME");
    }


    public JournalDao(DaoConfig config) {
        super(config);
    }
    
    public JournalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"JOURNAL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"BOOK_ID\" INTEGER NOT NULL ," + // 1: bookId
                "\"NAME\" TEXT NOT NULL ," + // 2: name
                "\"CREATE_TIME\" INTEGER NOT NULL );"); // 3: createTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"JOURNAL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Journal entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getBookId());
        stmt.bindString(3, entity.getName());
        stmt.bindLong(4, entity.getCreateTime().getTime());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Journal entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getBookId());
        stmt.bindString(3, entity.getName());
        stmt.bindLong(4, entity.getCreateTime().getTime());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Journal readEntity(Cursor cursor, int offset) {
        Journal entity = new Journal( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getLong(offset + 1), // bookId
            cursor.getString(offset + 2), // name
            new java.util.Date(cursor.getLong(offset + 3)) // createTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Journal entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBookId(cursor.getLong(offset + 1));
        entity.setName(cursor.getString(offset + 2));
        entity.setCreateTime(new java.util.Date(cursor.getLong(offset + 3)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Journal entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Journal entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Journal entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
