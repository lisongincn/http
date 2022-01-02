package impl;

import abstracts.InformationAbstract;
import interfaces.HttpInterface;

import java.io.*;
import java.net.Socket;

public class Http implements HttpInterface {
    @Override
    public InformationAbstract request(InformationAbstract information) throws IOException {
        String http = information.httpToString();
        InformationLineRequest informationLine = (InformationLineRequest) information.getInformationLine();
        String host = informationLine.getHost();
        int port = informationLine.getPort() == -1 ? 80 : informationLine.getPort();
        Socket socket = new Socket(host, port);

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        {
            outputStream.write(http.getBytes());
            outputStream.flush();
        }
        {
            byte[] bytes = inputStream.readAllBytes();
            http = new String(bytes);
        }
        socket.close();
        information.stringToHttp(http);
        return information;
    }
}
