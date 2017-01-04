package io.vertx.kafka.client.serialization;

import io.vertx.core.buffer.Buffer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

/**
 * @author <a href="mailto:matzew@apache.org">Matthias Wessendorf</a>
 */
public class VertxSerdes extends Serdes {

  /*
 * A serde for nullable {@code Buffer} type.
 */
  static public Serde<Buffer> Buffer() {
    return new BufferSerde();
  }


  static public final class BufferSerde extends WrapperSerde<Buffer> {
    public BufferSerde() {
      super(new BufferSerializer(), new BufferDeserializer());
    }
  }

  static public <T> Serde<T> serdeFrom(Class<T> type) {
    if (Buffer.class.isAssignableFrom(type)) {
      return (Serde<T>) Buffer();
    }

    // delegate to look up default Kafka SerDes:
    return Serdes.serdeFrom(type);
  }


}
