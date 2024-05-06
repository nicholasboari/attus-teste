package nicholasboari.com.attusteste.service;

import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.response.AddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.CreateAddressResponseDTO;
import nicholasboari.com.attusteste.dto.response.UpdateAddressResponseDTO;
import nicholasboari.com.attusteste.model.Address;
import nicholasboari.com.attusteste.model.BrazilStatesEnum;
import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.repository.AddressRepository;
import nicholasboari.com.attusteste.repository.PersonRepository;
import nicholasboari.com.attusteste.util.AddressCreator;
import nicholasboari.com.attusteste.util.PersonCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @InjectMocks
    private AddressService addressService;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonService personService;

    @Mock
    private ModelMapper modelMapper;

    CreateAddressResponseDTO createAddressResponseDTO;
    CreateAddressRequestDTO createAddressRequestDTO;
    AddressResponseDTO addressResponseDTO;
    Page<Address> addressPage;
    Address address;

    @BeforeEach
    void setup() {
        createAddressResponseDTO = AddressCreator.createAValidCreateAddressResponseDTO();
        createAddressRequestDTO = AddressCreator.createAValidAddressRequestDTO();
        addressResponseDTO = AddressCreator.createAValidAddressResponseDTO();
        address = AddressCreator.createAValidAddress();

        addressPage = new PageImpl<>(List.of(address));

        Mockito.when(modelMapper.map(Mockito.any(CreateAddressRequestDTO.class), Mockito.eq(Address.class))).thenReturn(address);
        Mockito.when(modelMapper.map(Mockito.any(Address.class), Mockito.eq(CreateAddressResponseDTO.class))).thenReturn(createAddressResponseDTO);
        Mockito.when(modelMapper.map(Mockito.any(Address.class), Mockito.eq(AddressResponseDTO.class))).thenReturn(addressResponseDTO);
        Mockito.when(modelMapper.map(Mockito.any(UpdateAddressRequestDTO.class), Mockito.eq(Address.class))).thenReturn(address);

    }

    @Test
    @DisplayName("Create a new address")
    void create_ShouldCreateNewAddress() {
        Mockito.when(personService.findByID(createAddressRequestDTO.getPersonID())).thenReturn(PersonCreator.personResponseDTO());
        Mockito.when(addressRepository.save(Mockito.any(Address.class))).thenReturn(AddressCreator.createAValidAddress());

        Mockito.when(addressRepository.findAddressByPersonId(Mockito.any(Pageable.class), Mockito.anyString())).thenReturn(addressPage);

        CreateAddressResponseDTO response = addressService.create(createAddressRequestDTO);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Find an address by ID")
    void findById_ShouldReturnAddress_WhenIdExists() {
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        String id = "229bd123-2881-4960-b890-a3920eb159fe";
        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        AddressResponseDTO response = addressService.findByID(id);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Find all addresses")
    void findAll_ShouldReturnAllAddresses() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Address> addressList = Arrays.asList(address, address, address);
        Page<Address> addressPage = new PageImpl<>(addressList);

        Mockito.when(addressRepository.findAll(pageable)).thenReturn(addressPage);

        Page<AddressResponseDTO> response = addressService.findAll(pageable);

        Assertions.assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Update an address")
    void update_ShouldUpdateAddress_WhenIdExists() {
        Mockito.when(addressRepository.save(address)).thenReturn(address);

        String id = "229bd123-2881-4960-b890-a3920eb159fe";
        UpdateAddressRequestDTO request = UpdateAddressRequestDTO.builder().id(id).personID("validId").primaryAddress(false).city("Sao Paulo").zipCode("12000-111").number(99).publicPlace("Rua Faria Lima").state(BrazilStatesEnum.AL).build();

        Mockito.when(addressRepository.findById(id)).thenReturn(Optional.of(address));

        AddressResponseDTO response = addressService.update(request);

        Assertions.assertThat(response).isNotNull();
    }
}