package com.io.handsonWithWcnp1.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.io.handsonWithWcnp1.entity.Orders;
import com.io.handsonWithWcnp1.services.WcnpService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class WcnpServiceImpl implements WcnpService {

    Logger logger = LoggerFactory.getLogger(WcnpServiceImpl.class);

    @Override
    public String getOrdersDetails() {
        logger.info("method Started");
        String fileData = readFileData();
        logger.info("method Ends");
        return fileData;
    }

    @Override
    public Orders saveOrderDetails(Orders order) {
        logger.info("method Started");
        String fileData = readFileData();
        JSONObject json = new JSONObject();
        if (!fileData.equals("")) {
            try {
                json = new JSONObject(fileData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ObjectMapper om = new ObjectMapper();
        try {
            if (json.length() != 0)
                order.setId(json.getJSONArray("data").length() + 1);
            else
                order.setId(1);
            order.setOrderTime(String.valueOf(Instant.now().atOffset(ZoneOffset.UTC)));
            if (!new File("D:/order").exists())
                new File("D:/order").mkdirs();
            new File("D:/order/order.txt").createNewFile();
            JSONArray data = new JSONArray();
            for (int i = 0; i < json.getJSONArray("data").length(); i++) {
                data.put(json.getJSONArray("data").getJSONObject(i));
            }
            data.put(new JSONObject(om.writeValueAsString(order)));
            json.put("data", data);
            Files.write(Path.of("D:/order/order.txt"), json.toString().getBytes());
        } catch (IOException e) {
            logger.error("IOException occurred");
        } catch (JSONException e) {
            logger.error("JSONException occurred");
        }
        logger.info("method Ends");
        return order;
    }

    private String readFileData() {
        logger.info("method Started");
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get("D:/order/order.txt");
        try (Stream<String> stream = Files.lines(path)) {
            sb.append(stream.collect(Collectors.joining()));
        } catch (IOException e) {
            logger.error("File Not Found");
            sb.append(new JSONObject());
        }
        logger.info("Method Ends");
        return sb.toString();
    }
}
