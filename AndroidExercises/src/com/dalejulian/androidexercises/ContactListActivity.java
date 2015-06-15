package com.dalejulian.androidexercises;

import java.util.ArrayList;
import java.util.HashMap;
 
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
 
public class ContactListActivity extends ListActivity {
 
    private ProgressDialog pDialog;
 
    // URL to get contacts JSON
    private static String url = "http://api.androidhive.info/contacts/";
    //private static String url = "http://graph.facebook.com/zuck";
    
    private static String[] url_Data = {
    	"http://graph.facebook.com/zuck",
    	"http://graph.facebook.com/dalejulian",
    };
    
    // JSON Node names
    private static final String TAG_CONTACTS = "contacts";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_EMAIL = "link";
    private static final String TAG_ADDRESS = "address";
    private static final String TAG_GENDER = "gender";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_PHONE_MOBILE = "mobile";
    private static final String TAG_PHONE_HOME = "home";
    private static final String TAG_PHONE_OFFICE = "office";
 
    // contacts JSONArray
    JSONArray contacts = null;
 
    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_activity);
 
        contactList = new ArrayList<HashMap<String, String>>();
 
        ListView lv = getListView();
 
        // Listview on item click listener
        lv.setOnItemClickListener(new OnItemClickListener() {
 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                // getting values from selected ListItem
                String name = ((TextView) view.findViewById(R.id.contact_name_textView))
                        .getText().toString();
                String cost = ((TextView) view.findViewById(R.id.contact_email_textView))
                        .getText().toString();
                String description = ((TextView) view.findViewById(R.id.contact_mobile_textView))
                        .getText().toString();
 
            }
        });
 
        // Calling async task to get json
        new GetContacts().execute();
    }
 
    /**
     * Async task class to get json by making HTTP call
     * */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
 
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(ContactListActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
 
        }
 
        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();
 
            // Making a request to url and getting response
//            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);
            
            try {
				contacts = new JSONArray("contacts");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            for(String string : url_Data){
            	String jsonStr = sh.makeServiceCall(string, ServiceHandler.GET);
            	
            	Log.d("Response: ", "> " + jsonStr);
            	 
                if (jsonStr != null) {
                    try {
                    	
                        JSONObject jsonObj = new JSONObject(jsonStr);
                         
                        // Getting JSON Array node
                        //contacts = jsonObj.getJSONArray("contacts");
                        
                        contacts.put(jsonObj);
     
                        // looping through All Contacts
                        for (int i = 0; i < contacts.length(); i++) {
                            JSONObject c = contacts.getJSONObject(i);
                             
                            String id = c.getString(TAG_ID);
                            String name = c.getString(TAG_NAME);
                            String email = c.getString(TAG_EMAIL);
                            String address = c.getString(TAG_ADDRESS);
                            String gender = c.getString(TAG_GENDER);
     
                            // Phone node is JSON Object
                            JSONObject phone = c.getJSONObject(TAG_PHONE);
                            String mobile = phone.getString(TAG_PHONE_MOBILE);
                            String home = phone.getString(TAG_PHONE_HOME);
                            String office = phone.getString(TAG_PHONE_OFFICE);
     
                            // tmp hashmap for single contact
                            HashMap<String, String> contact = new HashMap<String, String>();
     
                            // adding each child node to HashMap key => value
                            contact.put(TAG_ID, id);
                            contact.put(TAG_NAME, name);
                            contact.put(TAG_EMAIL, email);
                            contact.put(TAG_PHONE_MOBILE, mobile);
     
                            // adding contact to contact list
                            contactList.add(contact);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("ServiceHandler", "Couldn't get any data from the url");
                }
            }
 
            return null;
        }
 
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    ContactListActivity.this, contactList,
                    R.layout.contact_list_item, new String[] { TAG_NAME, TAG_EMAIL,
                            TAG_PHONE_MOBILE }, new int[] { R.id.contact_name_textView,
                            R.id.contact_email_textView, R.id.contact_mobile_textView});
 
            setListAdapter(adapter);
        }
 
    }
 
}