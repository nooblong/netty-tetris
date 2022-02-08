package github.nooblong;

import github.nooblong.auth.AuthProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SubReqServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        AuthProto.LoginReq req = (AuthProto.LoginReq) msg;
        if ("Lixinying".equalsIgnoreCase(req.getUserName())){
            System.out.println("accept client : [" + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getUserName()));
        }
    }

    private AuthProto.CommonResp resp(String username) {
        AuthProto.CommonResp.Builder builder = AuthProto.CommonResp.newBuilder();
        builder.setMsg("resp");
        return builder.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
