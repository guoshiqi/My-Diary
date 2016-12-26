package com.name.cn.mydiary.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.name.cn.mydiary.data.Config;
import com.name.cn.mydiary.data.User;

import rx.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * cache for User And Config
 * Created by guoshiqi on 2016/12/26.
 */

public class UserRepository implements UserDataSource {

    @Nullable
    private static UserRepository INSTANCE = null;

    @NonNull
    private final UserDataSource mUserLocalDataSource;

    private User mUser;

    private Config mConfig;

    private UserRepository(@NonNull UserDataSource userLocalDataSource) {

        mUserLocalDataSource = checkNotNull(userLocalDataSource);
    }

    /**
     * Returns the single instance of this class, creating it if necessary.
     *
     * @param userLocalDataSource the device storage data source
     * @return the {@link UserRepository} instance
     */
    public static UserRepository getInstance(@NonNull UserDataSource userLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(userLocalDataSource);
        }
        return INSTANCE;
    }

    /**
     * Used to force {@link #getInstance(UserDataSource)} to create a new instance
     * next time it's called.
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public Observable<User> getUser(Long Id) {
        checkNotNull(Id);
        //return cache
        if (mUser != null) {
            return Observable.just(mUser);
        }
        //return local
        return getUserWithId(Id);
    }

    @Override
    public Observable<Config> getConfig(Long Id) {
        checkNotNull(Id);
        if (mConfig != null) {
            return Observable.just(mConfig);
        }
        return getConfigWithUserId(Id);
    }

    @Override
    public void saveUser(User user) {
        checkNotNull(user);
        mUser = user;
        mUserLocalDataSource.saveUser(user);
    }

    @Override
    public void saveConfig(Config config) {
        checkNotNull(config);
        mConfig = config;
        mUserLocalDataSource.saveConfig(config);
    }

    @Override
    public void deleteAllUser() {
        mUser = null;
        mUserLocalDataSource.deleteAllUser();
    }

    @Override
    public void deleteAllConfig() {
        mConfig = null;
        mUserLocalDataSource.deleteAllConfig();
    }

    @Override
    public void deleteUser(Long Id) {
        checkNotNull(Id);
        mUser = null;
        mUserLocalDataSource.deleteUser(Id);
    }

    @Override
    public void deleteConfig(Long Id) {
        checkNotNull(Id);
        mConfig = null;
        mUserLocalDataSource.deleteConfig(Id);
    }


    private Observable<User> getUserWithId(Long Id) {
        return mUserLocalDataSource
                .getUser(Id)
                .doOnNext(user -> mUser = user)
                .first();
    }

    private Observable<Config> getConfigWithUserId(Long Id) {
        return mUserLocalDataSource
                .getConfig(Id)
                .doOnNext(config -> mConfig = config)
                .first();
    }
}
