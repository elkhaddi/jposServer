package com.server.serversimulator;

import org.jpos.iso.*;

import java.io.IOException;

public class RequestListener implements ISORequestListener {
    @Override
    public boolean process(ISOSource source, ISOMsg m) {
        try {
            if (m.getMTI().equals("1800")){
                System.out.println("Demande de connexion : " + m);
                ISOMsg connectResp = (ISOMsg) m.clone();
                connectResp.setMTI("1810"); // Set the response MTI
                connectResp.set(39, "00"); // Set the response code to "00"
                // Send the response message back to the client
                System.out.println(connectResp.getString(39));
                source.send(connectResp);
                System.out.println(connectResp.getString(39));
            }
            if (m.getMTI().equals("1200")){
                System.out.println("Demande de transaction : " + m);
                ISOMsg transResp = (ISOMsg) m.clone();
                transResp.setMTI("1210"); // Set the response MTI
                transResp.set(39, "00"); // Set the response code to "00"
                // Send the response message back to the client
                source.send(transResp);
            }
        } catch (ISOException | IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
