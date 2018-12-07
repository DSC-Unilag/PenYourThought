package com.iamdeejay.penit.model;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.iamdeejay.penit.utils.AppExecutors;

import java.util.List;

public class PenRepository {

    private static PenRepository sInstance;
    private AppExecutors mAppExecutors;
    private PenDatabase penDatabase;

    private PenRepository(Context context) {
        penDatabase = PenDatabase.getInstance(context);
        mAppExecutors = new AppExecutors();
    }

    public static PenRepository getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PenRepository(context);
        }
        return sInstance;
    }

    public LiveData<List<PenEntry>> loadAllEntry() {
        return penDatabase.penDAO().loadAllEntry();
    }

    private void insert(final PenEntry penEntry) {
        mAppExecutors.mainThread().execute(new Runnable() {
            @Override
            public void run() {
                penDatabase.penDAO().insertEntry(penEntry);
            }
        });
    }

    public void insertPenEntry(PenEntry penEntry) {
        insert(penEntry);
    }
}
