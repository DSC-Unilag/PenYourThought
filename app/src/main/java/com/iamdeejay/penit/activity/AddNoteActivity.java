package com.iamdeejay.penit.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.iamdeejay.penit.R;
import com.iamdeejay.penit.model.PenEntry;
import com.iamdeejay.penit.model.PenRepository;

public class AddNoteActivity extends AppCompatActivity {

    //Declare Variables and field
    private EditText entryTitle;
    private EditText entryContent;
    private PenRepository mRepository;
    final PenEntry penEntry = new PenEntry();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //Initialize variables
        entryTitle = findViewById(R.id.title);
        entryContent = findViewById(R.id.content);

        //Setup the Repository class
        mRepository = PenRepository.getInstance(this);
    }

    //Save Pen Entry
    private void saveEntry(){

        final String title = entryTitle.getText().toString().trim();
        final String content = entryContent.getText().toString().trim();

        if (title.isEmpty() && content.isEmpty()|| title.isEmpty()){
            entryTitle.setError("Title is require");
            entryContent.setError("Add some note");
        } else {
            penEntry.setTitle(title);
            penEntry.setContent(content);
            mRepository.insertPenEntry(penEntry);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_pen_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                saveEntry();
                Toast.makeText(this, "Your entry was saved successfully", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.delete:
                Intent home = new Intent(this, NoteActivity.class);
                startActivity(home);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
