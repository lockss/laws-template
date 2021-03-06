package org.lockss.laaws.template.api;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;

@Provider
public class OffsetDateTimeProvider implements ParamConverterProvider {

  @Override
  public <T> ParamConverter<T> getConverter(Class<T> type, Type type1, Annotation[] antns) {
    if (OffsetDateTime.class.equals(type)) {
      return (ParamConverter<T>) new OffsetDateTimeConverter();
    }
    return null;
  }

  public static class OffsetDateTimeConverter implements ParamConverter<OffsetDateTime> {

    @Override
    public OffsetDateTime fromString(String string) {
      OffsetDateTime offsetDateTime = OffsetDateTime.parse(string);
      return offsetDateTime;
    }

    @Override
    public String toString(OffsetDateTime t) {
      return t.toString();
    }
  }
}
