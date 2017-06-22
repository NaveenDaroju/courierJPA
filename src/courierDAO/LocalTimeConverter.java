package courierDAO;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.time.LocalTime;

import java.time.ZoneId;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//public class LocalTimeConverter {
//		@Converter(autoApply = true)
//	public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {
//
//	@Override
//	public Time convertToDatabaseColumn(LocalTime time) {
//		Instant instant = 
//				time.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
//	return (Time)Time.from(instant);
//	}
//
//	@Override
//	public LocalTime convertToEntityAttribute(Time time) {
//	Instant instant = Instant.ofEpochMilli(time.getTime());
//	return LocalTimeTime.ofInstant(instant, ZoneId.systemDefault()).toLocalTime();
//	}
//		}
		
		
		@Converter(autoApply = true)
		public class LocalTimeConverter implements AttributeConverter<LocalTime, Timestamp> {
			
		    @Override
		    public Timestamp convertToDatabaseColumn(LocalTime locTime) {
		    	return (locTime == null ? null : Timestamp. valueOf(locTime.toString()));
		    }

		    @Override
		    public LocalTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		    	return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime().toLocalTime());
		    }
		}


