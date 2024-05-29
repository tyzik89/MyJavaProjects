package com.work.vladimirs.service;

import com.deft.grpc.ProfileDescriptorOuterClass;
import com.deft.grpc.ProfileServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GrpcService extends ProfileServiceGrpc.ProfileServiceImplBase {

    private static Logger LOGGER = Logger.getLogger(GrpcService.class.getName());


    /**
     * Запрос-ответ
     */
    @Override
    public void getCurrentProfile(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        LOGGER.info("getCurrentProfile");
        // При реквесте от клиента - сервер создаёт новый респонс с профилем '1' и именем 'test'
        responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                .newBuilder()
                .setProfileId(1)
                .setName("test")
                .build());
        responseObserver.onCompleted();
    }

    /**
     * Запрос-ответ
     */
    @Override
    public void deleteCurrentProfile(Empty request, StreamObserver<Empty> responseObserver) {
        System.out.println("deleteCurrentProfile");
        // При реквесте от клиента - сервер удаляет требуемые данные, например из БД
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    /**
     * Клиент стрим
     * При таком типе запросов, клиент может посылать сообщения-запросы, а сервер реагировать на каждое из них и/или,
     * при поступлении всех клиентских сообщений, обработать их.
     */
    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> clientStream(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<>() {
            int pointCount = 0;
            /**
             * В этот метод будут приходить сообщения от клиента.
             */
            @Override
            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                pointCount++;
                LOGGER.info("ProfileDescriptor from client. Profile id: " + profileDescriptor.getProfileId()
                + "pointCount: " + pointCount);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * Сервер стрим
     * В данном типе запросов, после того как клиент послал сообщение запрос, сервер начинает посылать данные для клиента.
     */
    @Override
    public void serverStream(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        // После открытия стрима, сервер посылает 5 ответов. В каком последующем ответе найди профиля увеличивается.
        for (int i = 0; i < 5; i++) {
            responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                    .newBuilder()
                    .setProfileId(i)
                    .build());
        }
        responseObserver.onCompleted();
    }

    /**
     * Двунаправленный стрим
     * В таком типе запросов клиент и сервер могут постоянно обмениваться сообщениями не блокируя друг друга.
     */
    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> biDirectionalStream(StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        return new StreamObserver<>() {
            int pointCount = 0;

            /**
             * В ответ на сообщение клиента, сервер будет посылать новый профиль с увеличенным счетчиком pointCount.
             */
            @Override
            public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                LOGGER.info("biDirectionalStream, pointCount " + pointCount);
                responseObserver.onNext(ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setProfileId(pointCount++)
                        .build());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
