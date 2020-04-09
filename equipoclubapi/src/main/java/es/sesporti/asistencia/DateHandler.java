package es.sesporti.asistencia;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateHandler extends StdDeserializer<Date>{

	public DateHandler() {
		this(null);
	}
	
	public DateHandler(Class<?> vc) {
		super(vc);
	}

	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = p.getText();
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			return df.parse(date);
		} catch (Exception e) {
			return null;
		}
		
	}

	
}
