package netty.demoChat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by joybar on 2018/4/19.
 */
public class ClientIniter extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel arg0) throws Exception {
        ChannelPipeline pipeline = arg0.pipeline();
        pipeline.addLast("stringD", new StringDecoder());
        pipeline.addLast("stringC", new StringEncoder());
        pipeline.addLast("http", new HttpClientCodec());
        pipeline.addLast("chat", new ChatClientHandler());
    }

}

