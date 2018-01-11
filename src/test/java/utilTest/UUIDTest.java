package utilTest;

import com.txzhe.utils.HashRouterUtils;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args){
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        System.out.println(HashRouterUtils.hash("bca1acfeb2034cf3a595f06a77da7952",2));
    }
}
