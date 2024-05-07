package nicholasboari.com.attusteste.util;

import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.response.AddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.CreateAddressResponseDTO;
import nicholasboari.com.attusteste.model.Address;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;

public class AddressCreator {

    public static Address createAValidAddress(){
        return Address.builder()
                .id("229bd123-2881-4960-b890-a3920eb159fe")
                .city("Sao Paulo")
                .zipCode("12000-111")
                .number(99)
                .publicPlace("Rua Faria Lima")
                .primaryAddress(true)
                .state(BrazilStatesEnum.AL)
                .build();
    }

    public static AddressResponseDTO createAValidAddressResponseDTO(){
        return AddressResponseDTO.builder()
                .id("229bd123-2881-4960-b890-a3920eb159fe")
                .city("Sao Paulo")
                .zipCode("12000-111")
                .number(99)
                .publicPlace("Rua Faria Lima")
                .primaryAddress(true)
                .state(BrazilStatesEnum.AL)
                .build();
    }

    public static CreateAddressRequestDTO createAValidAddressRequestDTO(){
        return CreateAddressRequestDTO.builder()
                .personID("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .city("Sao Paulo")
                .zipCode("12000-111")
                .number(99)
                .publicPlace("Rua Faria Lima")
                .primaryAddress(false)
                .state(BrazilStatesEnum.AL)
                .build();
    }

    public static CreateAddressResponseDTO createAValidCreateAddressResponseDTO(){
        return CreateAddressResponseDTO.builder()
                .personID("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .city("Sao Paulo")
                .zipCode("12000-111")
                .number(99)
                .publicPlace("Rua Faria Lima")
                .primaryAddress(true)
                .state(BrazilStatesEnum.AL)
                .build();
    }

    public static UpdateAddressRequestDTO updateAddressRequestDTO(){
        return UpdateAddressRequestDTO.builder()
                .id("229bd123-2881-4960-b890-a3920eb159fe")
                .personID("426f80c0-6c7d-4b2a-9835-199e37e0c5a4")
                .city("Sao Paulo")
                .zipCode("12000-111")
                .number(99)
                .publicPlace("Rua Faria Lima")
                .primaryAddress(true)
                .state(BrazilStatesEnum.AL)
                .build();
    }

}
