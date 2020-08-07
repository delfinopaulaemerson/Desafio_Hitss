package br.com.appservice.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.appservice.model.Device;

@Component("deviceDao")
public interface DeviceDao {

	/**
	 * restorna uma lista de device
	 * 
	 * @return List<Device>
	 */
	public List<Device> findAll() throws Exception;

	/**
	 * retorna o device pelo seu identificador
	 * 
	 * @return Device
	 */
	public Device findById(Long id) throws Exception;

	/**
	 * 
	 * @param device
	 */
	public void save(Device device) throws Exception;

}
