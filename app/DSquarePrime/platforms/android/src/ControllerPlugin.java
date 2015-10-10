package com.dsquare;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.util.Log;
import android.provider.Settings;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ControllerPlugin extends CordovaPlugin {

	/**
	 * Constructor.
	 */
	public ControllerPlugin() {
	}

	/**
	 * Sets the context of the Command. This can then be used to do things like
	 * get file paths associated with the Activity.
	 * 
	 * @param cordova
	 *            The context of the main Activity.
	 * @param webView
	 *            The CordovaWebView Cordova is running in.
	 */
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}

	public boolean execute(final String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		/*final int duration = Toast.LENGTH_SHORT;
		cordova.getActivity().runOnUiThread(new Runnable() {
			public void run() {
				Toast toast = Toast.makeText(cordova.getActivity()
						.getApplicationContext(), action,
						duration);
				toast.show();
			}
		});*/
		/*if("showMessage".equals(action)){
			final String value1 = args.getString(0);
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ value1,
							duration);
					toast.show();
				}
			});
		}*/
		if("update".equals(action)){
			// Shows a toast
			final Integer value1 = args.getInt(0);
			final Integer value2 = args.getInt(1);
			final Integer value3 = args.getInt(2);
			final Integer value4 = args.getInt(3);
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ value4,
							duration);
					toast.show();
				}
			});*/
			
			final boolean reply = updateCurrentStateForDevice(value1, value2, value3);
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ value1 + " - " + value2 + " - " + value3+ " - "+reply,
							duration);
					toast.show();
				}
			});*/
		}
		else if("saveMood".equals(action)){
			final String moodJson = args.getString(0);
			final boolean reply = saveMood(moodJson);
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ moodJson + " - "+reply,
							duration);
					toast.show();
				}
			});*/
		}
		else if("allOff".equals(action)){
			final int count = args.getInt(0);
			final boolean reply = allOff(count);
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ moodJson + " - "+reply,
							duration);
					toast.show();
				}
			});*/
		}
		else if("reload".equals(action)){
			//final String moodJson = args.getString(0);
			final boolean reply = readCurrentState(callbackContext);
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ moodJson + " - "+reply,
							duration);
					toast.show();
				}
			});*/
		}
		else if("setMood".equals(action)){
			//final String moodJson = args.getString(0);
			final boolean reply = readPreferedState(callbackContext);
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), action + " - " 
					+ moodJson + " - "+reply,
							duration);
					toast.show();
				}
			});*/
		}
		//readCurrentState(callbackContext);
		

		/*
		 * DatabaseHandler db = new
		 * DatabaseHandler(cordova.getActivity().getApplicationContext());
		 * db.addContact(new Contact("Ravi", "9100000000")); db.addContact(new
		 * Contact("Srinivas", "9199999999")); db.addContact(new
		 * Contact("Tommy", "9522222222")); db.addContact(new Contact("Karthik",
		 * "9533333333")); List<Contact> contacts = db.getAllContacts(); final
		 * StringBuilder log = new StringBuilder(""); for (Contact cn :
		 * contacts) { log.append("Id: "+cn.getID()+" ,Name: " + cn.getName() +
		 * " ,Phone: " + cn.getPhoneNumber()); }
		 * cordova.getActivity().runOnUiThread(new Runnable() { public void
		 * run() { Toast toast =
		 * Toast.makeText(cordova.getActivity().getApplicationContext(),
		 * " contacts "+log.toString(), duration); toast.show(); } });
		 */
		return true;
	}
	private boolean allOff(int count) {
		final int duration = Toast.LENGTH_SHORT;
		try{
			
			DBHandler dbHandler = new DBHandler(cordova.getActivity()
					.getApplicationContext());
			final int rows = dbHandler.allOff(count);
			final String message = rows+"";
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), message,
							duration);
					toast.show();
				}
			});*/
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			/*final String message = "exc"+e.getMessage();
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), message,
							duration);
					toast.show();
				}
			});*/
			return false;
		}
	}
	private boolean saveMood(String moodJson) {
		final int duration = Toast.LENGTH_SHORT;
		try{
			DBHandler dbHandler = new DBHandler(cordova.getActivity()
					.getApplicationContext());
			JSONObject jsonObject = new JSONObject(moodJson);
			JSONObject innerJsonObject = null;
			int count = Integer.parseInt(jsonObject.get("count").toString());
			String message = "";
			CurrentState currentState = null;
			List<CurrentState> currentStates = new ArrayList<CurrentState>();
			for(int i = 1; i <= count;i++){
				message = jsonObject.get(i+"").toString();
				innerJsonObject =  new JSONObject(message);
				currentState = new CurrentState(i, Integer.parseInt(innerJsonObject.get("state").toString()),  
						 Integer.parseInt(innerJsonObject.get("intensity").toString()));
				currentStates.add(currentState);
			}
			dbHandler.savePreferedState(currentStates);
			
			/*final String messageStr = "data: "+dbHandler.getPreferedState().toString();
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), messageStr,
							duration);
					toast.show();
				}
			});*/
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			/*final String message = "exc"+e.getMessage();
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), message,
							duration);
					toast.show();
				}
			});*/
			return false;
		}
	}
	private boolean updateCurrentStateForDevice(int deviceId, int state,
			int intensity) {
		final int duration = Toast.LENGTH_SHORT;
		// check if bluetooth is available and can be device is paired with
		// controller
		// if yes {
		// check if there is entry in current_state table
		// if not, insert
		// if yes, update
		DBHandler dbHandler = new DBHandler(cordova.getActivity()
				.getApplicationContext());
		try {
			CurrentState currentState = dbHandler.getCurrentState(deviceId);
			if (currentState != null) {
				currentState.setState(state);
				currentState.setIntensity(intensity);
				dbHandler.updateCurrentState(currentState);
			} else {
				currentState = new CurrentState(deviceId, state, intensity);
				dbHandler.addCurrentState(currentState);
			}
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			/*final String message = e.getMessage();
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), message,
							duration);
					toast.show();
				}
			});*/
			return false;
		}
		// handle exception to return false
		// } bluetooth is available and device is paired to send data
		// else return false 
	}

	private boolean readCurrentState(CallbackContext callbackContext) {
		final int duration = Toast.LENGTH_SHORT;
		// get all records from current state table and provide the
		// JSON in callback function
		DBHandler dbHandler = new DBHandler(cordova.getActivity()
				.getApplicationContext());
		try {
			final List<CurrentState> currentStateList = dbHandler.getAllCurrentStates();
			boolean data = (currentStateList!=null&&currentStateList.size()>0)?true:false;
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), currentStateList.toString(),
							duration);
					toast.show();
				}
			});*/
			if(data==true){
				callbackContext.success(currentStateList.toString());
			}
			return true;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			/*final String message = e.getMessage();
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), message,
							duration);
					toast.show();
				}
			});*/
			return false;
		}
	}
	private boolean readPreferedState(CallbackContext callbackContext) {
		final int duration = Toast.LENGTH_SHORT;
		// get all records from current state table and provide the
		// JSON in callback function
		DBHandler dbHandler = new DBHandler(cordova.getActivity()
				.getApplicationContext());
		try {
			
			final List<CurrentState> preferedStateList = dbHandler.getPreferedState();
			boolean data = (preferedStateList!=null&&preferedStateList.size()>0)?true:false;
			/*cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), PreferedStateList.toString(),
							duration);
					toast.show();
				}
			});*/
			
			//call a callback funtion to send data to UI if needed
			if(data==true){
				callbackContext.success(preferedStateList.toString());
			}
			return true;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			/*final String message = e.getMessage();
			cordova.getActivity().runOnUiThread(new Runnable() {
				public void run() {
					Toast toast = Toast.makeText(cordova.getActivity()
							.getApplicationContext(), message,
							duration);
					toast.show();
				}
			});*/
			return false;
		}
	}
}
