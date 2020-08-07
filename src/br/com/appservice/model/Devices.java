package br.com.appservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Devices implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4991815652377667238L;
	
	private Collection<Device> devices = new ArrayList<Device>();

	public Collection<Device> getDevices() {
		return devices;
	}

	public void setDevices(Collection<Device> devices) {
		this.devices = devices;
	}
	
	
	
	

}
