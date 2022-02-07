import github.nooblong.auth.AuthProto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAuth {

    @Test
    public void testAuth() throws Exception{
        AuthProto.LoginReq req = createSubscribeReq();
        System.out.println("b e : " + req.toString());
        AuthProto.LoginReq req2 = decode(encode(req));
        System.out.println("a d : " + req2.toString());
        System.out.println("e q : " + req2.equals(req));
    }

    private static byte[] encode(AuthProto.LoginReq req){
        return req.toByteArray();
    }

    private static AuthProto.LoginReq decode(byte[] body) throws Exception{
        return AuthProto.LoginReq.parseFrom(body);
    }

    private static AuthProto.LoginReq createSubscribeReq(){
        AuthProto.LoginReq.Builder builder = AuthProto.LoginReq.newBuilder();
        builder.setUserName("liHua");
        return builder.build();
    }

}
