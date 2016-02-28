//Chapter 23 - Exercise 23.1

public class QueueTester
{
	private static int QUEUE_SIZE = 10;
	private static int ITERATION = 1000;
	
	public static void main (String[] args)
	{
		Queue q = new Queue(QUEUE_SIZE);
		ProducerThread producer = new ProducerThread(q, ITERATION);
		ConsumerThread consumer = new ConsumerThread(q, ITERATION);
		producer.start();
		consumer.start();
	}
}