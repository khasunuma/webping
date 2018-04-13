package jp.coppermine.gadget.webping;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ping")
public class PingResource {

    @GET
    public String pong() {
        String host = "uninitialized";
        String addr = "uninitialized";
        try {
            host = InetAddress.getLocalHost().getHostName();
            addr = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            host = "unknown";
            addr = "unknown";
        }
        
        String html = "<!DOCTYPE html>\n"
                + "<html lang=\"ja\">\n"
                + "<head>\n"
                + "<title>Web ping</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>" + String.format("Pong from %s (%s)", host, addr) + "</h1>\n"
                + "</body>\n"
                + "</html>";
        
        return html;
    }
    
}
