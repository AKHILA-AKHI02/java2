class Packet {
int seqNum;
String data;
public Packet(int seqNum, String data) {
this.seqNum = seqNum;
this.data = data;
}
}
class Sender {
private int totalPackets = 5;
private int seqNum = 0;
public void sendPackets() {
while (seqNum < totalPackets) {
Packet packet = new Packet(seqNum, "Packet " + seqNum);
System.out.println("Sender: Sending " + packet.data);
boolean ackReceived = Receiver.receive(packet);
if (ackReceived) {
System.out.println("Sender: ACK received for packet " + seqNum + "\n");
seqNum++;
} else {
System.out.println("Sender: Timeout! Resending packet " + seqNum + "\n");
}
}
}
}
class Receiver {
public static boolean receive(Packet packet) {
System.out.println("Receiver: Received " + packet.data);
// Simulate ACK loss or success
boolean ack = Math.random() > 0.2; // 80% chance of success
if (ack) {
System.out.println("Receiver: Sending ACK for packet " + packet.seqNum);
} else {
System.out.println("Receiver: ACK lost for packet " + packet.seqNum);
}
return ack;
}
}
public class StopAndWait {
public static void main(String[] args) {
Sender sender = new Sender();
sender.sendPackets();
}
}