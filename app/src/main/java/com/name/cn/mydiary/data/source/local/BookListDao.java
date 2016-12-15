package com.name.cn.mydiary.data.source.local;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.name.cn.mydiary.data.BookList;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BOOK_LIST".
*/
public class BookListDao extends AbstractDao<BookList, Long> {

    public static final String TABLENAME = "BOOK_LIST";

    /**
     * Properties of entity BookList.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property MemorandumOwnerId = new Property(1, Long.class, "memorandumOwnerId", false, "MEMORANDUM_OWNER_ID");
        public final static Property DiaryOwnerId = new Property(2, Long.class, "diaryOwnerId", false, "DIARY_OWNER_ID");
    }

    private DaoSession daoSession;


    public BookListDao(DaoConfig config) {
        super(config);
    }
    
    public BookListDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BOOK_LIST\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"MEMORANDUM_OWNER_ID\" INTEGER," + // 1: memorandumOwnerId
                "\"DIARY_OWNER_ID\" INTEGER);"); // 2: diaryOwnerId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BOOK_LIST\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BookList entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long memorandumOwnerId = entity.getMemorandumOwnerId();
        if (memorandumOwnerId != null) {
            stmt.bindLong(2, memorandumOwnerId);
        }
 
        Long diaryOwnerId = entity.getDiaryOwnerId();
        if (diaryOwnerId != null) {
            stmt.bindLong(3, diaryOwnerId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BookList entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long memorandumOwnerId = entity.getMemorandumOwnerId();
        if (memorandumOwnerId != null) {
            stmt.bindLong(2, memorandumOwnerId);
        }
 
        Long diaryOwnerId = entity.getDiaryOwnerId();
        if (diaryOwnerId != null) {
            stmt.bindLong(3, diaryOwnerId);
        }
    }

    @Override
    protected final void attachEntity(BookList entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public BookList readEntity(Cursor cursor, int offset) {
        BookList entity = new BookList( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // memorandumOwnerId
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // diaryOwnerId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BookList entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setMemorandumOwnerId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setDiaryOwnerId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BookList entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BookList entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BookList entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
