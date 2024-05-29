package com.work.vladimirs.service;

import com.deft.grpc.ProfileDescriptorOuterClass;
import com.deft.grpc.ProfileServiceGrpc;
import com.google.protobuf.Empty;
import io.grpc.*;
import io.grpc.stub.StreamObserver;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GrpcProfileClientServiceImpl {

    private static final String HOST = "localhost";
    private static final int PORT = 7777;
    private static final String TARGET = HOST + ":" + PORT;

    private final ProfileServiceGrpc.ProfileServiceBlockingStub blockingStub;
    private final ProfileServiceGrpc.ProfileServiceStub asyncStub;

    public GrpcProfileClientServiceImpl() {
        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        ManagedChannel channel = ManagedChannelBuilder.forTarget(TARGET)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build();
        blockingStub = ProfileServiceGrpc.newBlockingStub(channel);
        asyncStub = ProfileServiceGrpc.newStub(channel);
    }

    /**
     * Construct client for accessing HelloWorld server using the existing channel.
     */
    public GrpcProfileClientServiceImpl(Channel channel) {
        // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
        // shut it down.

        // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
        blockingStub = ProfileServiceGrpc.newBlockingStub(channel);
        asyncStub = ProfileServiceGrpc.newStub(ManagedChannelBuilder.forAddress(HOST, PORT).usePlaintext().build());
    }

    public void getCurrentProfile() {
        try {
            System.out.println("Will try to getCurrentProfile");
            Empty request = Empty.newBuilder().build();
            ProfileDescriptorOuterClass.ProfileDescriptor currentProfile = blockingStub.getCurrentProfile(request);
            System.out.println("Current profile: " + currentProfile.getName());
        } catch (StatusRuntimeException ex) {
            System.out.println("RPC failed: " + ex.getStatus());
            // do what you want with exception
        }
    }

    public void clientStream(int times) {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty profileDescriptor) {
                System.out.println("Finished responseObserver.clientStream");
            }

            @Override
            public void onError(Throwable t) {
                Status status = Status.fromThrowable(t);
                System.out.println("ClientStream Failed: " + status);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Finished ClientStream");
                finishLatch.countDown();
            }
        };

        StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> requestObserver = asyncStub.clientStream(responseObserver);
        try {
            // Send numPoints points randomly selected from the features list.
            Random rand = new Random();
            for (int i = 0; i < times; ++i) {
                ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor = ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setName("Client Profile")
                        .setProfileId(i)
                        .build();
                requestObserver.onNext(profileDescriptor);
                // Sleep for a bit before sending the next one.
                Thread.sleep(rand.nextInt(1000) + 500);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return;
                }
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        try {
            finishLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Если использовать blockingStub, то мы дожидаемся всех ответов от сервера и потом выводим их на экран
     */
    public void serverStreamBlockingStub() {
        Iterator<ProfileDescriptorOuterClass.ProfileDescriptor> profiles = Collections.emptyIterator();
        try {
            profiles = blockingStub.serverStream(Empty.newBuilder().build());
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
        }

        profiles.forEachRemaining(profileDescriptor ->
                System.out.println("Profile from server: " + profileDescriptor.getProfileId()));
    }

    public void serverStreamAsyncStub() {
        System.out.println("*** ServerStreamAsyncStub");

        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> requestObserver =
                asyncStub.biDirectionalStream(new StreamObserver<>() {
                    @Override
                    public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                        System.out.println("Got message Profile Id " + profileDescriptor.getProfileId());
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("ServerStreamAsyncStub Failed: " + Status.fromThrowable(t));
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Finished ServerStreamAsyncStub");
                        finishLatch.countDown();
                    }
                });

        asyncStub.serverStream(Empty.newBuilder().build(), requestObserver);

        // Receiving happens asynchronously
        try {
            finishLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void biDirectionalStream() {
        System.out.println("*** BiDirectionalStream");

        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> requestObserver =
                asyncStub.biDirectionalStream(new StreamObserver<>() {
                    @Override
                    public void onNext(ProfileDescriptorOuterClass.ProfileDescriptor profileDescriptor) {
                        System.out.println("Got message Profile Id " + profileDescriptor.getProfileId());
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("BiDirectionalStream Failed: " + Status.fromThrowable(t));
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("Finished BiDirectionalStream");
                        finishLatch.countDown();
                    }
                });

        try {
            for (int i = 0; i < 5; i++) {
                ProfileDescriptorOuterClass.ProfileDescriptor build = ProfileDescriptorOuterClass.ProfileDescriptor
                        .newBuilder()
                        .setProfileId(i)
                        .build();
                requestObserver.onNext(build);

            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        try {
            finishLatch.await(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
