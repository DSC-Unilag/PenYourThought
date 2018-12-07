package com.iamdeejay.penit.activity;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.iamdeejay.penit.model.PenEntry;
import com.iamdeejay.penit.model.PenRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private PenRepository mRepository;
    private LiveData<List<PenEntry>> allPenEntry;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        mRepository = PenRepository.getInstance(application.getApplicationContext());
    }

    public LiveData<List<PenEntry>> getAllPenEntry() {
        return allPenEntry;
    }

    public void insert(PenEntry penEntry) {
        mRepository.insertPenEntry(penEntry);
    }
}
