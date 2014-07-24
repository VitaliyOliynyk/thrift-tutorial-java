package eu.vitaliy.thrifttutorial;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import thrifttutorial.KalkulatorService;

/**
 * Hello world!
 *
 */
public class App 
{

    public static final int PORT = 12345;

    public static void main( String[] args ) throws TTransportException {
        TServerSocket serverTransport = new TServerSocket(PORT);
        KalkulatorHandler kalkulatorHandler = new KalkulatorHandler();
        KalkulatorService.Processor<KalkulatorHandler> processor = new KalkulatorService.Processor<KalkulatorHandler>(kalkulatorHandler);
        TServer server = new TThreadPoolServer(
                new TThreadPoolServer.Args(serverTransport).processor(processor));
        System.out.println("Starting server on port "+PORT+" ...");
        server.serve();
    }
}
