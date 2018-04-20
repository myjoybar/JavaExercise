package netty.demoChat.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by joybar on 2018/4/19.
 */
public class ServerIniterHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel arg0) throws Exception {
        ChannelPipeline pipeline = arg0.pipeline();
        pipeline.addLast("docode", new StringDecoder());
        pipeline.addLast("encode", new StringEncoder());
        pipeline.addLast("chat", new ChatServerHandler());

    }
}
