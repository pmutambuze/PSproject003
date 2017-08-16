package com.example.bifam.practice;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class PostPro extends Activity {
    Spinner spinner;
    Button btn, submit;
    private static final int CAMERA_REQUEST = 123;
    ImageView imageView;
    Button viewposts;
    DatabaseHandler db;

    static EditText pcontact, ppostname, pfeatureone, pfeaturetwo, pfeaturethree, pdescription;
    static String Contact, PostName, FeatureOne, FeatureTwo, FeatureThree, Description;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_pro);

        spinner = (Spinner) findViewById(R.id.category);
        String[] categories = {"Vegetables e.g. Spinach and Greens", "Fruits e.g. Mangoes and Oranges", "Animals/Products e.g. Milk", "Legumes e.g. Cassava and Potatoes", "Cereal e.g. Maize", "Fish", "Others"};
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categories);
        spinner.setAdapter(adapter);

        btn = (Button) findViewById(R.id.button8);
        viewposts = (Button) findViewById(R.id.button9);
        imageView = (ImageView) findViewById(R.id.idImageView);
        submit = (Button) findViewById(R.id.post);

        db = new DatabaseHandler(this);

        pcontact = (EditText) findViewById(R.id.contact);
        ppostname = (EditText) findViewById(R.id.postname);
        pfeatureone = (EditText) findViewById(R.id.featureone);
        pfeaturetwo = (EditText) findViewById(R.id.featuretwo);
        pfeaturethree = (EditText) findViewById(R.id.featurethree);
        pdescription = (EditText) findViewById(R.id.description);


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Contact = pcontact.getText().toString();
                PostName = ppostname.getText().toString();
                FeatureOne = pfeatureone.getText().toString();
                FeatureTwo = pfeaturetwo.getText().toString();
                FeatureThree = pfeaturethree.getText().toString();
                Description = pdescription.getText().toString();

                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addPost(new Post(Contact, PostName, FeatureOne, FeatureTwo, FeatureThree, Description));
                pcontact.setText("");
                ppostname.setText("");
                pfeatureone.setText("");
                pfeaturetwo.setText("");
                pfeaturethree.setText("");
                pdescription.setText("");
            }
        });

        viewposts.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent viewlist = new Intent(PostPro.this, PostList.class);
                PostPro.this.startActivity(viewlist);
                //finish();

            }
        });

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Post> post = db.getAllPosts();

        for (Post cn : post) {
            String log = "Id: " + cn.get_id() + " ,Contact: " + cn.get_phonenumber() + " ,PostName: " + cn.get_postname() + " ,FeatureOne: " + cn.get_featureone() + " ,FeatureTwo: " + cn.get_featuretwo() + " ,FeatureThree: " + cn.get_featurethree() + " ,Description: " + cn.get_description();
            // Writing Contacts to log
            Log.d("Contact: ", log);

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void btnClick(View v) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {

            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("PostPro Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}