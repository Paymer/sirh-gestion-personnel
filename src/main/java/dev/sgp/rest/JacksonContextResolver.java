package dev.sgp.rest;


	import com.fasterxml.jackson.databind.ObjectMapper;
	import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

	import javax.ws.rs.Produces;
	import javax.ws.rs.core.MediaType;
	import javax.ws.rs.ext.ContextResolver;
	import javax.ws.rs.ext.Provider;

	import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;

	@Provider
	@Produces(MediaType.APPLICATION_JSON)
	public class JacksonContextResolver implements ContextResolver<ObjectMapper> {
		private static final ObjectMapper om = init();

		@Override
		public ObjectMapper getContext(Class<?> objectType) {
			return om;
		}

		private static ObjectMapper init() {
			ObjectMapper om = new ObjectMapper();
			om.registerModule(new JavaTimeModule());
			om.configure(WRITE_DATES_AS_TIMESTAMPS, false);
			return om;
		}
	}
	

