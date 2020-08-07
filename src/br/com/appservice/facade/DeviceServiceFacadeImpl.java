package br.com.appservice.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.appservice.dao.DeviceDao;
import br.com.appservice.model.Device;

@Component("deviceServiceFacadeImpl")
public class DeviceServiceFacadeImpl implements DeviceServiceFacade{

	@Autowired
	private DeviceDao dao;
	
	//recupera uma lista de device
	@Override
	public List<Device> findAll() throws Exception {
		
		return this.dao.findAll();
	}

	//recupera o device com o seu identificador
	@Override
	public Device findById(Long id) throws Exception {
		
		return this.dao.findById(id);
	}

	//metodo para persistencia do device
	@Override
	public void save(Device device) throws Exception {
		
		this.dao.save(device);
	}

	//encapsula os valores ao objeto device
	@Override
	public Device createObject(String brand, String model, Integer price, String photo, String date) {
		Device d  = new Device();
		
		d.setBrand(brand);
		d.setModel(model);
		d.setPrice(price);
		d.setPhoto(photo);
		d.setDate(date);
		
		return d;
	}

}
