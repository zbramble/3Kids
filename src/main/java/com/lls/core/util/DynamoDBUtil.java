package com.lls.core.util;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import java.util.HashMap;
import java.util.Map;

public class DynamoDBUtil {

    public static void test() {
        System.out.println("Test");
    }

    public static void writeToDynamoDB() {
        DynamoDbClient dynamoDb = DynamoDbClient.builder()
                .region(Region.US_WEST_2)
                .credentialsProvider(ProfileCredentialsProvider.create("default")) // Change to your region
                .build();

        // 2. Define Table Name
        String tableName = "Users";

        // 3. Create Item (Key-Value Pairs)
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("UserId", AttributeValue.builder().s("12345").build()); // Primary Key
        item.put("Name", AttributeValue.builder().s("John").build());
        item.put("Age", AttributeValue.builder().n("30").build());
        item.put("Email", AttributeValue.builder().s("john@example.com").build());

        // Map<String, AttributeValue> item = new HashMap<>();
        // item.put("PrimaryKey",
        // AttributeValue.builder().s("YourPrimaryKeyValue").build());
        // item.put("Attribute1", AttributeValue.builder().s("Value1").build());
        // item.put("Attribute2", AttributeValue.builder().n("123").build());

        // 4. Create PutItemRequest
        PutItemRequest request = PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build();

        // // 5. Write Data to DynamoDB
        dynamoDb.putItem(request);
        System.out.println("✅ Data inserted successfully!");
    }
}
