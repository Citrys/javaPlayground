package com.citrys.app.sqsConsumer;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import java.util.List;


class SQSConsumer {
    private AWSCredentials credentials = new BasicAWSCredentials(
            "AKIASRBLH6V2WZVJI3FL",
            "CiMISVv0dBejZD6rPw0QXEfkdtbCUw5POXqG7t0p"
    );

    private AmazonSQS sqs = AmazonSQSClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(Regions.US_EAST_1)
            .build();

    void messageConsumer() {
        System.out.println("Started consuming messages....");
        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest("https://sqs.eu-west-1.amazonaws.com/174036874613/uninode-qa-dev-test")
                .withWaitTimeSeconds(10)
                .withMessageAttributeNames(".*")
                .withMaxNumberOfMessages(10);

        List<Message> sqsMessages = sqs.receiveMessage(receiveMessageRequest).getMessages();

        for (Message m : sqsMessages) {
            m.getMessageAttributes().forEach( (k, v) -> System.out.println("Attribute values: " + v.toString()));
            System.out.println("message body: " + m.getBody());
            System.out.println(m);
        }
    }
}

class Boot {
    public  static void main(String [] args) throws InterruptedException {
        SQSConsumer sqsConsumer = new SQSConsumer();
        while (true) {
            Thread.sleep(1000);
            sqsConsumer.messageConsumer();
        }
    }
}
