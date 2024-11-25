package com.sadlier.sadlier_account;

import com.sadlier.account.AccountProto;
import com.sadlier.account.AccountServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AccountServiceImpl extends AccountServiceGrpc.AccountServiceImplBase {
    @Override
    public void getUserInfo(AccountProto.UserRequest request, StreamObserver<AccountProto.UserResponse> responseObserver) {
        AccountProto.UserResponse response = AccountProto.UserResponse.newBuilder()
                .setUserId(request.getUserId())
                .setName("John Doe")
                .setEmail("johndoe@example.com")
                .build();

        // Trả kết quả về client
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
