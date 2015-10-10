package com.dsquare;
public class CurrentState {

	private int id;
	private int deviceId;
	private int state;
	private int intensity;
	
	public CurrentState(int id, int deviceId, int state, int intensity) {
		super();
		this.id = id;
		this.deviceId = deviceId;
		this.state = state;
		this.intensity = intensity;
	}
	public CurrentState(int deviceId, int state, int intensity) {
		super();
		this.deviceId = deviceId;
		this.state = state;
		this.intensity = intensity;
	}
	public CurrentState() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getIntensity() {
		return intensity;
	}
	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	@Override
	public String toString() {
		/*return "CurrentState [id=" + id + ", deviceId=" + deviceId + ", state="
				+ state + ", intensity=" + intensity + "]";*/
		return "{\"id\" :\"" +  id + "\", \"state\" :\"" + state + "\", \"intensity\":\""
		+ intensity + "\"}";
	}
	public String toJSON() {
		return "{\"id\" :\"" + id + "\", \"state\" :\"" + state + "\", \"intensity\":\""
		+ intensity + "\"}";
	}
}
