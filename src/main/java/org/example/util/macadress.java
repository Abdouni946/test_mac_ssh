package org.example.util;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class macadress {

    public static String getMacAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface network = networkInterfaces.nextElement();

                if (network.isUp() && !network.isLoopback()) {
                    byte[] mac = network.getHardwareAddress();
                    if (mac != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < mac.length; i++) {
                            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                        }
                        return sb.toString();
                    }
                }
            }

        } catch (SocketException e) {
            return "Erreur lors de la récupération de l'adresse MAC: " + e.getMessage();
        }

        return "Aucune adresse MAC trouvée";
    }

}

