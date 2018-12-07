package com.iamdeejay.penit.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PenDAO {

    /**
     * Select all Entry from the PenEntry table.
     *
     * @return all entry.
     */
    @Query("SELECT * FROM penEntry")
    LiveData<List<PenEntry>> loadAllEntry();

    /**
     * Insert a new PenEntry
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEntry(PenEntry penEntry);

    @Update()
    void updateEntry(PenEntry penEntry);

    @Delete()
    void deleteEntry(PenEntry penEntry);

}
