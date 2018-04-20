package netty.demoChat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by joybar on 2018/4/19.
 */
public class ChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext arg0, String arg1)
            throws Exception {
        System.out.println(arg1);
    }

}
