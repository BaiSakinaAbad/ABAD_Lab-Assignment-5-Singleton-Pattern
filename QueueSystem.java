
class QueueSystem {
    private static QueueSystem instance;
    private int currentNumber;             // Current queue number
    private String waitingLine;
    private boolean isPaused;              // Pause helper

    //  constructor
    private QueueSystem() {
        currentNumber = 1;
        waitingLine = "";
        isPaused = false;
    }

    // ingle instance
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
        System.out.printf("Help desk %d: Issued number %02d%n", deskId, number);
        waitingLine += String.format("%02d ", number);
        return number;
    }


    public synchronized void getQueueNum() {
        System.out.print("\nqueue waiting line: ");
        System.out.println(waitingLine + "\n");
    }


    public synchronized void resetQueue(int deskId) {
        System.out.printf("Help desk %d request resetQueue%n%n", deskId);
        waitingLine = "";
        currentNumber = 1;
        getQueueNum();
    }

    public synchronized void pauseQueue(int deskId) {
        isPaused = true;
        System.out.printf("Help desk %d request pauseQueue%n", deskId);
        System.out.println("Pausing the queue for reorganization....\n");
    }

}