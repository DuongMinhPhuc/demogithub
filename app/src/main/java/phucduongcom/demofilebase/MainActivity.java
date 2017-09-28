package phucduongcom.demofilebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import phucduongcom.demofilebase.model.Contents;

public class MainActivity extends AppCompatActivity {
   private ArrayList<Contents> listConten = new ArrayList<Contents>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        connect database
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
//        find note
        DatabaseReference databaseReference=firebaseDatabase.getReference("content");
//        databaseReference.setValue("hue");
//       read data
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                String str=dataSnapshot.getValue(String.class);
//                TextView text=(TextView) findViewById(R.id.text);
//                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
//                text.setText(str);
                for (DataSnapshot child: dataSnapshot.getChildren()) {
                    Contents content=child.getValue(Contents.class);
                    listConten.add(content);
                    System.out.println(content.getDescription());
                    System.out.println(content.getTitle());
                    System.out.println(content.getImage());


                }
                System.out.println(listConten.size());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Log.w("aaaa", "Failed to read value.", error.toException());
                Toast.makeText(MainActivity.this, "faild", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
