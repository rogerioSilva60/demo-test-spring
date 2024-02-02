package br.com.exemplo.demo.config;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import feign.Util;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

public class ClientSOAPConfig {

  private final ObjectFactory<HttpMessageConverters> messageConverters;

  public ClientSOAPConfig(ObjectFactory<HttpMessageConverters> messageConverters) {
    this.messageConverters = messageConverters;
  }

  @Bean
  Encoder feignEncoder() {
    return new SpringEncoder(messageConverters);
  }

  @Bean
  Decoder feignDecoder() {
    return (response, type) -> {
        String bodyStr = Util.toString(response.body().asReader(Util.UTF_8));
        JavaType javaType = TypeFactory.defaultInstance().constructType(type);
        try {
          return new XmlMapper().readValue(bodyStr, javaType);
        } catch (Exception e) {
          throw e;
        }
      };
  }

}
