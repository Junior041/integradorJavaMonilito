package com.ismaeldev.integrador.infra.Security;

import com.ismaeldev.integrador.domain.Store.Store;
import com.ismaeldev.integrador.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class VerifyTokenWithStoreId {
    private static StoreRepository storeRepository;

    @Autowired
    public VerifyTokenWithStoreId(StoreRepository storeRepository) {
        VerifyTokenWithStoreId.storeRepository = storeRepository;
    }

    public static void verify(Long storeId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Store store = (Store) storeRepository.findStoreByUsername(userDetails.getUsername());

            if (userDetails.getUsername() == null || store == null || !store.getStoreId().equals(storeId)){
                throw new Exception("Store not found");
            }
        }else{
            throw new Exception("Store not found");
        }

    }
}
