package kr.anima.xd.s.sqlitecontacts;

import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View v){

        // 연락처(Contacts or People) 얻어오기

        // ContentResolver : 다른 Activity 의 db를 해독할 수 있는 유일한 객체
        // projection == columns
        Cursor cursor=getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if(cursor==null) return;

        StringBuffer buffer=new StringBuffer();
        while (cursor.moveToNext()){
            String name=cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            buffer.append("name : "+name);
        }


        Toast.makeText(this, cursor.getCount()+"EA", Toast.LENGTH_LONG).show();
    }

}
