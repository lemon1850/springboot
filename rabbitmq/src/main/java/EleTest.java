import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * @Author: weiqiang.lin
 * @Date: 2019-05-10
 * @Version 1.0
 */
public class EleTest {


    public static void main(String[] args)  throws  Exception{

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ConnectionFactory factory = new ConnectionFactory();
        factory.setAutomaticRecoveryEnabled(true);
        factory.setNetworkRecoveryInterval(1000);
        factory.setHost("10.101.95.33");
        factory.setPort(5672);
        factory.setVirtualHost("stats");
        factory.setUsername("vhost_stats_user");
        factory.setPassword("HUtw9Qwi");

        Connection connection = factory.newConnection();
        Channel channel= connection.createChannel();
        GetResponse response = channel.basicGet("shopDiagnosis", false);

//        System.out.println(new String(response.getBody()));
//        ShopDiagnosisMessageDTO dto = gson.fromJson(new String(response.getBody()), ShopDiagnosisMessageDTO.class);
////
        ShopDiagnosisMessageDTO dto = JSON.parseObject(new String(response.getBody()), ShopDiagnosisMessageDTO.class);
        System.out.println(JSON.toJSONString(dto, true));
        List<DiagnosisItemMessageDTO> items = dto.getItems();
        System.out.println(new BigDecimal(items.get(0).getData()).setScale(1, RoundingMode.HALF_UP).doubleValue());
//        List<DiagnosisItemMessageDTO> items =  dto.getItems();

    }
}
