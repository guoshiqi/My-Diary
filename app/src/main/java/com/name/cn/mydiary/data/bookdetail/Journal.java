package com.name.cn.mydiary.data.bookdetail;

import com.google.common.base.Objects;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * 日记
 * Created by guoshiqi on 2016/12/9.
 */

@Entity
public class Journal {


    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private Long journalOwnId;

    @NotNull
    private String name;

    @Generated(hash = 1133720453)
    public Journal(Long id, @NotNull Long journalOwnId, @NotNull String name) {
        this.id = id;
        this.journalOwnId = journalOwnId;
        this.name = name;
    }

    @Generated(hash = 1562390721)
    public Journal() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getJournalOwnId() {
        return this.journalOwnId;
    }

    public void setJournalOwnId(Long journalOwnId) {
        this.journalOwnId = journalOwnId;
    }

    @Keep
    public String getStringId() {
        return id.toString();
    }

    @Keep
    public String getStringJournalOwnId() {
        return getId().toString();
    }

    @Keep
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Journal needCompare = (Journal) obj;
        return Objects.equal(id, needCompare.id) && Objects.equal(journalOwnId, needCompare.journalOwnId)
                && Objects.equal(name, needCompare.name);

    }
}
