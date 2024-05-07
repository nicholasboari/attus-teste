package nicholasboari.com.attusteste.controller;

import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.CreatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdatePersonRequestDTO;
import nicholasboari.com.attusteste.dto.response.AddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.CreateAddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.CreatePersonResponseDTO;
import nicholasboari.com.attusteste.dto.response.PersonResponseDTO;
import nicholasboari.com.attusteste.service.AddressService;
import nicholasboari.com.attusteste.service.PersonService;
import nicholasboari.com.attusteste.util.AddressCreator;
import nicholasboari.com.attusteste.util.PersonCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
class AddressControllerTest {


    @InjectMocks
    private AddressController addressController;

    @Mock
    private AddressService addressService;

    private Pageable pageable;

    @BeforeEach
    void setup() {
        pageable = PageRequest.of(0, 3);
    }

    @Test
    @DisplayName("Returns page of addresses inside page object when successful")
    void findAll_ReturnsPageOfAddresses_WhenSuccessful() {
        Page<AddressResponseDTO> addressPage = new PageImpl<>(Collections.singletonList(AddressCreator.createAValidAddressResponseDTO()));
        Mockito.when(this.addressService.findAll(pageable)).thenReturn(addressPage);

        ResponseEntity<Page<AddressResponseDTO>> responseEntity = addressController.findAll(pageable);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getContent()).isNotEmpty();
    }

    @Test
    @DisplayName("Returns page of addresses by person ID inside page object when successful")
    void findAllByPersonID_ReturnsPageOfAddressesByPersonID_WhenSuccessful() {
        String personId = "validPersonId";
        Page<AddressResponseDTO> addressPage = new PageImpl<>(Collections.singletonList(AddressCreator.createAValidAddressResponseDTO()));
        Mockito.when(this.addressService.findByPersonID(pageable, personId)).thenReturn(addressPage);

        ResponseEntity<Page<AddressResponseDTO>> responseEntity = addressController.findAllByPersonID(pageable, personId);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getContent()).isNotEmpty();
    }

    @Test
    @DisplayName("Returns an address when findById is called with a valid ID")
    void findById_ReturnsAddress_WhenSuccessful() {
        String addressId = "229bd123-2881-4960-b890-a3920eb159fe";
        AddressResponseDTO expectedAddress = AddressCreator.createAValidAddressResponseDTO();
        Mockito.when(this.addressService.findByID(addressId)).thenReturn(expectedAddress);

        ResponseEntity<AddressResponseDTO> responseEntity = addressController.findByID(addressId);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(addressId);
    }

    @Test
    @DisplayName("Creates a new address when save is called with a valid DTO")
    void create_CreatesNewAddress_WhenSuccessful() {
        CreateAddressRequestDTO validAddressDTO = AddressCreator.createAValidAddressRequestDTO();
        CreateAddressResponseDTO expectedAddress = AddressCreator.createAValidCreateAddressResponseDTO();

        Mockito.when(this.addressService.create(validAddressDTO)).thenReturn(expectedAddress);

        ResponseEntity<CreateAddressResponseDTO> responseEntity = addressController.create(validAddressDTO);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(expectedAddress.getId());
    }

    @Test
    @DisplayName("Updates an address when update is called with a valid DTO")
    void update_UpdatesAddress_WhenSuccessful() {
        UpdateAddressRequestDTO validAddressDTO = AddressCreator.updateAddressRequestDTO();
        AddressResponseDTO expectedAddress = AddressCreator.createAValidAddressResponseDTO();

        Mockito.when(this.addressService.update(validAddressDTO)).thenReturn(expectedAddress);

        ResponseEntity<AddressResponseDTO> responseEntity = addressController.update(validAddressDTO);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(responseEntity.getBody()).isNotNull();
        Assertions.assertThat(responseEntity.getBody().getId()).isEqualTo(expectedAddress.getId());
    }
}