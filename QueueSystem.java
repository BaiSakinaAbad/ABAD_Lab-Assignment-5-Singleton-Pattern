import java.util.LinkedList;
import java.util.Queue;

class QueueSystem {
    private static QueueSystem instance;
    private int currentNumber;
    private Queue<Integer> waitingLine;    // store queue
    private boolean isPaused;              // Pause helping uh

    // Private constructor
    private QueueSystem() {
        currentNumber = 1;
        waitingLine = new LinkedList<>();
        isPaused = false;
    }

    //single instance Singleton
    public static QueueSystem getInstance() {
        if (instance == null) {
            instance = new QueueSystem();
        }
        return instance;
    }

    public synchronized int requestQueueNum(int deskId) {
        if (isPaused) {
            System.out.println("Help desk " + deskId + ": Cannot issue, queue is paused.");
            return -1;
        }
        int number = currentNumber++;
        waitingLine.add(number);
        System.out.printf("Help desk %d: Issued number %02d%n", deskId, number);
        return number;
    }

    public synchronized void getQueueNum() {
        System.out.print("\nqueue waiting line: ");
        if (waitingLine.isEmpty()) {
            System.out.println();
        } else {
            for (int num : waitingLine) {
                System.out.print(String.format("%02d ", num));
            }
            System.out.println("\n");
        }
    }


    public synchronized void resetQueue(int deskId) {
        System.out.printf("Help desk %d request resetQueue%n%n", deskId);
        waitingLine.clear();
        currentNumber = 1;
        getQueueNum();
    }

    public synchronized void pauseQueue(int deskId) {
        isPaused = true;
        System.out.printf("Help desk %d request pauseQueue%n", deskId);
        System.out.println("Pausing the queue for reorganization....");
    }

}