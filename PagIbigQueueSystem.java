public class PagIbigQueueSystem {
    public static void main(String[] args) {
        QueueSystem queue = QueueSystem.getInstance();

        queue.requestQueueNum(1); // Help desk 1
        queue.requestQueueNum(2); // Help desk 2
        queue.requestQueueNum(3); // Help desk 3
        queue.getQueueNum();

        queue.resetQueue(1);

        queue.requestQueueNum(2);
        queue.requestQueueNum(2);
        queue.getQueueNum();

        queue.requestQueueNum(3);
        queue.pauseQueue(1);
        queue.getQueueNum();

     //   queue.resetQueue(2);

       // queue.requestQueueNum(1);


    }
}
