package com.example.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

/**
 * @author Ataev Ismayyl (issyataew@gmail.com)
 * class intended save Connect
 * */

public class ConnectDate {

   private int port = 0;

   private InetAddress ip;

   public ConnectDate() {
   }

   public ConnectDate(int port) {
      this.port = port;
   }

   public ConnectDate(int port, InetAddress ip) {
      this.port = port;
      this.ip = ip;
   }

   public int getPort() {
      return port;
   }

   public void setPort(int port) {
      this.port = port;
   }

   public InetAddress getIp() {
      return ip;
   }

   public void setIp(InetAddress ip) {
      this.ip = ip;
   }

   public static InetAddress getThisLocalHost() throws UnknownHostException {
      return InetAddress.getLocalHost();
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ConnectDate that = (ConnectDate) o;
      return port == that.port && Objects.equals(ip, that.ip);
   }

   @Override
   public int hashCode() {
      return Objects.hash(port, ip);
   }

   @Override
   public String toString() {
      return "ConnectDate{" +
              "port=" + port +
              ", ip=" + ip +
              '}';
   }
}
