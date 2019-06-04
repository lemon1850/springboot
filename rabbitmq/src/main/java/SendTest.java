import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.Executors;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-05-09
 * @Version 1.0
 */
public class SendTest {

    public static void main(String[] args)throws Exception {


        ConnectionFactory factory = new ConnectionFactory();
//        factory.setAutomaticRecoveryEnabled(true);
//        factory.setNetworkRecoveryInterval(1000);
//        factory.setHost("10.101.95.33");
//        factory.setPort(5672);
//        factory.setVirtualHost("stats");
//        factory.setUsername("vhost_stats_user");
//        factory.setPassword("HUtw9Qwi");
        factory.setUri("amqp://guest:guest@localhost:5672");

        Connection con = factory.newConnection();
        //customer推模式可使用这个线程池
//        factory.newConnection(Executors.newSingleThreadExecutor());
        Channel channel = con.createChannel();


        String exchangeName = "exchangename";
        String routingKey = "routingKey";
        String queueName = "queueName";
        channel.exchangeDeclare(exchangeName, "direct", true);
//        String tmpQueue = channel.queueDeclare().getQueue();
//        channel.queueBind(tmpQueue, exchangeName, routingKey);


        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);


        AMQP.Queue.DeclareOk declareOk = channel.queueDeclarePassive(queueName);
        System.out.println(declareOk.getMessageCount());
        System.out.println(declareOk.getConsumerCount());


        //delete
//        channel.queueDelete(queueName, true, true);
//        channel.queuePurge(queueName);
//        channel.queueDeclareNoWait();

        byte[] message = "hello, miaomi".getBytes();
        Map<String, Object> headers = new HashMap<>();
        headers.put("hello", "cat");
        headers.put("hello", "dog");
        BasicProperties basicProperties = new AMQP.BasicProperties.Builder()
                .contentType("text/plain")
                .deliveryMode(2)
                .priority(1)
                .userId("tianhe")
                .headers(headers)
                .expiration("60000")
                .build();

        channel.basicPublish(exchangeName, routingKey, true, MessageProperties.PERSISTENT_TEXT_PLAIN, message);



        boolean autoAck = false;


        //拉
        GetResponse response = channel.basicGet(queueName, autoAck);
        if(response == null){

        }else {
            System.out.println(new String(response.getBody()));
            System.out.println(response.getEnvelope().getDeliveryTag());
            channel.basicAck(response.getEnvelope().getDeliveryTag(), false);
        }

        //推
//        String customerTag = "wahaha CUstomerTag";
//        channel.basicConsume(queueName, autoAck, customerTag,
//                new DefaultConsumer(channel){
//                    @Override
//                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//
//                        long deliveryTag = envelope.getDeliveryTag();
//                        envelope.getExchange();
//                        envelope.getRoutingKey();
//
//                        channel.basicAck(deliveryTag, false);
//
//                    }
//                });


        //取消订阅
//        channel.basicCancel(customerTag);


        /**
         * 模仿发到一个没有绑定对应队列的rountingKey
         */
//        channel.basicPublish(exchangeName, routingKey+"gaoshi", true,null, "wahah,yaodiule".getBytes());
//
//        channel.addReturnListener(
//                new ReturnListener() {
//                    @Override
//                    public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
//
//                        System.out.println(new String(body));
//                    }
//                }
//        );

        con.addShutdownListener(new ShutdownListener() {
            @Override
            public void shutdownCompleted(ShutdownSignalException cause) {

                cause.getReason();

            }
        });
        Thread.sleep(100);

        new TreeSet().headSet(1);
        channel.confirmSelect();

        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {

                System.out.println("确认的： " + deliveryTag + "multiple: " + multiple);
            }

            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {

            }
        });
        for (int i = 1; i <= 1; i++) {
            long id = channel.getNextPublishSeqNo();
            System.out.println("准备发送的id" + id);
            channel.basicPublish(exchangeName, routingKey, null, "hello".getBytes());

        }

        Thread.sleep(1000);

//        channel.waitForConfirms();
        channel.close();
        con.close();

    }
}
