package nicholasboari.com.attusteste.util;

import nicholasboari.com.attusteste.model.Address;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;

import java.util.UUID;

public class AddressCreator {

    public static Address createAValidAddressResponseDTO(){
        return Address.builder()
                .id(UUID.randomUUID().toString())
                .city("Sao Paulo")
                .zipCode("12000-111")
                .number(99)
                .publicPlace("Rua Faria Lima")
                .primaryAddress(true)
                .state(BrazilStatesEnum.AL)
                .build();
    }
}
