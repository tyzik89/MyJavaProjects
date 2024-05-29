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

    @Override
    public void getCurrentProfile(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        super.getCurrentProfile(request, responseObserver);
    }

    @Override
    public void deleteCurrentProfile(Empty request, StreamObserver<Empty> responseObserver) {
        super.deleteCurrentProfile(request, responseObserver);
    }

    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> clientStream(StreamObserver<Empty> responseObserver) {
        return super.clientStream(responseObserver);
    }

    @Override
    public void serverStream(Empty request, StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        super.serverStream(request, responseObserver);
    }

    @Override
    public StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> biDirectionalStream(StreamObserver<ProfileDescriptorOuterClass.ProfileDescriptor> responseObserver) {
        return super.biDirectionalStream(responseObserver);
    }
}
