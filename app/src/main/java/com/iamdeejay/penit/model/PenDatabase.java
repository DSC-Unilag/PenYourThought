package com.iamdeejay.penit.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {PenEntry.class}, version = 1)
public abstract class PenDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "penEntry";
    private static final Object lock = new Object();
    private static PenDatabase INSTANCE;

    public static PenDatabase getInstance(Context context) {
        synchronized (lock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        PenDatabase.class, PenDatabase.DATABASE_NAME)
                        .build();
            }
            return INSTANCE;
        }
    }

    public abstract PenDAO penDAO();


}
