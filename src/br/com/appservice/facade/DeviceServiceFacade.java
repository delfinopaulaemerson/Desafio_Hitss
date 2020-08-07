package br.com.appservice.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.appservice.model.Device;

@Component("deviceServiceFacade")
public interface DeviceServiceFacade {
	
	/**
	 * restorna uma lista de device
	 * @return List<Device>
	 */
	public List<Device> findAll() throws Exception;
	
	
	/**
	 * retorna o device pelo seu identificador
	 * @return Device
	 */
	public Device findById(Long id) throws Exception;
	
	/**
	 * 
	 * @param device
	 */
	public void save(Device device) throws Exception;

	/**
	 * encapsula os valores ao objeto device
	 * @param brand
	 * @param model
	 * @param price
	 * @param photo
	 * @param date
	 * @return Device
	 */
	public Device createObject(String brand, String model, Integer price, String photo, String date);
	
}
