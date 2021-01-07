package cn.sliew.milky.remote.transport;

import java.util.List;

public interface InboundDecoder<T extends TcpChannel> {

    /**
     * Decode bytes into object.
     *
     * @param channel
     * @param in bytes container
     * @param out
     */
    void decode(T channel, Object in, List<Object> out);
}