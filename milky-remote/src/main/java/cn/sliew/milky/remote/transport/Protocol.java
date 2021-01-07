package cn.sliew.milky.remote.transport;

public interface Protocol<T extends TcpChannel> {

    /**
     * Get the newEncoder for the protocol.
     */
    OutboundEncoder<T> getEncoder();

    /**
     * Get the decoder for the protocol.
     */
    InboundDecoder<T> getDecoder();
}