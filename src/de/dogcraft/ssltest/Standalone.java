package de.dogcraft.ssltest;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import de.dogcraft.ssltest.service.Service;
import de.dogcraft.ssltest.service.TruststoreOverview;

public class Standalone {

    public static void main(String[] args) throws Exception {
        Server s = new Server(8080);
        ServletContextHandler sh = new ServletContextHandler();
        sh.addServlet(new ServletHolder(new TruststoreOverview()), "/trust");
        sh.addServlet(new ServletHolder(new Service()), "/*");
        s.setHandler(sh);
        s.start();
    }

}