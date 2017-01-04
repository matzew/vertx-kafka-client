package io.vertx.kafka.client.serialization;

import io.vertx.core.buffer.Buffer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class BufferSerializer implements Serializer<Buffer> {

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
  }

  @Override
  public byte[] serialize(String topic, Buffer data) {
    if (data == null)
      return null;

    return data.getBytes();
  }

  @Override
  public void close() {
  }
}
