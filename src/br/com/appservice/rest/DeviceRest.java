package br.com.appservice.rest;

import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

import br.com.appservice.facade.DeviceServiceFacade;
import br.com.appservice.model.Device;
import br.com.appservice.model.Devices;

@Component("deviceRest")
@Service("deviceRest")
public class DeviceRest {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceRest.class);

	@Autowired
	private DeviceServiceFacade deviceServiceFacade;

	@POST
	@Path("/claro/mobile")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response save(@QueryParam("model") String model, @QueryParam("price") String price,
			@QueryParam("brand") String brand, @QueryParam("photo") String photo, @QueryParam("date") String date) {

		XStream xStream = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String msg = null;
		String json = null;
		String excessao = null;
		Device d = new Device();
		try {

			// verifica se a variavel nao foi preenchida
			if (("".equals(model)) || (model == null)) {
				msg = "informe model.";
				xStream.alias("device", Device.class);
				d.setError(msg);
				json = xStream.toXML(d);
				return Response.status(Status.NOT_FOUND).entity(json).type(MediaType.APPLICATION_JSON).build();
			}

			// verifica se a variavel nao foi preenchida
			if ("".equals(price) || (price == null)) {
				msg = "informe price.";
				xStream.alias("device", Device.class);
				d.setError(msg);
				json = xStream.toXML(d);
				return Response.status(Status.NOT_FOUND).entity(json).type(MediaType.APPLICATION_JSON).build();
			}

			// verifica se a variavel nao foi preenchida
			if ("".equals(brand) || (brand == null)) {
				msg = "informe brand.";
				xStream.alias("device", Device.class);
				d.setError(msg);
				json = xStream.toXML(d);
				return Response.status(Status.NOT_FOUND).entity(json).type(MediaType.APPLICATION_JSON).build();
			}

			// verifica se a variavel nao foi preenchida
			if ("".equals(photo) || (photo == null)) {
				msg = "informe photo.";
				xStream.alias("device", Device.class);
				d.setError(msg);
				json = xStream.toXML(d);
				return Response.status(Status.NOT_FOUND).entity(json).type(MediaType.APPLICATION_JSON).build();
			}

			// verifica se a variavel nao foi preenchida
			if ("".equals(date) || (date == null)) {
				msg = "informe date.";
				xStream.alias("device", Device.class);
				d.setError(msg);
				json = xStream.toXML(d);
				return Response.status(Status.NOT_FOUND).entity(json).type(MediaType.APPLICATION_JSON).build();
			}

			d = this.deviceServiceFacade.createObject(brand, model, Integer.parseInt(price), photo, date);
			this.deviceServiceFacade.save(d);
			d.setSucesso("device inserido com sucesso!!!!!");

		} catch (Exception e) {
			LOGGER.error(" Erro ao cadastrar o device " + e.getMessage());
			excessao = " Erro ao cadastrar o device ";
			d.setExcessao(excessao);
			xStream.alias("device", Device.class);
			json = xStream.toXML(d);
			return Response.status(Status.BAD_REQUEST).entity(json).type(MediaType.APPLICATION_JSON).build();
		}

		return Response.status(Status.OK).entity(d).type(MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Path("/claro/mobile/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findById(@PathParam("id") String id) {

		XStream xStream = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String msg = null;
		String json = null;
		String excessao = null;
		Device d = new Device();
		try {
			
			d = this.deviceServiceFacade.findById(Long.parseLong(id));

		} catch (Exception e) {
			LOGGER.error(" Erro ao recuperar o device " + e.getMessage());
			excessao = " Erro ao recuperar o device ";
			d.setExcessao(excessao);
			xStream.alias("device", Device.class);
			json = xStream.toXML(d);
			return Response.status(Status.BAD_REQUEST).entity(json).type(MediaType.APPLICATION_JSON).build();
		}

		return Response.status(Status.OK).entity(d).type(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/claro/mobile")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {

		XStream xStream = new XStream(new JsonHierarchicalStreamDriver() {
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}
		});
		xStream.setMode(XStream.NO_REFERENCES);
		String json = null;
		String excessao = null;
		Device d = new Device();
		Devices devices = new Devices();
		List<Device> ds = new ArrayList<Device>();

		try {

			ds = this.deviceServiceFacade.findAll();
			devices.setDevices(ds);

		} catch (Exception e) {

			LOGGER.error(" Erro ao recuperar os devices " + e.getMessage());
			excessao = " Erro ao recuperar os devices ";
			d.setExcessao(excessao);
			xStream.alias("device", Device.class);
			json = xStream.toXML(d);
			return Response.status(Status.BAD_REQUEST).entity(json).type(MediaType.APPLICATION_JSON).build();
		}

		return Response.status(Status.OK).entity(devices).type(MediaType.APPLICATION_JSON).build();
	}

	@WebMethod(exclude = true)
	public void setDeviceServiceFacade(DeviceServiceFacade deviceServiceFacade) {
		this.deviceServiceFacade = deviceServiceFacade;
	}

}
