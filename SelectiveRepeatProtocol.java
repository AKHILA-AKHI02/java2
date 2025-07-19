import java.util.Random; import java.util.Scanner;

public class SelectiveRepeatProtocol { 
    static final int MAX_FRAMES = 15; 
    static final int WINDOW_SIZE = 4; 
    static double LOSS_PROBABILITY = 0.1; // 0.5% probability 
    static boolean[] acked = new boolean[MAX_FRAMES];

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    System.out.println("Simulating Selective Repeat ARQ Protocol");
    System.out.println("Window size: " + WINDOW_SIZE);
    System.out.println("Total frames to be sent: " + MAX_FRAMES);
    System.out.println("Loss probability: 0.5%\n");

    int sendBase = 0;
    int nextSeqNum = 0;

    while (sendBase < MAX_FRAMES) {
        // Sending frames within window
        while (nextSeqNum < sendBase + WINDOW_SIZE && nextSeqNum < MAX_FRAMES) {
            sendFrame(nextSeqNum, random);
            nextSeqNum++;
        }

        // Receiving ACKs
        for (int i = sendBase; i < nextSeqNum; i++) {
            if (!acked[i]) {
                boolean ack = receiveAck(i, random);
                if (ack) {
                    System.out.println("Acknowledgment for frame " + i + " received.");
                    acked[i] = true;
                } else {
                    System.out.println("Acknowledgment for frame " + i + " lost.");
                }
            }
        }

        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();

        // Slide window
        while (sendBase < MAX_FRAMES && acked[sendBase]) {
            sendBase++;
        }

        // Retransmit lost frames
        for (int i = sendBase; i < nextSeqNum; i++) {
            if (!acked[i]) {
                sendFrame(i, random);
            }
        }
    }

    System.out.println("\nAll frames have been successfully sent and acknowledged!");
}

static void sendFrame(int frame, Random random) {
    System.out.println("Sending frame " + frame);
    if (random.nextDouble() < LOSS_PROBABILITY) {
        System.out.println("Frame " + frame + " lost.");
    } else {
        System.out.println("Frame " + frame + " sent successfully.");
    }
}

static boolean receiveAck(int frame, Random random) {
    // Simulate ACK loss
    return random.nextDouble() >= LOSS_PROBABILITY;
}

}