package com.hfad.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
    

    public void onSendMessage(View view) {
        EditText search = (EditText)findViewById(R.id.searcher);
        RadioGroup radioLimit = (RadioGroup) findViewById(R.id.radioLimit);

        Integer selectedId = radioLimit.getCheckedRadioButtonId();

        RadioButton radioLimitValue = (RadioButton) findViewById(selectedId);

        StringBuilder messageText = new StringBuilder();

        messageText.append(search.getText().toString() + "-*-" + radioLimitValue.getText().toString());

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, messageText.toString());
        startActivity(intent);
    }
}
