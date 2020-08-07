package br.com.appservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "device")
@XmlRootElement
public class Device implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5850192174136640338L;
	
	@Id
	@SequenceGenerator(name="SEQ_USER", sequenceName="SEQ_USER", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_USER")
	private Long id;
	
	@Column(name="model")
	private String model;
	
	@Column(name="price")
	private Integer price;
	
	@Column(name="brand")
	private String brand;
	
	@Column(name="photo")
	private String photo;
	
	@Column(name="date")
	private String date;
	
	@Column(name="code")
	private String code;
	
	@Transient
	private String sucesso;
	
	@Transient
	private String error;
	
	@Transient
	private String excessao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSucesso() {
		return sucesso;
	}

	public void setSucesso(String sucesso) {
		this.sucesso = sucesso;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getExcessao() {
		return excessao;
	}

	public void setExcessao(String excessao) {
		this.excessao = excessao;
	}
	
}
