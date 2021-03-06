package com.name.cn.mydiary.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.name.cn.mydiary.data.bookdetail.Journal;
import com.name.cn.mydiary.data.source.JournalDataSource;
import com.name.cn.mydiary.data.source.local.dao.JournalDao;
import com.name.cn.mydiary.util.database.GreenDaoManager;
import com.name.cn.mydiary.util.schedulers.BaseSchedulerProvider;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Concrete implementation of a data source as a db.
 * Created by Administrator on 2016-12-11.
 */

public class JournalLocalDataSource implements JournalDataSource {

    @Nullable
    private static JournalLocalDataSource INSTANCE;

    @NonNull
    private JournalDao dao;

    public static JournalLocalDataSource getInstance(
            @NonNull Context context,
            @NonNull BaseSchedulerProvider schedulerProvider) {
        if (INSTANCE == null) {
            INSTANCE = new JournalLocalDataSource(context, schedulerProvider);
        }
        return INSTANCE;
    }


    // Prevent direct instantiation.
    private JournalLocalDataSource(@NonNull Context context,
                                   @NonNull BaseSchedulerProvider schedulerProvider) {
        checkNotNull(context, "context cannot be null");
        checkNotNull(schedulerProvider, "scheduleProvider cannot be null");
        dao = GreenDaoManager.getInstance().getmDaoSession().getJournalDao();
    }

    @Override
    public Observable<List<Journal>> getAllJournals() {
        return Observable.just(dao.loadAll());
    }

    @Override
    public Observable<List<Journal>> getJournals(@NonNull String bookId) {
        return Observable.just(dao.queryBuilder().where(JournalDao.Properties.BookId.eq(Long.valueOf(bookId))).orderAsc(JournalDao.Properties.CreateTime).list());
    }

    @Override
    public Observable<Journal> getJournal(@NonNull final String journalId) {

        return Observable.fromCallable(new Callable<Journal>() {
            @Override
            public Journal call() throws Exception {
                return dao.load(Long.valueOf(journalId));
            }
        });
    }

    @Override
    public void saveJournal(@NonNull Journal journal) {
        checkNotNull(journal);
        dao.save(journal);
    }

    @Override
    public void refreshJournals() {
        //null
    }

    @Override
    public void deleteAllJournals() {
        dao.deleteAll();
    }

    @Override
    public void deleteJournal(@NonNull String journalId) {
        dao.deleteByKey(Long.valueOf(journalId));
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
