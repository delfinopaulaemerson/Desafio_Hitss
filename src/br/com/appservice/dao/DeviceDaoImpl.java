package br.com.appservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.appservice.model.Device;

@Component("deviceDaoImpl")
public class DeviceDaoImpl implements DeviceDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public List<Device> findAll() throws Exception {
		Query query = null;
		
		query = this.entityManager.createQuery("FROM Device ORDER BY brand");
		
		return query.getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public Device findById(Long id) throws Exception {
		
		return this.entityManager.find(Device.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	@Override
	public void save(Device device) throws Exception {
		
		Device d  =  new Device();
		d.setBrand(device.getBrand());
		d.setModel(device.getModel());
		d.setPrice(device.getPrice());
		d.setDate(device.getDate());
		d.setPhoto(device.getPhoto());
		
		this.entityManager.persist(d);
		this.entityManager.flush();
		this.entityManager.clear();
		
	}

}
